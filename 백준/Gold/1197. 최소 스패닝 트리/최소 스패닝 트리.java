import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static int[] repre;
    static int n_e = 0; //지금 만들어진 간선의 수
    static int answer = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        repre = new int[v+1];
        for(int i = 1 ; i <= v ; i++) {
            repre[i] = i;
        }
        

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for(int i = 0 ; i < e ; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken()); //시작점
            int t = Integer.parseInt(st.nextToken()); //끝점
            int l = Integer.parseInt(st.nextToken()); //길이

            pq.add(new int[] {f, t, l});
            
        }

        //간선 n-1개 만든 후 끝내기
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int f = cur[0];
            int t = cur[1];
            int l = cur[2];

            if(find(f) == find(t)) continue;

            union(f, t);
            answer += l;
            n_e++;

            if(n_e == v-1) break;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static void union(int a, int b) {
        int min  = Math.min(find(a), find(b));
        int max  = Math.max(find(a), find(b));

        repre[min] = max;
    }

    static int find(int a) {
        if(repre[a] == a) return a;
        return repre[a] = find(repre[a]);

    }
    
}