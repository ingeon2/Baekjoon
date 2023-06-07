class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        
        //오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.
        
        //today 오늘날짜, terms 약관 알파벳과 띄어쓰기 개월수, privacies 년.월.일 띄어쓰기 약관 알파벳
        
        //오늘날짜 - 파기일자(약관마다 다름, 수집일자 + 약관지정개월수) 가 양수이면 파기x 파기o이면 결과에 넣어주기
        //privacies 순회하면서 숫자 넣어줘야겠는데
        String answer = "";
        
        //이제 today 배열로 만들어주고, 나중에 for문에서 각각 privacy 배열0 1 2 + (policy * 28) 빼줄거.
        String[] today_arr = today.split("[.]");
        //빼주고 
        int year = (Integer.parseInt(today_arr[0])) * 336;
        int month = (Integer.parseInt(today_arr[1])) * 28;
        int day = (Integer.parseInt(today_arr[2]));
        
        int a = 1;
        //여기까지 초기값.
        
        
        for(String privacy : privacies){
            
            
            //split 으로 privacy("2021.05.02 A")를 .과 띄어쓰기 쪼개주고 배열에 넣기
            //그럼privacy_arr[0] 부터 차례대로 년 월 일 약관
            String[] privacy_arr = privacy.split("[.]| ");
            
            
            int policy = 0; //여기에 맞는 terms 할당시킬 예정
            // 어떻게? terms 순회하며 첫글자 equals로 privacy_arr의 네번째 약관과 같으면 
            //subst 2,3 으로 할당
            for(String t : terms){
                if(t.substring(0,1).equals(privacy_arr[3])){
                    policy = Integer.parseInt(t.substring(2));
                    break;
                }
            }
            
            //처음의 year month day 이용해서 privacy 배열0 1 2 + (policy * 28) 빼줄거.
            //빼주고 
            int new_year = Integer.parseInt(privacy_arr[0]) * 336;
            int new_month = Integer.parseInt(privacy_arr[1]) * 28;
            int new_day = Integer.parseInt(privacy_arr[2]);
            int result = (year + month + day) - (new_year + new_month + new_day) - (policy*28) + 1;
            
            //년*336(월을 28으로 고정햇으니) 월*28 일 더한것 > 0 이라면 보관불가능이니  answer에 추가
            if(result > 0){
                answer += String.valueOf(a);
                answer += "/";
            }
            a++;
        }
        
        //숫자 / 숫자 / 이런식으로 answer 구성. answer의 숫자를 int[] 넣어줘야함
        String[] answer_arr = answer.split("/");
        int[] result = new int[answer_arr.length];
        for(int i = 0 ; i < answer_arr.length ; i++){
            result[i] = Integer.parseInt(answer_arr[i]);
        }
        
        return result;
    }
}