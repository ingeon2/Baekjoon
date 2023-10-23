import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[][] p; //픽처, 그림이다
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] v;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //적록색약.
        //적록색약인 사람은 RG와 B로
        //아닌 양반들은 R G B 로 각각 BFS돌려주고, 돌린 후 뭉탱이의 개수를 적어주면 된다.
        
        n = Integer.parseInt(br.readLine());
        p = new char[n][n];

        for(int i = 0 ; i < n ; i++) {
            p[i] = br.readLine().toCharArray();
        }

        v = new boolean[n][n];
        int ans1 = 0; //정상 구역 나누기
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(!v[i][j]) {
                    bfs(i, j);
                    ans1++;
                }
            }
        }

        v = new boolean[n][n];
        int ans2 = 0; //적록색맹 구역 나누기
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(!v[i][j]) {
                    bfs1(i, j);
                    ans2++;
                }
            }
        }

        bw.write(String.valueOf(ans1) + " " + String.valueOf(ans2));
        bw.flush();
        bw.close();
        
        
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        v[r][c] = true;
        char color = p[r][c];
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curR = cur[0];
            int curC = cur[1];
            
            for(int i  = 0 ; i < 4 ; i++) {
                int nR = curR + dr[i];
                int nC = curC + dc[i];
                
                if(isValid(nR, nC) && p[nR][nC] == color) {
                    v[nR][nC] = true;
                    q.add(new int[] {nR, nC});
                }
                
            }
        }
    }


    static void bfs1(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        v[r][c] = true;
        char color = p[r][c];

        if(color == 'B') { //B만 해주기
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int curR = cur[0];
                int curC = cur[1];

                for(int i  = 0 ; i < 4 ; i++) {
                    int nR = curR + dr[i];
                    int nC = curC + dc[i];

                    if(isValid(nR, nC) && p[nR][nC] == 'B') {
                        v[nR][nC] = true;
                        q.add(new int[] {nR, nC});
                    }

                }
            }
        }
        else { //적록색맹 RG해주기
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int curR = cur[0];
                int curC = cur[1];

                for(int i  = 0 ; i < 4 ; i++) {
                    int nR = curR + dr[i];
                    int nC = curC + dc[i];

                    if(isValid(nR, nC)) {
                        if(p[nR][nC] == 'R' || p[nR][nC] == 'G') {
                            v[nR][nC] = true;
                            q.add(new int[] {nR, nC});
                        }
                    }

                }
            }
        }
    }
    
    
    
    
    
    static boolean isValid(int r, int c) {
        if(r < 0 || r >= n || c < 0 || c >= n || v[r][c]) return false;
        return true;
    }

}