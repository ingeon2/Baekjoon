import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static  boolean[][] visited;
    //상 하 좌 우 dr, dc
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    //BFS에서 for안에서 사용할 N
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }
        //여까지 초깃값
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 1 && visited[i][j] == false) {
                    arr.add(BFS(i, j));
                }
            }
        }

        Collections.sort(arr);

        bw.write(String.valueOf(arr.size()) + "\n");

        for(int i = 0 ; i < arr.size() ; i++){
            bw.write(String.valueOf(arr.get(i)) + "\n");
        }
        bw.flush();
        bw.close();



    }
    //몇번 했는지는 for문에서 방문 안햇고 + 1이면 , cnt++하고 DFS하기. 그럼 cnt가 몇번했는지 나타냄.
    //크기가 어느정도인지를 DFS, BFS 상관없이 몇개를 통과시켰는지. DFS는 횟수! BFS는 큐에 들어갔다 나올때마다 리턴값++ 해주기

    static int BFS(int r, int c) {
        //int[] 들어갈 큐 만들고 넣어주기
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        //초깃값 방문체크하기
        visited[r][c] = true;
        // 인트 리절트 = 0, 리턴값
        int result = 0;

        //큐가 빌때까지
        while(!q.isEmpty()){
            //하나 뽑고 리절트 쁠쁠해주기(리절트 쁠쁠이 해줄거 하는것)
            int[] now = q.poll();
            result++;
            //for문으로 0부터4보다작을때까지
            for(int i = 0 ; i < 4 ; i++){
                //뽑은거에 dr[i], dc[i] 더해주고, 그 값이
                int new_r = now[0] + dr[i];
                int new_c = now[1] + dc[i];
                //인덱스에 제한없고(0보다 크고 입력값 N보다 작고) + 만약 방문 안했으면 + 값이 0이 아니라면(못가는곳)
                if(new_r >= 0 && new_c >= 0 && new_r < N && new_c < N && visited[new_r][new_c] == false && map[new_r][new_c] != 0){
                    //큐에 더해주기, 방문표시해주기
                    visited[new_r][new_c] = true;
                    q.add(new int[] {new_r, new_c});
                }

            }


        }
        return result;
    }

}