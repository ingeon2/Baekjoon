import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1 ; i < Math.sqrt(n) ; i++) {
            if(n%i == 0) answer++;
        }
        answer = 2*answer;
        if(n%Math.sqrt(n) == 0) answer++;
        return answer;
    }
}