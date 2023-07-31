import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int S = Integer.parseInt(st1.nextToken());

        int[] arr = new int[N];
        int min = Integer.MAX_VALUE;

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int s = 0;
        int e = 0;

        int sum = 0;

        while(true) {
            
            if(sum >= S) {
                min = Math.min(min, e-s);
                sum -= arr[s];
                s++;
                
            }
            else if(e == N) {
                break;
            }
            else {
                sum += arr[e];
                e++;
            }
            
        }
        


        if(min == Integer.MAX_VALUE) {
            bw.write(String.valueOf(0));
        }
        else {
            bw.write(String.valueOf(min));
        }
        bw.flush();
        bw.close();
    }

}