import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int l = citations.length;
        int answer = 0;
        for(int h  = 1 ; h <= l ; h++) {
            if(citations[l - h] >= h) answer = h;
            else break;
        }
        return answer;
    }
}