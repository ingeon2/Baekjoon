import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int s = 0;
        int e = 0;
        int odd = 0;
        int answer = 0;

        while(e < N) {
            if(odd < K) { //홀수 개수 K 보다 적을때
                if(arr[e]%2 == 1)odd++;
                e++; //한칸더감
                answer = Math.max(answer, e-s-odd);
            }
            else if(arr[e]%2 == 0) { //홀수개수 K개 이상이면서 지금 e 짝수
                e++;
                answer = Math.max(answer, e-s-odd);
            }
            else { // K개 이상, 지금 e 홀수
                if(arr[s]%2 == 1) {
                    odd--;
                }
                s++;
            }

        }


        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();

    }


}