import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[301]; //index 계단의 점수

        int[][] dp = new int[301][2]; //dp[i][j] = i번째 계단을 바로 직전에 j+1번 뛰어왔을때 점수

        for(int i = 1 ; i <= N ; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[1][0] = score[1];
        dp[1][1] = 0;
        dp[2][0] = score[2] + dp[1][0];
        dp[2][1] = score[2];

        for(int i = 3 ; i <= N ; i++) {
            dp[i][1] = score[i] + Math.max(dp[i-2][1], dp[i-2][0]);
            dp[i][0] = score[i] + dp[i-1][1];
        }

        bw.write(String.valueOf(Math.max(dp[N][0], dp[N][1])));
        bw.flush();
        bw.close();
    }

}