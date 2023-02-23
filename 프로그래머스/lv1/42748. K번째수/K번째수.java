import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        for(int a = 0 ; a < commands.length ; a++){
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            int [] use_arr = new int[j-i+1];
            //System.arraycopy(array, i-1 , use_arr, 0, j-i+1);
            for(int n = 0 ; n < j-i+1 ; n++){
                use_arr[n] = array[n+i-1];
            }
            Arrays.sort(use_arr);
            answer[a] = use_arr[k-1];
        }
        
        return answer;
    }
}