import java.io.*;
import java.util.*;

public class Solution {
    static int max;
    static boolean[] v;
    static ArrayList<Integer> [] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int c = Integer.parseInt(br.readLine());

        //N개의 정점과 M개의 간선으로 구성된 가중치가 없는 무방향 그래프에서의 최장 경로의 길이를 계산
        for(int i = 1 ; i <= c ; i++) {
            //NM나오고
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            //M개 간선 정보 나옴
            A = new ArrayList[N+1]; //1부터 N까지
            for(int j = 1 ; j <= N ; j++) {
                A[j] = new ArrayList<>();
            }

            max = 0;

            for(int j = 1 ; j <= M ; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                A[a].add(b);
                A[b].add(a);
            }

            for(int j = 1 ; j <= N ; j++) {
                v = new boolean[N+1];
                v[j] = true;
                dfs(j, 1);
                v[j] = false;
            }

            bw.write("#" + String.valueOf(i) + " " + String.valueOf(max) + "\n");


        }



        bw.flush();
        bw.close();
        br.close();
    }
    
    static void bfs(int start) {
        v[start] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 1));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            max = Math.max(max, cur.l);

            for(int next : A[cur.idx]) {
                if(v[next]) continue;
                q.add(new Node(next, cur.l+1));
                v[next] = true;
            }
        }

    }

    static class Node {
        int idx;
        int l;

        public Node (int idx, int l) {
            this.idx = idx;
            this.l = l;
        }
    }

    static void dfs(int start, int cnt) {

        for(int next : A[start]) {
            if(v[next]) continue;
            v[next] = true;
            dfs(next, cnt+1);
            v[next] = false;
        }

        max = Math.max(max, cnt);
    }

}
