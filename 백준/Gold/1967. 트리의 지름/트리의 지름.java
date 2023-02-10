import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //입력값 대입 N
        int N = Integer.parseInt(br.readLine());

        if(N == 1){ //N이 1이라면 0개의 줄에 표현. 그냥 지름 0
            System.out.println(String.valueOf(0));
        }
        else{
            //N개의 Node 어레이리스트 만들어야해.
            A = new ArrayList[N+1];
            for(int i = 1 ; i <= N ; i++){
                A[i] = new ArrayList<Node>();
            }

            //초깃값
            visited = new boolean[N+1];
            distance = new int[N+1];

            //N-1줄에 숫자 세개씩 부모노드 자식노드 가중치 순서.
            for(int i = 1 ; i <= N-1 ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                A[a].add(new Node(b, c));
                A[b].add(new Node(a, c));
            }

            //트리의 지름 출력(BFS, DFS 둘다 가능)
            DFS(1);

            //최대거리 점 위치 기억
            int max_point = 0;
            int dt = 0;
            for(int i = 1 ; i <= N ; i++){
                if(distance[i] > dt){
                    dt = distance[i];
                    max_point = i;
                }
            }

            //초기화 후 DFS
            visited = new boolean[N+1];
            distance = new int[N+1];
            DFS(max_point);



            Arrays.sort(distance);
            bw.write(String.valueOf(distance[N]));
            bw.flush();
            bw.close();

        }





    }
    //DFS는 어떤 한 점을 잡고 DFS 한 후, (비지티드 초기화) 한 점에서 가장 먼 점에서 다시 DFS 한 후 최장거리 측정.
    //distance에 넣을까..? 대입한 점의 distance[n.num]에 n.value 더하는거지..
    static void DFS(int start){
        //방문기록
        visited[start] = true;

        //대입한 점 친구들 돌기
        for(Node n : A[start]){
            //방문안햇스면
            if(visited[n.num] == false){
                //방문해주고
                visited[n.num] = true;
                //할거 하자
                distance[n.num] = distance[start] + n.value;
                DFS(n.num);
            }
        }
    }



    static class Node{
        int num;
        int value;

        public Node(int num, int value){
            this.num = num;
            this.value = value;
        }
    }

}