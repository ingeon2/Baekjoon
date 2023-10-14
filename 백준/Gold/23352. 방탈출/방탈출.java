import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer = 0;
    static int M = 0; //이동거리
    static int R,C;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];

        for(int r = 0 ; r < R ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < C ; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                answer = Math.max(answer, map[r][c]);
            }
        }

        for(int r = 0 ; r < R ; r++) {
            for(int c = 0 ; c < C ; c++) {
                if(map[r][c] != 0) BFS(r, c);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
    
    //점마다 BFS순회하며 이동거리의 최댓값이 나올때 거리와 해당 점들의 위치 갱신
    static void BFS(int r, int c) {
        visited = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c, 0});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cm = cur[2];

            if(cm > M) {
                answer = map[r][c] + map[cr][cc];
                M = cm;
            }
            else if(cm == M) answer = Math.max(answer, map[r][c] + map[cr][cc]);

            for(int i = 0 ; i < 4 ; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(isValid(nr, nc)) {
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc, cm+1});
                }
            }
        }
    }

    static boolean isValid(int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || map[r][c] == 0 || visited[r][c]) return false;
        return true;
    }

}