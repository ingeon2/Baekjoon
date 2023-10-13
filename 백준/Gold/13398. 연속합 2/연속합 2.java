import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] D1 = new int[N];
        //D1[i] = arr[i]로 마치는 연속하는 수열들 중에서 원소들 합의 최댓값, 즉 arr[i]를 반드시 포함해야 함
        //ex) arr = {1 2 3} -> D1[2] = 1 + 2 + 3 = 6,    || arr = {-1, -2, 3} -> D1[2] = 3
        //arr[i]로 마치는건 분명하지만 어디에서 시작하는 지는 알 수 없다.
        
        int[] D2 = new int[N];
        //D2[i] = arr[i]로 시작하는 연속수열중 최댓값
        //arr[i]로 시작하는건 분명하지만 어디에서 마치는 지는 알 수 없다.
        
        //위 두개를 이해 잘해놓으면 문제가 쉬워진다.

        D1[0] = arr[0];
        D2[N-1] = arr[N-1];
        //초깃값 설정
        int answer = D1[0];
        //해당 값을 시작으로 최댓값 매번 갱신해서 답으로 출력

        for(int i = 1 ; i < N ; i++) {
            D1[i] = Math.max(D1[i-1] + arr[i], arr[i]);
            D2[N-i-1] = Math.max(D2[N-i] + arr[N-i-1], arr[N-i-1]);
            answer = Math.max(answer, D1[i]);
        }

        //여기까지 오면, answer에는 오직 연속되었을때의 최댓값이 등록된다.
        //그렇다면, 문제에서 주어진대로 단 하나만 건너 뛰었을 때는 어떻게 봐야할까?
        //D1[i-1]은 i-1로 마치는 수열중 최고, D2[i+1]은 i+1로 시작하는 수열중 최고이다.
        //그렇다면, 두개의 값을 더하면(D1[i-1] + D2[i+1]), arr[i]를 제외하고, 연속되는 수열 중 최고가 되는것이다.
        //연속되는 수열 중에서, 오직 arr[i]값만 빼놓고 최댓값이 나오는 것이다.
        //마찬가지로 해당 로직을 순회하며 answer 값을 갱신시켜주면 된다.
        for(int i = 1 ; i+1 <= N-1 ; i++) {
            answer = Math.max(D1[i-1]+D2[i+1], answer);
        }



        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

}