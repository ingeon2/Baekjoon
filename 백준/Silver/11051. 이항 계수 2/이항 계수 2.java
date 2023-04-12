import java.io.*;
import java.util.*;

public class Main {
    static int n,r;
    static int[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        D = new int[n+1][n+1];
        combination();

        bw.write(String.valueOf(D[n][r]));
        bw.flush();
        bw.close();


    }

    static void combination() {
        for(int i = 1 ; i <= n ; i++) {
            D[i][0] = 1;
            D[i][i] = 1;
            D[i][1] = i;
        }

        for(int i = 2 ; i <= n ; i++) {
            for(int j = 1 ; j <= r ; j++) {
                //10,007로 나눈 나머지
                D[i][j] = ((D[i-1][j]%10007) + (D[i-1][j-1]%10007)) % 10007;
            }
        }
    }

}