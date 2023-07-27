import java.io.*;
import java.util.*;

public class Main {
    //인덱스때문에
    static int N, M;
    //map 1은벽 0은청소할곳, 청소 후엔 3으로 바꿔주기.
    static int[][] map;
    //정답 보여줄 answer
    static int answer = 0;
    static boolean[][] visited;
    static int R,C;
    //상 우 하 좌 dr dc, 여기는 행열. 맨 왼쪽 위 00 시작. (북동남서) = 상 좌 하 우 / 후진은 +2, 반시계90도는 +3
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st2.nextToken());
        int c = Integer.parseInt(st2.nextToken());
        int d = Integer.parseInt(st2.nextToken());

        for(int i = 0 ; i < R ; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < C ; j++) {
                map[i][j] = Integer.parseInt(st3.nextToken());
            }
        }

        one(r, c, d);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();


    }
    static boolean isValid(int r, int c) { //index유효한지, 갈수잇는 0인지
        if(0 > r || r >= R || 0 > c || c >= C || map[r][c] != 0) return false;
        return true;
    }



    static void one(int r, int c, int d) {
        if(map[r][c] == 0 && !visited[r][c]) {
            answer++;
            visited[r][c] = true;
        }

        if(two(r, c, d)) {
            for(int i = 0 ; i < 4 ; i++) {
                d = (d+3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(isValid(nr, nc) && !visited[nr][nc]) {
                    one(nr, nc, d);
                    break;
                }
            }
        }
        else {
            int nr = r + dr[(d+2)%4];
            int nc = c + dc[(d+2)%4];

            if(isValid(nr, nc)) {
                one(nr, nc, d);
            }
            else {
                return;
            }
        }
    }

    static boolean two(int r, int c, int d) { //주위 네칸중 청소할수있는 칸 여부
        for(int i = 0 ; i < 4 ; i++) {
            if(isValid(r + dr[i], c + dc[i]) && !visited[r + dr[i]][c + dc[i]]) return true;
        }
        return false;
    }


}