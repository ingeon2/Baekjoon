import java.util.*;

class Solution {
    static ArrayList<int[]> arr = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(1, 2, 3, 0, n);
        int[][] answer = new int[arr.size()][2];
        
        for(int i = 0 ; i < arr.size() ; i++) {
            answer[i][0] = arr.get(i)[0];
            answer[i][1] = arr.get(i)[1];
        }
        System.out.println(arr.size());
        
        return answer;
    }
    
    static void hanoi(int s, int m, int e, int depth, int n) {
        
        if(depth == n) return;
        
        hanoi(s, e, m, depth+1, n);
        arr.add(new int[] {s, e});
        hanoi(m, s, e, depth+1, n);
        
    }
}