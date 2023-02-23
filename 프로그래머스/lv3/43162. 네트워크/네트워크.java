import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        //컴퓨터의 개수 n개
        //computers, i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현
        
        //방문 여부 생성
        visited = new boolean[n+1];
        //어레이리스트 생성 (0은 사용 안할거고 A[1]부터 사용할것)
        A = new ArrayList[n+1];
        
        //computers 따와서 n줄 돌면서 각각 어레이리스트 생성해주고,
        for(int i = 0 ; i < n ; i++){
            A[i+1] = new ArrayList<Integer>();
            
            //자기 번호 제외 1이면 add하고  0이면 add안함
            for(int j = 0 ; j < n ; j++){
                if(i == j)continue;
                if(computers[i][j] == 1)A[i+1].add(j+1);
            }
        }
        
        
        
        //비지티드 1부터 n까지 돌면서 폴스면 BFS갈기고 answer++;
        for(int i = 1 ; i <= n ; i++){
            if(visited[i] == false) {
                BFS(i); 
                answer++;
            }
        }
        
        return answer;
    }
    
    
    
    //BFS구현(그냥 방문여부 체크가 할일, 한번 마치면 매개변수 start와 이어진놈들 전부 true로 바뀜.)
    public void BFS(int start) {
        //큐 생성(Integer), 1 추가
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        //방문 체크
        visited[start] = true;
          
        //큐가 빌때까지
        while(!q.isEmpty()){
            //하나 뽑고
            int n = q.poll();
            //A[뽑은놈]을 for으로 순회하며(방문 안했다면) q에 넣어주기, 방문여부 체크
            for(int a : A[n]){
                if(visited[a] == false){
                    q.add(a);
                    visited[a] = true;
                }
            }
        }
            
    }
    
}