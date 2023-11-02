import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int N; //행렬 길이
    static boolean[][] v; //방문체크
    static boolean[] island;  //해당 섬으로 bfs 수행했는지 여부 체크해주려고 만들었는데, 여기서 틀림
    //6
    //1 0 0 1 1 1
    //1 0 0 0 0 1
    //1 0 0 0 0 0
    //1 0 0 0 0 1
    //1 1 1 1 1 1
    //0 0 0 0 0 0
    //이거 값이 1나와야하는데, 2나옴 왜냐? -> 두번재 뭉탱이 값 3으로 적히고 나서, 거기를 한꺼번에 돌기 때문에
    //원래는 1행 5열에서 큐 들어갔다 나오면 주위 다리 길이는 1이 되어야 하는데,
    //island 사용해서 뭉탱이로 돌면 주위를 둘러보고 최솟값을 적게 되는게 아니라 그냥 cb+1(125행)이 되어 값이 2가 된다.
    //즉, 최단 다리를 찾게 되는 것이 아니라 큐에 들어갔다가 나오는 순서대로 다리를 이어버리게 된다.
    //하지만, island없이 한점 한점마다 bfs를 해주면, 모든 경우이므로 최솟값이 무조건 저장될 수 있다.
    
    static int idx = 2; //섬 idx

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static int answer = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        
        map = new int[N][N];
        v = new boolean[N][N];
        
        StringTokenizer st;
        for(int r = 0 ; r < N ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < N ; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        //초깃값설정 완

        //섬 구분해주기
        for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ; c < N ; c++) {
                if(!v[r][c] && map[r][c] == 1) sep(r, c); //현재 점 방문 안했고 섬이라면 섬 체크해주기
            }
        }
        

        //구분된 섬으로 bfs돌며, 같은 섬일 시 거리 0이고 바다 만나면 거리+1, 다른 섬 만나면 거리 최솟값 체크해주는 bfs실행
        for(int r = 0 ; r < N ; r++) {
            for(int c = 0 ; c < N ; c++) {
                if(map[r][c] > 1) { //1보다 크다는건 섬에 도달했고, 해당 섬 아직 순회하지 않았다면 (island 여기서 틀림)
                    v = new boolean[N][N]; //방문배열 초기화
                    bfs(r, c, map[r][c]); //순회하며 최솟값 찾아주기 (섬의 모든 점이 아닌, 섬 하나하나마다만! 실행 가능)
                    //해당 bfs돌고 나면, 지금 r c 섬에서 최단거리가 answer 에 기록됨
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
        
    }

    static void sep(int r, int c) { //섬을 구분해줄 함수
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        v[r][c] = true;
        map[r][c] = idx;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            for(int i = 0 ; i < 4 ; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(!isValid(nr, nc)) continue; //인덱스 안맞으면 넘기고

                if(map[nr][nc] != 0) { //다음 점이 물에 해당하는 값인 0이 아니라면
                    q.add(new int[] {nr, nc}); //큐에 넣어주고
                    v[nr][nc] = true; //방문체크
                    map[nr][nc] = idx; //idx로 섬의 값을 바꿔주기
                }
            }

        }
        
        idx++;
    }
    
    static void bfs(int r, int c, int idx) { //r행 c열이 섬인데, 해당 섬 순회하며 다른 섬 만날때마다 거리 최솟값으로 갱신해주는 함수
        Queue<int[]> q = new LinkedList<>(); //r, c, 거리 숫자배열
        q.add(new int[] {r, c, 0});
        v[r][c] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cb = cur[2]; //지금 다리 길이
            
            for(int i = 0 ; i < 4 ; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(!isValid(nr, nc)) continue;

                int ii = map[nr][nc]; //섬 인덱스, 아일랜드인덱스
                
                if(ii == idx) { //처음 결정한 섬(r, c)과 같은 섬(nr, nc)을 순회하면 다리건설 안하니까
                    q.add(new int[] {nr, nc, 0}); //거리0으로 큐에 넣고
                    v[nr][nc] = true; //방문체크
                }
                else if(ii == 0) { //지금 nr nc가 물이라면 주위의 최솟값 다리와 연결해서 다리건설
                    q.add(new int[] {nr, nc, cb+1});
                    v[nr][nc] = true;
                }
                else { //아예 다른 섬을 만나버리면 (처음 섬도 아니고 물도 아니면 다른 섬)
                    answer = Math.min(answer, cb);
                }
            }
        }
        
    }


    static boolean isValid(int r, int c) {
        if(r < 0 || r >= N || c < 0 || c >= N || v[r][c]) return false;
        return true;
    }
}