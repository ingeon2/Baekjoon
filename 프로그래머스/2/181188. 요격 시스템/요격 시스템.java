import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        int cut = targets[0][1]-1;
        
        for(int i = 1 ; i < targets.length ; i++) {
            int[] cur = targets[i];
            int s = cur[0];
            int e = cur[1];
            
            if(cut < s) {
                cut = e-1;
                answer++;
            }
        }
        
        
        return answer;
    }
    
}