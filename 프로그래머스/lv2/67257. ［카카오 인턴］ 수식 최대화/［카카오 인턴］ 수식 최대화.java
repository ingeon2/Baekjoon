import java.util.*;

class Solution {
    static int[] selected = {0, 1, 2};
    static boolean[] visited = new boolean[3];
    static String[] want = {"+", "-", "*"};
    static long answer = 0;
    static List<String> tokens; 
    
    public long solution(String expression) {
        
        
        
        backTracking(0, expression);
        
        return answer;
    
    }
    
    
    
    static void backTracking(int depth, String expression) {
        if(depth == 3) {
            
            StringTokenizer st = new StringTokenizer(expression, "+-*", true);
            tokens = new ArrayList<>();
            while(st.hasMoreTokens()) {
                tokens.add(st.nextToken());
            }
            
            long v = Math.abs(calc1(tokens));
            if(answer < v) {
                answer = v;
                return;
            }
        }
        
        for(int i = 0 ; i < 3 ; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected[depth] = i;
            backTracking(depth+1, expression);
            visited[i] = false;
        }
    }
    
    static long calc1(List<String> tokens) {
        
        for(int j = 0 ; j < 3 ; j++) {
            String op  = want[selected[j]];
            
            for(int i = 0 ; i < tokens.size() ; i++) {
                if(tokens.get(i).equals(op)) {
                    long n1 = Long.parseLong(tokens.get(i-1));
                    long n2 = Long.parseLong(tokens.get(i+1));
                    long n3 = calc2(n1, n2, op);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.add(i-1, String.valueOf(n3));
                    i--;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
        
    }
    
    
    static long calc2(long n1, long n2, String op) {
		long res = 0;
		switch(op) {
		case "+" :
			res = n1 + n2;
			break;
		case "-" :
			res = n1 -n2;
			break;
		case "*" :
			res = n1 * n2;
			break;
		}
		
		return res;
	}
}