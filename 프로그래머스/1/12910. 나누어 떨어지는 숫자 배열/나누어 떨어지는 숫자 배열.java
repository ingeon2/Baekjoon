import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        for(int a : arr) {
            if(a%divisor == 0) arr1.add(a);
        }
        
        if(arr1.size() == 0) return new int[] {-1};
            
        Collections.sort(arr1);
        int[] answer = new int[arr1.size()];
        for(int i = 0 ; i < arr1.size() ; i++) {
            answer[i] = arr1.get(i);
        }
        return answer;
    }
}