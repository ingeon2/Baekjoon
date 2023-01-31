import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static  int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //입력값 대입, 초기값 설정
        //첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());
        int X = Integer.parseInt(st1.nextToken());

        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        distance = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < M ; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            A[a].add(b);
        }

        BFS(X);

        for(int i = 1 ; i <= N ; i++){
            if(distance[i] == K)sb.append(String.valueOf(i) + "\n");
        }

        if (sb.length() == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(sb);
        }


    }

    //최소 거리 k인 점 뽑아내기
    //BFS로 어레이리스트 만들고, visited만든 후 큐로 구현.
    //while문이 원래 큐가 빌때까지인데, 점과의 distance 거리 기록하는 int[] 만들자.
    //node 점, 거리 만들자. for(int n : A[q.poll()])
    //distance[n.num] = distance[q.poll()]+1
    static void BFS(int start){ //이게 끝나면 distance에 start로부터의 최소거리 나와있음.
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            for(int n : A[now]){
                if(visited[n] == false){
                    q.add(n);
                    visited[n] = true;
                    distance[n] = distance[now] + 1;
                }
            }
        }
    }
}