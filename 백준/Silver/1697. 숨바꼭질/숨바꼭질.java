import java.io.*;
import java.util.*;

public class Main {
    //비지티드 크기 100001, int형. 여기에 cnt넣어야지.
    static int[] visited;
    //점은 static 으로해서 매서드에서 사용해야지
    static int a, want;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        want = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        BFS(a);
        bw.write(String.valueOf(visited[want]-1));
        bw.flush();
        bw.close();

    }
    //int 리턴하는 BFS(시작점) 만들거야
    static void BFS(int start){
        //큐는 시작점을 포함하는 놈으로 구현하고 넣기
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        //방문기록 비지티드에 0먼저 남기기
        visited[start] = 1;

        

        //큐가 빌때까지(안빔)
        while(!q.isEmpty()){
            //큐에서 하나 뽑고 int n
            int n = q.poll();
            
            //n+1 방문안햇스면(0이면) + 크기제한 안걸리면 방문해야지(visited[n+1] = 비지티드 엔 더하기 일)
            if(n+1 <= 100000 && visited[n+1] == 0) {
                visited[n+1] = visited[n] + 1;
                q.add(n+1);
            }
            //엔마일 엔곱이 다해주기
            if(n-1 >= 0 && visited[n-1] == 0) {
                visited[n-1] = visited[n] + 1;
                q.add(n-1);
            }
            if(n*2 <= 100000 && visited[n*2] == 0) {
                visited[n*2] = visited[n] + 1;
                q.add(n*2);
            }

        }

    }
    
}