import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException , NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int[] cnt = new int[100001];

        //투포인터 알고리즘 0 0에서시작, e올릴만큼 올리고, s또한 다시 e가 올라갈 수 있을만큼만 올리기
        int answer = 0;
        int s = 0;
        int e = 0;
        while(e < N) {
            while(e < N && cnt[arr[e]] + 1 <= K) {
                cnt[arr[e]]++;
                e++;
            }
            if(e-s > answer) answer = e-s;
            cnt[arr[s]]--;
            s++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }


}