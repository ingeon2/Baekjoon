import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()) {
                dp[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for(int i = N-2 ; i >= 0 ; i--) {
            for(int j = 0 ; j <= i ; j++) {
                dp[i][j] += Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        bw.write(String.valueOf(dp[0][0]));
        bw.flush();
        bw.close();



    }
}