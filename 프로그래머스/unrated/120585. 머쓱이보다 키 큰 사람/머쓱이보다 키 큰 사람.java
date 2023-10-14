class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for(int k : array) {
            if(k > height) answer++;
        }
        return answer;
    }
}