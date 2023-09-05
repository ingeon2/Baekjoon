class Solution {
    public int[] solution(int brown, int yellow) {
        int c = 0;
        int r = 0;
        int total = brown + yellow;
        
        
        for(int i = 1 ; i <= (brown + 4)/2 ; i++) {
            if(total % i == 0) {
                int n1 = i;
                int n2 = (brown + 4)/2 - i;
                if((n1-2) * (n2-2) == yellow) {
                    c = Math.max(n1, n2);
                    r = Math.min(n1, n2);
                    break;
                }
            }
        }
        
        
        int[] answer = new int[] {c, r};
        return answer;
    }
}