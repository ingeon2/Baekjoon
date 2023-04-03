import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;


    static int N,L,R;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        L = Integer.parseInt(st1.nextToken());
        R = Integer.parseInt(st1.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int answer = 0;
        while(true) {

            int times = 0;
            visited = new boolean[N][N];

            for(int i = 0 ; i < N ; i++) {
                for(int j = 0 ; j < N ; j++) {
                    if(visited[i][j] == false) {
                        BFS(i, j);
                        times++;
                    }
                }
            }

            if(times == N*N) break;

            answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();


    }

    static void BFS(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;
        sum = map[r][c];
        ArrayList<int[]> friends = new ArrayList<>();
        friends.add(new int[] {r, c});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int now_r = now[0];
            int now_c = now[1];
            for(int i = 0 ; i < 4 ; i++) {
                int next_r = now_r + dr[i];
                int next_c = now_c + dc[i];

                if(next_r >= 0 && next_r <= N-1 && next_c >= 0 && next_c <= N-1 && visited[next_r][next_c] == false
                     && Math.abs(map[now_r][now_c] - map[next_r][next_c]) >= L && Math.abs(map[now_r][now_c] - map[next_r][next_c]) <= R) {
                    sum += map[next_r][next_c];
                    visited[next_r][next_c] = true;
                    friends.add(new int[] {next_r, next_c});
                    q.add(new int[] {next_r, next_c});
                }
            }
        }

        //와일 마치는게 한뭉탱이마치는거니까 인구이동 해주기
        for(int i = 0 ; i < friends.size() ; i++) {
            int[] friend = friends.get(i);
            map[friend[0]][friend[1]] = sum/friends.size();
        }

    }
    
}