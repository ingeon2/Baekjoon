import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] mail = new int[id_list.length];
        
        //HashMap<신고당한놈, 신고한 이름들 hashset> 응애1 
        //이름들은 중복이 없어야하니까 hashset으로
        HashMap<String, HashSet<String>> report_map = new HashMap<String, HashSet<String>>();
        
        //정담으로 제출할 mail 의 index 에 사용해주기 위해 HashMap<이름, 인덱스> 응애2  선언하기
        HashMap<String, Integer> for_index = new HashMap<String, Integer>();
        
        //for문으로 순회하며 (id_list)
        for(int i = 0 ; i < id_list.length ; i++){
            String name = id_list[i];
            //응애1 초깃값 선언 .put(name, 뉴 해시셋)
            report_map.put(name, new HashSet<>());
            //응애2 초깃값 대입 .put(name, i(index))
            for_index.put(name, i);
        }
        
        
        
        //리포트("보낸놈 받은놈") 순회하며 
        for(String re : report){ // "보낸놈 받은놈"  이라서 0이 보낸놈 1이 받은놈
            //응애1.get(받은놈).add(보낸놈) 해주고 (set이니 중복 x), (split으로.)
            String sender = re.split(" ")[0];
            String receiver = re.split(" ")[1];
            report_map.get(receiver).add(sender);
        }
        
       
        
        //이제 id_list 만큼 for문 순회하며
        for(int i = 0 ; i < id_list.length ; i++){
            //응애1의 key가 id_list[i]인 해쉬셋 빼와서 (해쉬셋 씨팔) = (id_list[i] 이름을 신고한 놈들)
            HashSet<String> bad_guys = report_map.get(id_list[i]);
            //그 해시셋 크기가 k 이상이다면 (서로 다른 신고한 사람 수가 k명 이상이라면)
            if(bad_guys.size() >= k){
                //for문으로 (해쉬셋 씨팔) = 응애1.get(id_list[i]) 순회(String s)하며 
                for(String s : bad_guys){
                    //mail[응애2.get(s)]++; (index 를 위해 만든 해시셋 사용하여
                    //신고한 놈들에게 메일 한통씩 보내기)
                    mail[for_index.get(s)]++;
                }
                
            }
           
        }
        return mail;
    }
}