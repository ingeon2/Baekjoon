import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n  = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][2];
        for(int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[n+2];

        for(int i = 2 ; i <= n+1 ; i++) {
            for(int j = 1 ; j <= i-1 ; j++) {
                if(j + arr[j][0] <= i && D[i] < D[j] + arr[j][1]) D[i] = D[j] + arr[j][1];
            }
        }

        int answer = 0;
        for(int i = 2 ; i <= n+1 ; i++) {
            answer = Math.max(answer, D[i]);
        }

        System.out.println(answer);

    }

}