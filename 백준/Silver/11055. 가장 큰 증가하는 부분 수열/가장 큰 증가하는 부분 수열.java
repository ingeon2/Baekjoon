import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n  = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] D = new int[n+1];
        for(int i = 1 ; i <= n ; i++) {
            D[i] = arr[i];
            //D[i] = 인덱스 i 까지의 증가하는 부분수열의 합의 최댓값 (i = 3일때, 12일수도 있고 13일수도 있는것.)
            //D[i] = arr[i]인 이유는 나 하나 있는 부분수열의 합은 나 자신이기 때문에 기본값으로 넣어주는 것
        }

        for(int i = 2 ; i <= n ; i++) {
            for(int j = 1 ; j <= i-1 ; j++) {
                if(D[i] < D[j] + arr[i] && arr[i] > arr[j]) D[i] = D[j] + arr[i];
                //여기 핵심,
                //증가하는 부분수열 이므로 arr[i] > arr[j] 만족해야 하고
                //i 보다 작은 인덱스들 j 돌면서, j 까지의 최댓값에 D[j] 내 값 arr[i]를 더한게 더 커야지 갱신가능하다.
            }
        }

        int answer = 0;
        for(int i = 1 ; i <= n ; i++) {
            answer = Math.max(answer, D[i]); //순회하며 최댓값을 뽑아낸다.
        }

        System.out.println(answer);


    }

}