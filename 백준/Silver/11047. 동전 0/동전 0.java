import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //N, target 숫자받기. N크기 배열 만든 후 삽입.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for(int i = 1 ; i <= N ; i++) {
            coins[N-i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for(int coin : coins){
            if(coin > target) continue;
            result += target/coin;
            target = target%coin;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();

    }

}