import java.util.*;
import java.io.*;

public class Main {
    static int s, e;
    static boolean[] visited;
    static int[] dist;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        dist = new int[100001];


        for(int i = 0 ; i <= 100000 ; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;

        daick();

        bw.write(String.valueOf(dist[e]));
        bw.flush();
        bw.close();
        
    }

    static void daick() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] {s, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int idx = cur[0];
            if(visited[idx]) continue;
            visited[idx] = true;
            int l = cur[1];

            if(2*idx <= 100000 && dist[2*idx] > dist[idx]) {
                dist[2*idx] = dist[idx];
                pq.add(new int[] {2*idx, dist[2*idx]});
            }

            if(idx+1 <= 100000 && dist[idx+1] > dist[idx]+1) {
                dist[idx+1] = dist[idx]+1;
                pq.add(new int[] {idx+1, dist[idx]+1});
            }

            if(idx-1 >= 0 && dist[idx-1] > dist[idx]+1) {
                dist[idx-1] = dist[idx]+1;
                pq.add(new int[] {idx-1, dist[idx]+1});
            }

            if(visited[e]) return;

        }
    }

}