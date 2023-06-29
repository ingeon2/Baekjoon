import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0}; //상, 하, 좌, 우 순서
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        map = new int[R][C];
        visited = new boolean[R][C];
        
        for(int r = 0 ; r < R ; r++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < C ; c++) {
                map[r][c] = Integer.parseInt(st2.nextToken());
            }
        }
        
        //초깃값 세팅
        int max = 0; //뭉탱이의 최댓값
        int answer = 0; //몇개의 뭉탱이를 돌았는지

        for(int r = 0 ; r < R ; r++) {
            for(int c = 0 ; c < C ;c++) {

                if(visited[r][c] == false && map[r][c] == 1) { //r, c 방문 안했고, map 값이 1이라면
                    answer++; //뭉탱이 하나 돌았고

                    int a = BFS(r, c);
                    if(max < a) { //돌면서 뭉탱이 안에 몇개있는지 최댓값 갱신
                        max = a;
                    }
                }

            }
        }

        bw.write(String.valueOf(answer) + "\n");
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }
    
    static int BFS(int r, int c) { //BFS 두가지 역할 수행. 통과한 행렬 체크 + 몇개 통과했는지 리턴(max 값 뽑기)
        Queue<int[]> q = new LinkedList<>();
        int how_many = 0;
        q.add(new int[] {r, c});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            how_many++;
            visited[now[0]][now[1]] = true;


            for(int i = 0 ; i < 4 ; i++) {
                int next_r = now[0] + dr[i];
                int next_c = now[1] + dc[i];

                if(next_r >= 0 && next_c >= 0 && next_r < R && next_c < C && //index 만족하고
                        visited[next_r][next_c] == false && map[next_r][next_c] == 1) { //방문 안했고 값이 1이라면
                       q.add(new int[] {next_r, next_c});
                       visited[next_r][next_c] = true;

                }
            }

        }

        //여기까지 오면 BFS 끝, 몇개돌았는지 return
        return how_many;
    }

}