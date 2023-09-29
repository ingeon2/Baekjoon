import java.util.*;

class Solution {
    static int[] repre;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        repre = new int[n];
        for(int i = 0 ; i < n ; i++) {
            repre[i] = i;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        
        for(int[] cost : costs) {
            pq.add(new int[] {cost[0], cost[1], cost[2]});
        }
        
        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            
            if(find(a) == find(b)) continue;
            union(a, b);
            answer += c;
            
            //if(allCheck(repre)) break;
        }
        
        
        
        
        return answer;
    }
    
    
    static boolean allCheck(int[] check) {
        int a = check[0];
        int b = 1;
        for(int i = 1 ; i < check.length ; i++) {
            if(a == check[i])  b++;
        }
        
        if(b == check.length) return true;
        return false;
    }
    
    static int find(int a) {
        if(a == repre[a]) return a;
        return repre[a] = find(repre[a]);
    }
    
    static void union(int a, int b) {
        int max = Math.max(find(a), find(b));
        int min = Math.min(find(a), find(b));
        
        repre[min] = max;
    }
}