import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int N = citations.length;
        
        for(int i = 0 ; i <= citations.length ; i++) {
            int x = idxOverH(citations, i); //i 이상 값의 최초index
            
            if(N-x >= i) {
                answer = i;
            }
            else  {
                break;
            }
        }
        
        return answer;
    }
    
    static int idxOverH(int[] arr, int h) {
        int s = 0;
        int e = arr.length;
        
        while(s < e) {
            int m = (s+e)/2;
            if(arr[m] >= h) e = m;
            else s = m+1;
        }
        return s;
    }
}