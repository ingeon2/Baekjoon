import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> [] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //첫째 줄에는 컴퓨터의 수가 주어진다.
        //컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
        //둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
        //이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < K ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        bw.write(String.valueOf(BFS()));
        bw.flush();
        bw.close();

        
    }
    static int BFS() {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : A[cur]) {
                if(!visited[next]) {
                    q.add(next);
                    answer++;
                    visited[next] = true;
                }
            }
        }

        return answer;
    }


}