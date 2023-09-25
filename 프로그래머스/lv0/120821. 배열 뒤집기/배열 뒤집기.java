class Solution {
    public int[] solution(int[] num_list) {
        int l = num_list.length;
        int[] answer = new int[l];
        
        for(int i = 0 ; i < l ; i++) {
            answer[i] = num_list[l - i - 1];
        }
        
        return answer;
    }
}