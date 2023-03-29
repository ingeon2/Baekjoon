import java.io.*;
import java.util.*;

public class Main {
    //정답 dist[] 크기 N 0빼고사용 (첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력)
    static int[] dist;
    //비지티드 (방문안햇스면 INF 출력해야하거든)
    static boolean[] visited;
    //그래프
    static ArrayList<Node>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //첫째 줄에 정점의 개수 V와 간선의 개수 E
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st1.nextToken());
        int E = Integer.parseInt(st1.nextToken());
        //둘째 줄에는 시작 정점의 번호 K
        int K = Integer.parseInt(br.readLine());
        //초깃값설정
        dist = new int[V+1];
        visited = new boolean[V+1];
        A = new ArrayList[V+1];
        for(int i = 1 ; i <= V ; i++) {
            A[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }
        //셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로
        for(int i = 0 ; i < E ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            A[u].add(new Node(v, w));
        }

        BFS(K);



        for(int i = 1 ; i <= V ; i++) {
            if(visited[i] == true) {
                bw.write(String.valueOf(dist[i]) + "\n");
            }
            else{
                bw.write("INF\n");
            }
        }

        bw.flush();
        bw.close();
    }
    
    //BFS돌면서 dist배열 바꿔주자(if문으로 작으면 갱신). 시작점은 0으로,
    static void BFS(int start) {
        dist[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(visited[now.num] == true) continue;
            visited[now.num] = true;

            for(Node next : A[now.num]) {
                if(dist[next.num] > dist[now.num] + next.length) {
                    dist[next.num] = dist[now.num] + next.length;
                    q.add(new Node(next.num, dist[next.num]));
                }

            }
        }
    }


    //어레이리스트 사용할 노드
    static class Node implements Comparable<Node>{
        int num;
        int length;

        public Node(int num, int length) {
            this.num = num;
            this.length = length;
        }

        public int compareTo(Node e) {
            if(this.length > e.length) return 1;
            else return -1;
        }
    }
}
