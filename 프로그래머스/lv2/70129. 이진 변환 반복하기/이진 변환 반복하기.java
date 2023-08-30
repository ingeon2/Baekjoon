class Solution {
    static int[] answer = {0, 0};
    public int[] solution(String s) {
        
        while(true) {
            int num = destroy0(s);
            s = binary(num);
            answer[0]++;
            if(s.equals("1")) break;
        }
        
        return answer;
    }
    
    static int destroy0(String s) { //String에서 0 없에기
        String a = s.replace("0", "");
        int num = s.length() - a.length();
        answer[1] += num;
        return a.length();
        
    }
    
    static String binary(int num) { //숫자를 2진수 String으로 반환
        if(num == 1) return "1";
        
        int v = 1;
        int l = 0;
        
        while(true) {
            v = 2*v;
            l++;
            if(v > num) break;
        }
        
        char[] arr = new char[l];
        
        
        
        while(num > 1) {
            int b = 1;
            int c = 0;
            
            while(true) {
                b = 2*b;
                c++;
                if(num <= b) break;
            }
            
            if(num != b) {
                b = b/2;
                c--;
            }
            
            num = num-b;
            arr[l-c-1] = '1';
        }
        
        if(num == 1) arr[l-1] = '1';
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] != '1') {
                arr[i] = '0';
            }
        }
        
        String s = new String (arr);
        System.out.println(s);
        
        return s;
    }
}