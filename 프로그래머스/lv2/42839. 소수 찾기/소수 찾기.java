import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] visited;
    public int solution(String numbers) {
        char[] nums = numbers.toCharArray();
        
        
        visited = new boolean[nums.length];
        
        backTracking(0, nums, 0);
        
        int answer = 0;
        for(int s : set) {
            System.out.println(s);
            if(isPrime(s)) answer++;
        }
        
        return answer;
    }
    
    
    
    
    static void backTracking(int depth, char[] nums, int now) {
        
        if(depth == nums.length) {
            set.add(now);
            return;
        }
        else {
            set.add(now);
        }
        
        
        
        
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            //int next =  (now * 10) + (nums[i] - '0');
            backTracking(depth+1, nums, (now * 10) + (nums[i] - '0'));
            visited[i] = false;
        }
    }
    
    
    
    
    static boolean isPrime(int a) {
        if(a == 0 || a == 1) return false;
        for(int i = 2 ; i <= (int) Math.sqrt(a) ; i++) {
            if(a % i == 0) return false;
        } 
        return true;
    }
}