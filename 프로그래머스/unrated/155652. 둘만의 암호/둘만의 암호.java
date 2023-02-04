class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
    
        //s 를 skip에 있는 친구들 제외하고 index만큼 증가시켜서 answer 구성하기
        
        //알파벳 만들고, 
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        //skip에 있는 친구들 alphabets에서 삭제
        String[] skip_arr = new String[skip.length()];
        for(int i = 0 ; i < skip.length() ; i++){
            skip_arr[i] = skip.substring(i, i+1);
        }
        for(String want_skip: skip_arr){
            alphabets = alphabets.replace(want_skip, "");
        }
        //s 순회하며 (아래 한꺼번에 다하기)
        String[] s_arr = new String[s.length()];
        for(int i = 0 ; i < s.length() ; i++){
            s_arr[i] = s.substring(i, i+1);
        }
        for(String want_change : s_arr){
            //indexOf 사용할때 나오는 숫자 + 매개변수 index 하면 나오는 숫자를 x
            //x % 알파벳 길이 로 나오는 숫자를 alphabet의 substring 하면 알파벳 변환 완료
            int x = (alphabets.indexOf(want_change) + index) % alphabets.length();
            //그렇게 변환해서 answer에 추가!
            answer += alphabets.substring(x, x+1);
        }
        
        
        //return answer;
        return answer;
    }
}