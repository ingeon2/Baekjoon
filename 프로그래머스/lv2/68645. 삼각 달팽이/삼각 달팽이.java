import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        if(n == 1) return new int[] {1};
        int r = 0;
        int c = 0;
        int v = 1;
        int[][] map = new int[n][n];
        while(true) {

            while(true) {
                if(r+1 == n || map[r+1][c] != 0) break;
                map[r][c] = v;
                v++;
                r++;
            }

            map[r][c] = v;

            while(true) {
                if(c+1 == n || map[r][c+1] != 0) break;
                c++;
                v++;
                map[r][c] = v;
            }

            while(true) {
                if(map[r-1][c-1] != 0) break;
                r--;
                c--;
                v++;
                map[r][c] = v;
            }

            if(v == n * (n+1)/2) break;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j <= i ; j++) {
                arr.add(map[i][j]);
            }
        }
        
        int[] answer = new int[arr.size()];
        
        for(int i = 0 ; i < arr.size() ; i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}