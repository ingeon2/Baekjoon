import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //투포인터

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int s = 0;
        int e = N-1;
        int as = s;
        int ae = e;
        long min = Long.MAX_VALUE;

        while(s < e) {
            long sum = arr[s] + arr[e];

            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                as = s;
                ae = e;
            }

            if(sum > 0) {
                e--;
            }
            else {
                s++;
            }
        }

        bw.write(String.valueOf(arr[as]) + " " + String.valueOf(arr[ae]));
        bw.flush();
        bw.close();

    }
    
}