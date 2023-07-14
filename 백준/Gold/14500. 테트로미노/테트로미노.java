import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int R, C;
    static int[] dr = {-1, 1, 0, 0}; //상하좌우 순
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //모양에 집착할 필요가 없다. DFS 무작위로 4방향으로 뻗어나가게 두면 그게 테트로미노의 전체 모양이 된다.

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];

        for(int r = 0 ; r < R ; r++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < C ; c++) {
                map[r][c] = Integer.parseInt(st2.nextToken());
            }
        }

        for(int r = 0 ; r < R ; r++) {
            for(int c = 0 ; c < C ; c++) {
                visited[r][c] = true; //여기와 아래의 visited[r][c] = false; 이해하기
                backTracking(r, c, 1, map[r][c]);
                visited[r][c] = false;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    //시작점부터 무작위로 4개씩 뻗어나가 그 4개의 합을 구하는 DFS
    //backTracking(r, c, depth+1, sum + map[nextR][nextC]);
    //backTracking(nextR, nextC, depth+1, sum + map[nextR][nextC]); 이 둘의 차이를 이해하면 쉬움.
    static void backTracking(int r, int c, int depth, int sum) { //sum은 map[r][c]가 초깃값, depth는 초깃값 1

        if(depth == 4) {
            if(answer < sum) answer = sum;
            return;
        }

        for(int i = 0 ; i < 4 ; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(!isValid(nextR, nextC)) continue; //index 유효하지 않으면 다음 i
            if(visited[nextR][nextC]) continue;



            if(depth == 2) { //ㅗ 만들어줘야 할 경우 (두번째 칸에서 엇나가야지 그래서 depth 2),
                visited[nextR][nextC] = true;
                backTracking(r, c, depth+1, sum + map[nextR][nextC]);
                visited[nextR][nextC] = false;
            }

            visited[nextR][nextC] = true;
            backTracking(nextR, nextC, depth+1, sum + map[nextR][nextC]);
            visited[nextR][nextC] = false;
        }
    }

    static boolean isValid(int r, int c) { //행열의 index가 유효한지 검증
        if(r < 0 || r >= R || c < 0 || c >= C) return false;
        return true;
    }

}