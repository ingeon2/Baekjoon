import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] oil = new long[100001];
        long[] length = new long[100001];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N-1 ; i++) {
            length[i] = Long.parseLong(st1.nextToken());
            oil[i] = Long.parseLong(st2.nextToken());
        }

        if(N == 2) {
            bw.write(String.valueOf(oil[0] * length[0]));
        }

        if(N != 2) {
            long answer = 0;
            long nowPay = oil[0];
            long dist = 0;
            int index = 0;

            while(true) {
                dist += length[index];
                index++;

                if(index == N-1) {
                    answer += dist * nowPay;
                    break;
                }

                if(oil[index] < nowPay) {
                    answer += dist * nowPay;
                    nowPay = oil[index];
                    dist = 0;
                }
            }

            bw.write(String.valueOf(answer));
        }

        bw.flush();
        bw.close();




    }

}