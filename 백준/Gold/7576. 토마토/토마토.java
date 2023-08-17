import java.io.*;
import java.util.*;

public class Main {
    static int R,C;
    static boolean[][] visited;
    static int[][] map;
    static ArrayList<int[]> tomatoes;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st1.nextToken());
        R = Integer.parseInt(st1.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];
        tomatoes = new ArrayList<>();

        for(int r = 0 ; r < R ; r++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < C ; c++) {
                int n = Integer.parseInt(st2.nextToken());
                map[r][c] = n;
                if(n == 1) {
                    tomatoes.add(new int[] {r, c});
                }
            }
        }

        BFS();
        boolean exit = false;

        int max = -1;
        for(int r = 0 ; r < R ; r++) {
            for(int c = 0 ; c < C ; c++) {
                if(map[r][c] == 0) {
                    max = 0;
                    exit = true;
                    break;
                }
                max = Math.max(max, map[r][c]);
            }
            if(exit) break;
        }

        bw.write(String.valueOf(max-1));
        bw.flush();
        bw.close();


    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();

        for(int[] tomato : tomatoes) { //토마토 전부 시작점 입력
            q.add(new int[] {tomato[0], tomato[1]});
            visited[tomato[0]][tomato[1]] = true;
        }

        while(!q.isEmpty()) {
            int[] curT = q.poll();
            int curR = curT[0];
            int curC = curT[1];

            for(int i = 0 ; i < 4 ; i++) {
                int nR = curR + dr[i];
                int nC = curC + dc[i];

                if(isValid(nR, nC)) {
                    map[nR][nC] = map[curR][curC] + 1;
                    visited[nR][nC] = true;
                    q.add(new int[] {nR, nC});
                }
            }
        }
    }



    static boolean isValid(int r, int c) {
        if(r >= 0 && r < R && c >= 0 && c < C && !visited[r][c] && map[r][c] == 0) return true;
        return false;
    }

}