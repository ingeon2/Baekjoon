import java.util.*;

class Solution {
    static int[] number;
    static int targe;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        number = numbers;
        targe = target;
        //numbers 배열에 숫자(1 이상 50 이하)가 있고.  (2개 이상 20개 이하)
        //배열의 맨 처음 숫자부터 -나 + 붙여서 
        //target(1 이상 1000 이하)만들면 방법의 수++ (answer++;)
        

        BFS();
    
        return answer;
    }
    
    public static void BFS(){
        //큐 생성. (깊이는 0부터 numbers 배열의 마지막 index까지.)
        Queue<depthsum> q = new LinkedList<>();
        //큐에 첫번째 원소 두개 +, -로 대입 깊이0, 섬은 +-처음원소
        q.add(new depthsum(0, number[0]));
        q.add(new depthsum(0, -number[0]));
        
        //큐가 빌때까지
        while(!q.isEmpty()){
            //큐에서 하나 뽑고, 뽑은놈의 깊이에 따라 두갈래로 나누기
            depthsum before = q.poll();
             
            //끝이 아니라면 뽑아내서 다시 넣고, (add하는것)
            if(before.depth != number.length-1){
                  
                //add 하는것은 
                //BFS다음단계 큐로 드러갈때 +,-로 단 두개만 들어가기. depth도 BFS함수에 매개변수로 넣기
                q.add(new depthsum(before.depth+1, before.sum + number[before.depth+1]));
                q.add(new depthsum(before.depth+1, before.sum - number[before.depth+1]));
            }
            //depth가 numbers.length-1이라면 (끝까지 더하고 빼주고 했다면)
            else{
                //target과 같은지 if로 검증하자. 
                if(before.sum == targe) answer++;
                //뽑은놈 sum확인, target(1 이상 1000 이하)만들면 방법의 수++ (answer++;)
            }    
        }
            
    }
    
    
    
    //깊이와 합을 나타내줄 클래스.
    public static class depthsum{
        int depth;
        int sum;
        
        public depthsum(int depth, int sum){
            this.depth = depth;
            this.sum = sum;
        }
    }
    
}