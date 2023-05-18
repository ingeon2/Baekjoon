import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int budget = Integer.parseInt(br.readLine());
        arr = new int[10001];



        int max = 0;
        long sum = 0;
        for(int i = 0 ; i < N ; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(max < a) max = a;
            arr[i] = a;
            sum += a;
        }

        if(sum < budget) bw.write(String.valueOf(max));
        else {
            int s = 0;
            int e = max;


            while(s <= e) {
                int m = (s+e)/2;
                if(budget < totalMoney(arr, m)) e = m-1;
                else s = m + 1;
            }

            bw.write(String.valueOf(e));
        }

        bw.flush();
        bw.close();

    }

    static long totalMoney(int[] arr, int m) {
        long total = 0;
        for(int a : arr) {
            if(a > m) total += m;
            else total += a;
        }

        return total;
    }



}