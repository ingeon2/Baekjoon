import java.io.*;
import java.util.*;

public class Main {
    //맵, 방문기록
    static int[][] map;
    static boolean[][] visited;

    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    //행렬 R,C
    static int R,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //도달할 수 없는 위치는 -1
        //map 구성하고 void로 이동/ 1이면 +1, 0이면 트루 기록해놓고(나중에 도달못)

        //첫줄 행렬크기
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());

        //초깃갑
        map = new int[R][C];
        visited = new boolean[R][C];
        int[] start = new int[2];

        //맵 구성
        for(int i = 0 ; i < R ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < C ; j++) {
                int a = Integer.parseInt(st2.nextToken());
                map[i][j] = a;

                if(a == 0) visited[i][j] = true;
                if(a == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        //함수돌리고 벽이나 지난부분은 true니까 나머지 false 부분의 맵 -1 바꺼주기
        BFS(start[0], start[1]);

        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                if(visited[i][j] == false) map[i][j] = -1;
            }
        }

        //출력
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                bw.write(String.valueOf(map[i][j] + " "));
                if(j == C-1)bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        map[r][c] = 0;
        visited[r][c] = true;
        q.add(new int[] {r, c});

        while(!q.isEmpty()) {
            int[] before = q.poll();

            for(int i = 0 ; i < 4 ; i++) {
                int nr = before[0] + dr[i];
                int nc = before[1] + dc[i];

                if(nr >= 0 && nr <= R-1 && nc >= 0 && nc <= C-1 && visited[nr][nc] == false && map[nr][nc] != 0) {
                    map[nr][nc] = map[before[0]][before[1]] + 1;
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
    
}