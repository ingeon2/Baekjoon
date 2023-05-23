import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(n != 0) {
            if(n % 2 == 0) n = n/2;
            else {
                answer++;
                n -= 1;
            }
        }
        

        return answer;
    }
}