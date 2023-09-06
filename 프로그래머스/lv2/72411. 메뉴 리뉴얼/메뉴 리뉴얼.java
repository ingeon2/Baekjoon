import java.util.*;

class Solution {
    static ArrayList<String> answerList = new ArrayList<>();
    static HashMap<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        for(int i = 0 ; i < orders.length ; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String (arr);
        }
        
        
        
        for(int want : course) {
            for(String order : orders) {
                backTracking(0, want, "", order, 0);
            }
            
            if(!map.isEmpty()) {
                    List<Integer> countList = new ArrayList<>(map.values());
                    int max = Collections.max(countList);
                    
                    if(max > 1) {
                        for(String key : map.keySet()) {
                            if(max == map.get(key)) {
                                answerList.add(key);
                            }
                        }
                    }
                }
                map.clear();
        }
        
        //여까지오면 answerList 답으로 채워짐
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        
        for(int i = 0 ; i < answerList.size() ; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
        
    }
    
    static void backTracking(int depth, int want, String key, String order, int start) {
        if(depth == want) {
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        
        for(int i = start ; i < order.length() ; i++) {
            backTracking(depth+1, want, key + order.charAt(i), order, i+1);
        }
    }
    
}