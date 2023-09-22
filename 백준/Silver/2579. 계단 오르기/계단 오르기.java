import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[301];

        for(int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] D = new int[301][2];

        D[1][0] = arr[1];
        D[1][1] = 0;
        D[2][0] = D[1][0] + arr[2];
        D[2][1] = arr[2];

        for(int i = 3 ; i <= N ; i++) {
            D[i][0] = D[i-1][1] + arr[i];
            D[i][1] = Math.max(D[i-2][0], D[i-2][1]) + arr[i];
        }

        int answer = Math.max(D[N][0], D[N][1]);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }


}