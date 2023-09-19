import java.util.*;
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        ArrayList<Integer> arr = new ArrayList<>();
        while(st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(arr);
        
        return arr.get(0) + " " + arr.get(arr.size()-1);
    }
}