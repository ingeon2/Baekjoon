class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = DFS(numbers, 0, 0, target);
        return answer;
    }
    
    public int DFS(int[] numbers, int depth, int sum, int target){
        if(depth == numbers.length){
            if(sum == target) return 1;
            else return 0;
        }
        return DFS(numbers, depth+1, sum+numbers[depth], target) + DFS(numbers, depth+1, sum-numbers[depth], target);
    }
}