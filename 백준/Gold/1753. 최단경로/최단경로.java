import java.io.*;
import java.util.*;

public class Main {
    //최단 경로 기록해놓는 int[] (어디부터의 최단거리라는 기준이 있어야함.)
    static int[] shortest;
    //visited 있어야하나? 최단거리라는 이유로 필요없을듯. 출발점 도착점 같아도 간선 두개도 가능, 즉 같은 점을 여러번 방문해야지 최단거리를 구할 수있으니.
    //그래프 넣어놓을 어레이리스트
    static ArrayList<Node>[] A;
    //방문여부
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //첫 줄 정점V개 간선E개
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st1.nextToken());
        int E = Integer.parseInt(st1.nextToken());

        //둘째 줄 시작정점번호 K
        int K = Integer.parseInt(br.readLine());

        //초깃값 설정, 0안씀
        shortest = new int [V+1];
        for(int i = 1; i <= V ; i++) {
            shortest[i] = Integer.MAX_VALUE;
        }

        A = new ArrayList[V+1];
        for(int i = 1 ; i <= V ; i++){
            A[i] = new ArrayList<Node>();
        }

        visited = new boolean[V+1];


        //셋째 줄 부터 E줄동안 u에서 v로가는 가중치 w 순서.
        for(int i = 0 ; i < E ; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            A[u].add(new Node(v, w));
            //어레이리스트에 노드 추가할때랑, 내가 노드 큐에 넣을때 길이 값이 다르다고. 이해해봐 무슨말인지 ㅋㅋ
        }
        //여기까지가 초깃값 설정.

        daikstra(K);

        //방문햇스면 shortest 해당숫자 내보내주고, 방문 안햇스면 INF 내보내주기
        for(int i = 1 ; i <= V ; i++) {
            if(visited[i]) bw.write(String.valueOf(shortest[i])+"\n");
            else bw.write("INF\n");
        }
        bw.flush();
        bw.close();

    }
    //여긴 다익스트라 구현
    static void daikstra (int start) {
        //우선순위 큐 구현, 시작점 추가(shortest는 0), shortest 초깃값 설정
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(start, 0));
        shortest[start] = 0;
        
        //큐가 빌때까지
        while(!q.isEmpty()) {
            //하나 뽑고 (우선순위라서 얘 어차피 가장 shortest에서 작은놈으로 뽑힘)
            Node now = q.poll();
            //방문 되어있으면 컨티,
            if(visited[now.num] == true) continue;
            //안되어서 여기까지 내려오면 방문여부 체크해주고
            visited[now.num] = true;
            //for 문으로 순회하며
            for(Node next : A[now.num]) {
                //나는 지금 now 에서 next로 가려고 하는 상황.
                //그렇다면 now까지 오는 최단거리 shortest[now.num] 에서 now에서 next까지 가는 거리인 next.length 더한것이
                //지금의 최단거리인 shortest[next.num] 보다 작다면 갱신해줘야지. 거리 업데이트하는 로직 이해하기
                //거리 업데이트 하고, 큐에 넣기
                if(shortest[now.num] + next.length < shortest[next.num]) {
                    shortest[next.num] = shortest[now.num] + next.length;
                    q.add(new Node(next.num, shortest[next.num]));
                }
            }
        }
    }


    //가장먼저 노드 클래스 만들기. 어레이리스트[1] - (2, 3), (3, 5) 이런식으로, 길이 여러개면 (2, 3) (2, 5) 이런식도 가능
    //그리고, 다익스트라 알고리즘은 다음 단계 찾을때, 내가 구하려고 하는 shortest 에서 그때 당시에 최솟값을 갖는 쪽으로 가야해.
    //그렇기 위해선 우선순위 큐 사용해야지. (length값이 작을수록 먼저 빠져나와야 하니까)
    public static class Node implements Comparable<Node>{
        int num;
        int length;

        public Node(int num, int length) {
            this.num = num;
            this.length = length;
        }
        
        public int compareTo(Node e) { //어렵고 이해 안가면 이거 그냥 오름차순이다 외우기
            if(this.length > e.length) return 1;
            else return -1;
        }

    }
}