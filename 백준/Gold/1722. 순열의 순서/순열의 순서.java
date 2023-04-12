import java.io.*;
import java.util.*;

public class Main {
    static int[] subset;
    static long[] F;
    static boolean[] visited;
    static long answer = 1;
    static int N,Q;
    static long K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //초깃값 설정 섭셋, 비지티드, 롱 (21), 엔 큐
        F = new long[21];
        subset = new int[21];
        visited = new boolean[21];

        N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        F[0] = 1;
        for(int i = 1 ; i <= N ; i++) {
            F[i] = F[i-1] * i;
        }

        //Q 1일떄 0일때 매서드 사용 후
        Q = Integer.parseInt(st1.nextToken());

        if(Q == 1) {
            K = Long.parseLong(st1.nextToken());
            Q1();
            for(int i = 1 ; i <= N ; i++) {
                bw.write(String.valueOf(subset[i]) + " ");
            }
        }
        else{
            for(int i = 1 ; i <= N ; i++) {
                subset[i] = Integer.parseInt(st1.nextToken());
            }
            Q2();
            bw.write(String.valueOf(answer));
        }
        
        bw.flush();
        bw.close();



    }
    
    static void Q1 () { //숫자K주고 수열subset구하기
        for(int i = 1 ; i <= N ; i++) { //하나당 섭셋 하나씩 채울것
            int cnt = 1; //팩토리얼 수열 index에 따라 몇번 들어가는지
            for(int j = 1 ; j <= N ; j++) {
                if(visited[j] == true) continue; //사용햇스면 컨티 (2341 이라면 처음에 2 사용하면 더이상 2 못나오니깐)
                if(K <= cnt * F[N-i]) { //n-i팩토리얼이 cnt-1번 까지만 들어간다면
                    subset[i] = j;
                    visited[j] = true;
                    K -= (cnt-1) * F[N-i];
                    break;
                }
                cnt++;
            }
        }
    }
    
    static void Q2 () { //수열subset주고 몇번째인지 숫자K구하기
        for(int i = 1 ; i <= N ; i++) {
            int a = subset[i];
            int cnt = 0;
            for(int j = 1 ; j < a ; j++) {
                if(visited[j] == false) cnt++;
            }
            answer += cnt * F[N-i];
            visited[a] = true;
        }
    }


}