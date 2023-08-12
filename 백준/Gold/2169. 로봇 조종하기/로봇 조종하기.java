import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st1.nextToken());
        int C = Integer.parseInt(st1.nextToken());

        int[][] map = new int[R][C];
        int[][] dp = new int[R][C];
        int[][] tmp = new int[2][C]; //0이 왼->오 위->아래 중 최대, 1이 오->왼 위->아래 중 최대.

        for(int r = 0 ; r < R ; r++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < C ; c++) {
                map[r][c] = Integer.parseInt(st2.nextToken());
            }
        }
        
        //처음 행은 왼 -> 오 밖에 안된다.
        dp[0][0] = map[0][0];
        for(int c = 1 ; c < C ; c++) {
            dp[0][c] = map[0][c] + dp[0][c-1];
        }


        //여기까지 초깃값, 이후 일반화



        for(int r = 1 ; r < R ; r++) {
            //오->왼, 위->아래 최대
            dp[r][0] = dp[r-1][0] + map[r][0];
            tmp[0][0] = dp[r][0];
            for(int c = 1 ; c < C ; c++) {
                tmp[0][c] = map[r][c] + Math.max(dp[r-1][c], tmp[0][c-1]);
            }

            //왼->오, 위->아래 최대
            dp[r][C-1] = dp[r-1][C-1] + map[r][C-1];
            tmp[1][C-1] = dp[r][C-1];
            for(int c = C-2 ; c >= 0 ; c--) {
                tmp[1][c] = map[r][c] + Math.max(dp[r-1][c], tmp[1][c+1]);
            }

            //tmp값중 최대
            for(int c = 0 ; c < C ; c++) {
                dp[r][c] = Math.max(tmp[0][c], tmp[1][c]);
            }
        }

        bw.write(String.valueOf(dp[R-1][C-1]));
        bw.flush();
        bw.close();
        
        
    }

}