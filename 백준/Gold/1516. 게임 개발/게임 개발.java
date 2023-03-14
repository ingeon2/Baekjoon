import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        //첫 숫자는 for문 몇번 돌건지.
        int N = Integer.parseInt(br.readLine());
        
        //visited, D, time(걸리는최소시간), ArrayList A 만들기
        int[] D = new int[N+1];
        int[] self_time = new int[N+1];
        ArrayList<Integer>[] A = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<Integer>();
        }
        //for문으로 , 각 줄마다 st 첫토큰은 dist, while으로 -1 아니라면 A[i].add(넥토)
        for(int i = 1; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            self_time[i] = Integer.parseInt(st.nextToken());

            while(true) {
                int a = Integer.parseInt(st.nextToken());
                if(a == -1) {
                    break;
                }
                else {
                    A[a].add(i);
                    D[i]++; //i 앞에 나와야할 친구들의 수를 추가시켜주는것
                }

            }
        }



        //q, 결과 int[] 생성
        Queue<Integer> q = new LinkedList<Integer>();
        int[] result = new int[N+1];

        //D == 0이면 q에 add
        for(int i = 1 ; i <= N ; i++) {
            if(D[i] == 0) {
                q.add(i);
                result[i] = self_time[i];
            }
        }
        
        //q가 빌때까지
        while(!q.isEmpty()) {
            //하나 뽑고 방문여부 체크, 그친구들 for로 돌기
            int a = q.poll();

            for(int b : A[a]) {
                //time 만드는 로직은 for문으로 어레이리스트 해당 점 친구들 돌면서 D-- 해주고
                D[b]--;

                //time 로직 실현 이거 이해하기 (b 만들기 직전까지 얼마나 걸리는지 result에 기록)
                result[b] = Math.max(result[b], result[a] + self_time[b]);
                //D -- 한 후에 0이라면 q에 넣기
                
                if(D[b] == 0) {
                    q.add(b);

                }
                
            }

        }

        for(int i = 1 ; i <= N ; i++) {
            bw.write(String.valueOf(result[i]) + "\n");
        }
        bw.flush();
        bw.close();

    }

}