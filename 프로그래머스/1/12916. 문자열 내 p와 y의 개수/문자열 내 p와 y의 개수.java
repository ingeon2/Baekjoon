class Solution {
    boolean solution(String s) {

        if(s.replace("p", "").replace("P", "").length() == s.replace("y", "").replace("Y", "").length()) return true;
        return false;
    }
}