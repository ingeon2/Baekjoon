import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node> [] A;
    static boolean[] visited;
    static int[] dist;
    static int N, M, R;
    static int[] items;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken()); //지역 개수
        M = Integer.parseInt(st1.nextToken()); //거리 제한
        R = Integer.parseInt(st1.nextToken()); //길의 개수

        items = new int[N+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine()); //아이템 수
        for(int i = 1 ; i <= N ; i++) {
            items[i] = Integer.parseInt(st2.nextToken());
        }



        dist = new int[N+1];



        A = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; i++) {
            A[i] = new ArrayList<Node>();
        }

        for(int i = 0 ; i < R ; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st3.nextToken()); //번호
            int b = Integer.parseInt(st3.nextToken()); //번호
            int c = Integer.parseInt(st3.nextToken()); //길이

            A[a].add(new Node(b, c));
            A[b].add(new Node(a, c));


        }


        //여까지가 준비끝.
        int max = 0;

        for(int i = 1 ; i <= N ; i++) {
            int answer = 0;
            visited = new boolean[N+1];
            for(int k = 1 ; k <= N ; k++) {
                dist[k] = Integer.MAX_VALUE;
            }
            dist[i] = 0;

            daick(i);

            for(int j = 1 ; j <= N ; j++) {
                if(dist[j] <= M) {
                    answer += items[j];
                }
            }

            if(max < answer) max = answer;
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();


    }

    static void daick(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(visited[now.loc]) continue;
            visited[now.loc] = true;

            for(Node next : A[now.loc]) {
                if(next.dist + dist[now.loc] < dist[next.loc]) {
                    dist[next.loc] = next.dist + dist[now.loc];
                    q.add(new Node(next.loc, dist[next.loc]));
                }
            }
        }
    }



    static class Node implements Comparable<Node>{
        int loc;
        int dist;

        public Node(int loc, int dist) {
            this.loc = loc;
            this.dist = dist;
        }

        public int compareTo(Node e) {
            if(this.dist > e.dist) return 1;
            else return -1;
        }
    }

}