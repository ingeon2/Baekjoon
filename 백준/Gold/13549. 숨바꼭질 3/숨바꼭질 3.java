import java.io.*;
import java.util.*;

public class Main {
    static int[] time;
    static int N,K;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        time = new int[100001];
        visited = new boolean[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= 100000 ; i++) {
            time[i] = Integer.MAX_VALUE;
        }


        fill_D_BFS();
        bw.write(String.valueOf(time[K]));
        bw.flush();
        bw.close();

    }
    static void fill_D_BFS() {
        time[N] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(N, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();
            int now_loc = now.loc;
            int now_time = now.time;
            visited[now_loc] = true;

            if(2*now_loc <= 100000 && visited[2*now_loc] == false) {
                time[2*now_loc] = Math.min(now.time, time[2*now_loc]);
                q.add(new Node(2*now_loc, time[2*now_loc]));
            }

            if(now_loc+1 <= 100000 && visited[now_loc+1] == false) {
                time[now_loc+1] = Math.min(now.time+1, time[now_loc+1]);
                q.add(new Node(now_loc+1, time[now_loc+1]));
            }

            if(now_loc-1 >= 0 && visited[now_loc-1] == false) {
                time[now_loc-1] = Math.min(now.time+1, time[now_loc-1]);
                q.add(new Node(now_loc-1, time[now_loc-1]));
            }

            if(visited[K] == true) break;
        }



    }

    static class Node implements Comparable<Node>{
        int loc;
        int time;
        public Node(int loc, int time) {
            this.loc = loc;
            this.time = time;
        }

        public int compareTo(Node e) {
            if(this.time > e.time) return 1;
            else return -1;
        }
    }
}
//굳이 D와 Node 클래스 둘다 만든 이유 생각. (다익)