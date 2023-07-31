import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken()); //물건수
        int K = Integer.parseInt(st1.nextToken()); //무게제한


        int[] W = new int[N+1]; //index 번째 물건 무게
        int[] V = new int[N+1]; //index 번째 물건 가치

        int[] dp = new int[K+1];

        for(int i = 1 ; i <= N ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st2.nextToken());
            V[i] = Integer.parseInt(st2.nextToken());
        }
        
        for(int i = 1 ; i <= N ; i++) { //물건마다
            for(int j = K ; j - W[i] >= 0 ; j--) { //무게 제한 K부터 작은대로 j 무게마다
                dp[j] = Math.max(dp[j], dp[j-W[i]] + V[i]); 
                //기존의 j 무게까지의 가치 최댓값과, dp[j-W[i]] + V[i] (i번째 물건으로 j-W[i] 무게의 최댓값을 갱신해주기)
                //두 값중 최댓값으로 갱신
            }
        }

        bw.write(String.valueOf(dp[K]));
        bw.flush();
        bw.close();

    }

}