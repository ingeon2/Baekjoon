import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        //n 크기의 int[] length 를 생성(1로부터의 거리), 나중에 answer 구할땐 index 0 제외하고 가야지
        int[] length = new int[n+1];
        
        //그래프로 사용할 arrayList 생성
        ArrayList<Integer>[] A = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++){
            A[i] = new ArrayList<Integer>();
        }
        //edge[][]  for문으로 돌면서 생성한 어레이리스트에 넣기
        for(int[] point : edge) {
            A[point[0]].add(point[1]);
            A[point[1]].add(point[0]);
        }
        //visited생성
        boolean[] visited = new boolean[n+1];
        //q 생성후 1시작(visited, add)
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        //q가 빌때까지
        while(!q.isEmpty()) {
            //뽑아주고 뽑아준놈들 for문으로
            int a = q.poll();
            for(int b : A[a]) {
                //방문여부 체크, 방문x라면 방문하고 add하고  length친구 = length원래놈+1
                if(visited[b] == false) {
                    visited[b] = true;
                    q.add(b);
                    length[b] = length[a]+1;
                }
            }
            
        }
        
        
        //여까지오면 length 거리로 찰거고, 최댓값 구한 후 그 값에 해당하는 친구들 answer++
        int answer = 0;
        int max = 0;
        for(int i = 1 ; i <= n ; i++) {
            if(max < length[i]) max = length[i];
        }
        
        for(int i = 1 ; i <= n ; i++) {
            if(max == length[i]) answer++;
        }
        
        return answer;
    }
}