import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[] {-1};
        
        int idx = 0;
        int min = arr[0];
        
        for(int i = 1 ; i < arr.length ; i++) {
            if(arr[i] < min) {
                min = arr[i];
                idx = i;
            }
        }
        
        int[] answer = new int[arr.length-1];
        int j = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(i != idx) {
                answer[j] = arr[i];
                j++;
            }
        }
        
        return answer;
    }
}