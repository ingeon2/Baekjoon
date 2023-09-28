import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] arr = String.valueOf(n).split("");
        for(String s : arr) {
            answer += Integer.parseInt(s);
        }
        
        return answer;
    }
}