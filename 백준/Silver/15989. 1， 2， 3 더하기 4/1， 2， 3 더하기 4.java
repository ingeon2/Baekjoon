import java.io.*;
import java.util.*;

public class Main {
    static int[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        D = new int[10001][3];
        D[1][0] = 1;
        D[1][1] = 0;
        D[1][2] = 0;
        D[2][0] = 1;
        D[2][1] = 1;
        D[2][2] = 0;
        D[3][0] = 1;
        D[3][1] = 1;
        D[3][2] = 1;
        for(int i = 4 ; i <= 10000 ; i++) {
            D[i][0] = 1;
            D[i][1] = D[i-2][0] + D[i-2][1];
            D[i][2] = D[i-3][0] + D[i-3][1] + D[i-3][2];
        }

        int a = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < a ; i++) {
            int x = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(D[x][0] + D[x][1] + D[x][2]) + "\n");
        }

        bw.flush();
        bw.close();
    }

}