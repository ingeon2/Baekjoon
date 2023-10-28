import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2 ; i <= n ; i++) {
            if(!check(i)) answer++;
        }
        return answer;
    }
    
    static boolean check(int i) {
        if(i == 1) return false;
        for(int k = 2 ; k <= Math.sqrt(i) ; k++) {
            if(i % k == 0) return true;
        }
        return false;
    }
}