import java.util.*;

class Solution {
    static String[] check;
    static boolean[] visited;
    static HashSet<HashSet<String>> answer = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        check = new String[banned_id.length];
        visited = new boolean[user_id.length];
        
        backTracking(0, user_id, banned_id);
        
        return answer.size();
    }
    
    static void backTracking(int depth, String[] user, String[] ban) {
        if(depth == ban.length) {
            
            boolean allOk = true;
            
            for(int i = 0 ; i < ban.length ; i++) {
                
                if(!isOk(check[i], ban[i])) {
                    allOk = false;
                    break;
                }
            }
            
            
            if(allOk) {
                HashSet<String> s = new HashSet<>();
                for(int i = 0 ; i < check.length ; i++) {
                    s.add(check[i]);
                }
                answer.add(new HashSet<>(s));
            }

            return;
        }
        
        
        for(int i = 0 ; i < user.length ; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            check[depth] = user[i];
            backTracking(depth+1, user, ban);
            visited[i] = false;
        }
    }
    
   
    
    static boolean isOk(String s1, String s2) {
        if(s2.length() != s1.length()) return false;
        
        for(int i = 0 ; i< s1.length() ; i++) {
            if(s2.charAt(i) == '*') continue;
            
            if(s1.charAt(i) != s2.charAt(i)) return false;
        }
        
        return true;
    }
}