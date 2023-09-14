import java.util.*;
import java.io.*;


public class Main {
    static int[] arr;
    static int n;
    static int want;
    static int answer;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        want = Integer.parseInt(st.nextToken());
        answer = 0;
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 1 ; i <= n ; i++) {
            bt(i, 0, 0, 0);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
    
    static void bt(int m, int d, int start, int sum) { // m값 1부터 5까지, m값 1부터 5까지
        if(m == d) {
            if(sum == want) answer++;
            return;
        }

        for(int i = start ; i < n ; i++) {
            bt(m, d+1, i+1, sum+arr[i]);
        }
        
    }

}