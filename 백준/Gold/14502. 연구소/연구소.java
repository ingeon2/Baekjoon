import java.io.*;
import java.util.*;

public class Main {
    static int[] nr = {1, -1, 0, 0};//상하좌우 순.
    static int[] nc = {0, 0, 1, -1};
    
    static int answer = 0;
    static int first = 0;
    
    
    static int[][] map;
    static boolean[][] visited;
    
    static ArrayList<int[]> rc2;
    
    static int R, C;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        
        map = new int[R][C];
        rc2 = new ArrayList<int[]>();
        
        for(int i = 0 ; i < R ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < C ; j++) {
                
                int a = Integer.parseInt(st2.nextToken());
                
                if(a == 2) {
                    rc2.add(new int[] {i, j}); //바이러스 위치 행렬 등록
                }
                
                map[i][j] = a; //map 채우기
                
                if(a == 0) { //0의 개수 세주기
                    first++;
                }
                

            }
        }

        //여기까지가 초깃값.

        backtracking(0);
        bw.write(String.valueOf(answer-3));
        bw.flush();
        bw.close();
        
    }
    
    
    static void BFS() {
        visited = new boolean[R][C];
        Queue <int[]> q = new LinkedList<>();
        int num_zero = first;
        for(int i = 0 ; i < rc2.size() ; i++) { //map 값이 2인 친구들 넣어주기 (바이러스 기준으로 BFS 돌거니까.)
            q.add(new int[] {rc2.get(i)[0], rc2.get(i)[1]});
        }
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            visited[now[0]][now[1]] = true;
            
            for(int i = 0 ; i < 4 ; i++) {
                int n_r = now[0] + nr[i];
                int n_c = now[1] + nc[i];
                
                //index만족, 방문안했고, map 값도 바이러스가 다닐 수 있는 0이라면
                if(n_r >= 0 && n_r < R && n_c >= 0 && n_c < C && map[n_r][n_c] == 0 && visited[n_r][n_c] == false) {
                    //큐에 다시 넣고, 0의 개수 줄여주고, 방문 체크
                    q.add(new int[] {n_r, n_c}); 
                    num_zero--;
                    visited[n_r][n_c] = true;
                }
            }
        }
        
        if(num_zero > answer) { //정답 갱신 로직
            answer = num_zero;
        }
        
    }
    
    static void backtracking(int depth) {
        if(depth == 3) {
            BFS();
            return;
        }

        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    backtracking(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

}