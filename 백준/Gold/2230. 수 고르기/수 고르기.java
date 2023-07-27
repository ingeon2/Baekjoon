import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //1 ≤ N ≤ 100,000 정렬가능하려나 ㅇㅇ 가능함 2초면 2억번.
        //0 ≤ M ≤ 2,000,000,000
        //0 ≤ |A[i]| ≤ 1,000,000,000 -> int 가능

        int s = 0; //같은 수일 수도 있다
        int e = 0;

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int answer = arr[N-1] - arr[0];

        while(e < N) {
            while(e < N && arr[e] - arr[s] < M) {
                e++;
            }
            if(e >= N) break;

            if(arr[e] - arr[s] == M) {
                answer = M;
                break;
            }
            answer = Math.min(answer, arr[e] - arr[s]);
            s++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

}