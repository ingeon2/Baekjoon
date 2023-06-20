import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node> [] A;
    static boolean[] visited;
    static int[] cost;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        visited = new boolean[N+1];

        cost = new int[N+1];
        for(int i = 0 ; i <= N ; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[1] = 0;

        A = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; i++) {
            A[i] = new ArrayList<Node>();
        }

        for(int i = 0 ; i < M ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());

            A[a].add(new Node(b, c));
            A[b].add(new Node(a, c));

        }


        //여까지가 준비끝.

        daick();
        bw.write(String.valueOf(cost[N]));
        bw.flush();
        bw.close();

    }

    static void daick() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(visited[now.loc]) continue;
            visited[now.loc] = true;

            for(Node next : A[now.loc]) {
                if(next.cost + cost[now.loc] < cost[next.loc]) {
                    cost[next.loc] = next.cost + cost[now.loc];
                }
                if(!visited[next.loc]) {
                    q.add(new Node(next.loc, cost[next.loc]));
                }
            }
        }
    }



    static class Node implements Comparable<Node>{
        int loc;
        int cost;

        public Node(int loc, int cost) {
            this.loc = loc;
            this.cost = cost;
        }

        public int compareTo(Node e) {
            if(this.cost > e.cost) return 1;
            else return -1;
        }
    }

}