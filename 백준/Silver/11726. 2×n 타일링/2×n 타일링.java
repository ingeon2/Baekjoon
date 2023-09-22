import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] D = new int[1001];
        D[1] = 1;
        D[2] = 2;

        for(int i = 3 ; i <= N ; i++) {
            D[i] = D[i-1] + D[i-2];
            if(D[i] >= 10007) D[i] = D[i] % 10007;
        }

        bw.write(String.valueOf(D[N]));
        bw.flush();
        bw.close();

    }


}