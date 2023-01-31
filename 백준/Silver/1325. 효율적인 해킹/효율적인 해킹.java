import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] Hackings; //가능한 해킹 수 기록할 int[]
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //입력값 대입, 초기값 설정 A[b].add(a) 해야함.
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        Hackings = new int[N+1];
        A = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < M ; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            A[b].add(a);
        }

        //1부터 N까지 visited = 랑  BFS 돌리기. 그럼 Hackings 에 기록되고, 거기서 최댓값 설정한 후 index 오름차순으로 기록하기
        for(int i = 1 ; i <= N ; i++) {
            visited = new boolean[N + 1];
            BFS_from_start(i);
        }

        int max = 0;
        for(int i = 1 ; i <= N ; i++){
            max = Math.max(max, Hackings[i]);
        }
        
        //최댓값 기록된 max 오름차순으로 기록
        for(int i = 1 ; i <= N ; i++){
            if(max == Hackings[i])bw.write(String.valueOf(i) + " ");
        }

        bw.flush();
        bw.close();

    }
    //BFS 만들기. 시작점 start 입력하면, start부터 BFS 다 돌고 Hackings 에 몇번 돌았는지 기록 (할일)Hackings[start]++; 이런식으로
    //언제까지 해야한다는 기록 없어도 됨. 점 하나에서 BFS 할거니까 끝까지 가야함.
    static void BFS_from_start(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();
            for(int n : A[now]){
                if(visited[n] == false){
                    visited[n] =true;
                    q.add(n);
                    //할거하기
                    Hackings[start]++;
                }
            }
        }

    }

}