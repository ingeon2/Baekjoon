import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 하이퍼루프도 노드로 보자: x번째 하이퍼루프를 N+x index에 할당
        // 그래서 visited와 distance, 그리고 그래프 A 배열의 크기도 그에 맞게 설정
        ArrayList<Integer>[] A = new ArrayList[N+1+M];
        for (int i = 0 ; i <= N+M ; i++) {
            A[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[N+1+M];
        int[] distance = new int[N+1+M];

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int num = Integer.parseInt(st1.nextToken());
                A[num].add(N+i+1); //해당 역에 하이퍼루프 추가
                A[N+i+1].add(num); //해당 하이퍼루프에 역 추가
            }
        }

        //위와 같이 초깃값 세팅하면,
        //1번 역의 하이퍼루프로 가서 해당 하이퍼루프의 역들을 돌고
        //해당 하이퍼루프의 역에서 또 하이퍼루프로 가고
        //이렇게 된다.
        //즉, 따라서 1에서 N을 간다고 하면, 어떠한 경로이든 하이퍼루프 노드, 실제 노드를 번갈아가면서 간다.
        //그래서 거리는 하이퍼루프를 돌때는 추가되어야하지 않지만 +1 되니까, /2 를 해주어야 한다.

        // BFS
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(1);
        visited[1] = true;
        distance[1] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next: A[now]) {
                if (visited[next]) continue;
                visited[next] = true;
                distance[next] = distance[now]+1;
                q.add(next);
            }
        }

        if(visited[N]) {
            bw.write(String.valueOf(distance[N]/2 + 1));
        }
        else {
            bw.write(String.valueOf(-1));
        }

        bw.flush();
        bw.close();
    }


}