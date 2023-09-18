import java.util.*;
import java.io.*;


public class Main {
    static int R,C;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] v1; //물
    static boolean[][] v2; //고슴도치
    static int[] D; //굴 초기 위치
    static int[] S; //고슴도치 초기 위치
    static ArrayList<int[]> W; //물 초기 위치
    static char[][] map;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        v1 = new boolean[R][C];
        v2 = new boolean[R][C];
        D = new int[2];
        S = new int[2];
        W = new ArrayList<>();
        map = new char[R][C];


        for(int r = 0 ; r < R ; r++) {
            map[r] = br.readLine().toCharArray();

            for(int c = 0 ; c < C ; c++) {
                if(map[r][c] == 'D') {
                    D[0] = r;
                    D[1] = c;
                }

                if(map[r][c] == 'S') {
                    S[0] = r;
                    S[1] = c;
                }

                if(map[r][c] == '*') {
                    W.add(new int[] {r, c});
                }

            }
        }

        int answer = BFS();
        if(answer == -1) {
            bw.write("KAKTUS");
        }
        else {
            bw.write(String.valueOf(answer));
        }



        bw.flush();
        bw.close();





    }
    
    static int BFS() {
        Queue<Node> q = new LinkedList<>(); // r, c, 거리, 물 여부
        
        for(int[] arr : W) {
            q.add(new Node(arr[0], arr[1], 0, true));
            v1[arr[0]][arr[1]] = true; //물 다시 안감
        }
        
        q.add(new Node(S[0], S[1], 0, false));
        v2[S[0]][S[1]] = true; //고슴도치 다시 안감
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int curR = cur.r;
            int curC = cur.c;
            int curCnt = cur.cnt;

            if(!cur.w && curR == D[0] && curC == D[1]) return curCnt;

            if(cur.w) { //물이라면
                for(int i = 0 ; i < 4 ; i++) {
                    int nr = curR + dr[i];
                    int nc = curC + dc[i];

                    if(isValid(nr, nc) && !v1[nr][nc] && map[nr][nc] != 'D') {
                        map[nr][nc] = '*';
                        v1[nr][nc] = true;
                        q.add(new Node(nr, nc, curCnt, true));
                    }
                }
            }
            else { //슴도치라면
                for(int i = 0 ; i < 4 ; i++) {
                    int nr = curR + dr[i];
                    int nc = curC + dc[i];

                    if(isValid(nr, nc) && !v2[nr][nc] && map[nr][nc] != '*') {
                        v2[nr][nc] = true;
                        q.add(new Node(nr, nc, curCnt+1, false));
                    }
                }
            }


        }

        return -1;
    }

    static boolean isValid(int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || map[r][c] == 'X') return false;
        return true;
    }



    static class Node {
        int r,c,cnt;
        boolean w;
        
        public Node(int r, int c, int cnt, boolean w) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.w = w;
        }
    }
    

}