
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    static int[] check;
    static boolean stop; //이분아니면 멈춰줄 친구
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //초깃값 K = 테스트케이스, 테스트케이스마다 초깃값 설정 다시해줘야함
        int K = Integer.parseInt(br.readLine());
        
        for(int i = 1 ; i <= K ; i++){
            //초깃값 어레이리스트, 비지티드 설정
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st1.nextToken());
            int E = Integer.parseInt(st1.nextToken());

            stop = false;
            A = new ArrayList[V+1];
            check = new int[V+1];
            visited = new boolean[V+1];

            for(int j = 1 ; j <= V ; j++){
                A[j] = new ArrayList<Integer>();
            }

            for(int j = 1 ; j <= E ; j++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                A[a].add(b);
                A[b].add(a);
            }

            //위까지 입력값 대입 끝.
            //여기부터 for (1~), 비지티드 트루고 스탑이 폴스면  DFS 돌려줄거야
            //전부 돌리고 나서 스탑이 폴스면 예스,트루면 노
            for(int j = 1 ; j <= V ; j++){
                if(visited[j] == false && stop == false){
                    DFS(j);
                }
            }

            if(stop == false)bw.write("YES\n");
            else bw.write("NO\n");

        }
        bw.flush();
        bw.close();




    }

    //방문기록남기고 for문 드갓스면, 안드갓스면

    //여기서부터 할거 하기 DFS 하자. 어떻게할거냐면,
    // 비지티드 폴스면(안드갓스면) check을 설정해주고
    // 1. 이분 그래프인지 찾으려면 DFS 하면서 check[] 에 0,1,0,1,0,1 이런식으로 가야지(인접과 다르다)
    // 2. 방문기록, DFS
    // 들어갔으면 인접한 두 점이니 check이 다른지 봐야지. 같다면 브레이크걸고 NO 갈겨도 된다.

    static void DFS(int start){ //DFS 전 리턴 조건이랑, 방문기록
        if(stop == true)return;
        visited[start] = true;
        

        for(int n : A[start]){ //본게임
            if(visited[n] == false){
                visited[n] = true;
                check[n] = (check[start] + 1) % 2; //0→1, 1→0
                DFS(n);
            }
            else if(check[n] == check[start]){
                stop = true;
                return;
            }
        }
    }

}