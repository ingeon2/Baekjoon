import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            int days = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] stocks = new int[days];
            for(int j = 0 ; j < days ; j++) {
                stocks[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            long max = 0;

            for(int j = days-1 ; j >= 0 ; j--) {
                if(stocks[j] > max) max = stocks[j];
                else sum += (max - stocks[j]);
            }

            bw.write(String.valueOf(sum) + "\n");
        }

        bw.flush();
        bw.close();

    }

}