import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n+1];
        for(int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int[][] D = new int[n+1][2]; //D[i][j] = i번째 잔이 연속 j+1번째로 마신 잔일때, 최댓값

        D[1][0] = arr[1];

        if(n >= 2) { //n값이 1일때는 아래의 로직을 실행하면 배열 바깥으로 index 에러.
            D[2][0] = arr[2];
            D[2][1] = arr[2] + arr[1];

            for(int i = 3 ; i <= n ; i++) {
                D[i][0] = Math.max(Math.max(D[i-2][0], D[i-2][1]) + arr[i], D[i-1][1]);
                //i번째 잔을 1번 연속으로 해서 마시려면, i-2번째 잔까지의 최댓값에서 현재 잔을 마신것.
                //i-1번째 잔까지 2번 연속으로 마셔온것 셋중에 최댓값

                D[i][1] = D[i-1][0] + arr[i];
                //i번째 잔을 두번 연속으로 해서 마시려면 i-1번쨰 잔을 마시고 i번째 잔을 마셔야 한다.
            }
        }

        int answer = Math.max(D[n][0], D[n][1]);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        
    }

}