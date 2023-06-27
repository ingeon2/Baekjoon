import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //1 <= n <= 64
        //DP[i][j] = 자릿수는 i개, 마지막 자릿수의 숫자가 j인 친구들의 개수
        //예를 들어, DP[4][3] 에는 0003, 0013, 1233 이런 친구들 등등 포함.
        long[][] DP = new long[65][10];
        
        for(int j = 0 ; j < 10 ; j++) {
            DP[1][j] = 1; //자릿수 한자릿수에 j로 마치는건 각각 하나씩 뿐 0, 1, 2, ..., 9
        }

        for(int i = 2 ; i < 65 ; i++) {
            for(int j = 0 ; j < 10 ; j++) {
                for(int k = 0 ; k <= j ; k++) {
                    DP[i][j] += DP[i-1][k];
                    //xx3 -> 00, 01, 02, 03, 11, 12, 13, 22, 23 에서 올 수 있음. -> x0, x1, x2, x3에서 올 수 있다는 소리
                    // (끝자리-1 숫자가 끝자리 숫자와 비교해서 작거나 같아야 한다는 소리)
                }
            }
        }

        long[] answer = new long[65];

        for(int i = 1 ; i < 65 ; i++) {
            long sum = 0;
            for(int j = 0 ; j < 10 ; j++) {
                sum += DP[i][j];
            }
            answer[i] = sum;
        }

        int T = Integer.parseInt(br.readLine());


        for(int i = 0 ; i < T ; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(answer[n]) + "\n");
        }
        bw.flush();
        bw.close();

    }

}