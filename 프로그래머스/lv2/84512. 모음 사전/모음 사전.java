import java.util.*;

class Solution {
    static String[] alpha = {"A", "E", "I", "O", "U"};
    static ArrayList<String> arr = new ArrayList<>();
    public int solution(String word) {
        backTracking(0, 5, "");
        int answer = arr.indexOf(word) + 1;
        return answer;
        
    }
    
    static void backTracking(int d, int n, String s) {
        if(d == 5) {
            arr.add(s);
            return;
        }
        
        if(s.length() != 0) arr.add(s);
        
        for(int i = 0 ; i < 5 ; i++) {
            s += alpha[i];
            backTracking(d+1, n, s);
            if(s.length() == 1) s = "";
            else {
                s = s.substring(0, s.length()-1);
            }
        }
    }
}