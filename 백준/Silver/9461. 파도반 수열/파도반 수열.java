import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n  = Integer.parseInt(br.readLine());
        long[] D = new long[101];
        D[1] = 1;
        D[2] = 1;
        D[3] = 1;
        D[4] = 2;
        D[5] = 2;

        for(int i = 6 ; i <= 100 ; i++) {
            D[i] = D[i-1] + D[i-5];
        }

        for(int i  = 0 ; i < n ; i++) {
            bw.write(String.valueOf(D[Integer.parseInt(br.readLine())]) + "\n");
        }
        bw.flush();
        bw.close();

    }

}