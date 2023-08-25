import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node> nodes; //모든 노드들 넣어놓기 (순회하며 거리잴용도)
    static ArrayList<Integer> [] A; //점과 점 사이 거리 1000이하면 그래프 만들기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int tc = Integer.parseInt(br.readLine());
        
        for(int c = 0 ; c < tc ; c++) {
            
            int n = Integer.parseInt(br.readLine());
            nodes = new ArrayList<>(); //0번째가 집, n+1번째가 축제
            A = new ArrayList[n+2];
            for(int i = 0 ; i < n+2 ; i++) {
                A[i] = new ArrayList<>();
            }
            
            for(int i = 0 ; i < n+2 ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                nodes.add(new Node(x, y));
            }

            for(int i = 0 ; i < n+2 ; i++) {
                for(int j = i+1 ; j < n+2 ; j++) {
                    if(dist(nodes.get(i), nodes.get(j))) { //거리만족하면 이어주기
                        A[i].add(j);
                        A[j].add(i);
                    }
                }
            }

            if(BFS(n)) {
                bw.write("happy\n");
            }
            else {
                bw.write("sad\n");
            }

            
        }

        bw.flush();
        bw.close();
        

    }
    static boolean BFS(int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+2];
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == n+1) return true;

            for(int next : A[cur]) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }

        return false;
    }

    static boolean dist (Node a, Node b) {
        int x = Math.abs(a.x - b.x);
        int y = Math.abs(a.y - b.y);
        
        if(x + y <= 1000) return true;
        else return false;
    }


    static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}