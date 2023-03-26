import java.io.*;
import java.util.*;

public class Main {
    //BFS 불리언 여부에 따라 적을수도 안적을수도, BFS자체에서 리턴값
    static int answer = 0;
    static boolean can_exit;
    //앞뒤양옆 (상하좌우)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    //map, 방문가능한지 여부 boolean(캔낫 비지티드, 불이든 벽이든 통과못하는건 마찬가지이니)
    static String[][] map;

    //여기서 static으로 만들어주는 이유 생각 (불이 아예 업다면..? 000들어가버림 ..ㅠ)
    static Queue<Node> me, fire;

    //방문여부체크(오직 J와 me 에서면)
    static boolean[][] visited;

    //행열
    static int R,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력 첫줄 숫자 두개 미로 행 개수, 열 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        visited = new boolean[R][C];

        me = new LinkedList<>();
        fire = new LinkedList<>();


        // #벽 .지나갈수잇는공간 J미로초기위치 F불
        // 지훈이는 미로의 가장자리에 접한 공간에서 탈출
        //map 입력하며 벽, 불은 캔낫 비지티드 트루로 바꿔놓기.
        for(int i = 0 ; i < R ; i++) {
            String S = br.readLine();
            for(int j = 0 ; j < C ; j++) {
                String s = S.substring(j, j+1);
                map[i][j] = s;

                if(s.equals("J")) {
                    me.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }

                if(s.equals("F")) {
                    fire.add(new Node(i, j, 0));
                }
            }
        }

        if(exit_bfs()) {
            bw.write(String.valueOf(answer));
        }
        else{
            bw.write("IMPOSSIBLE");
        }

        bw.flush();
        bw.close();


    }
    static boolean exit_bfs() {

        while(!me.isEmpty()) {

            //불 먼저 퍼지는것으로 고려해야함, 불 BFS 로직
            int f_size = fire.size();
            for(int i = 0 ; i < f_size ; i++) {
                Node a = fire.poll();

                for(int j = 0 ; j < 4 ; j++) {
                    int nr = a.r + dr[j];
                    int nc = a.c + dc[j];

                    if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
                        if(map[nr][nc].equals(".") || map[nr][nc].equals("J")) {
                            map[nr][nc] = "F";
                            fire.add(new Node(nr, nc, 0));
                        }
                    }
                }
            }


            //여기는 내 현재 위치 BFS로직
            int m_size = me.size();
            for(int i = 0 ; i < m_size ; i++) {
                Node a = me.poll();

                
                //근데 꺼낸놈이 별볼일없으면 다시 들어가게 큐에 해주는 로직 작동
                for(int j = 0 ; j < 4 ; j++) {
                    int nr = a.r + dr[j];
                    int nc = a.c + dc[j];
                    int nt = a.time + 1;

                    //꺼낸놈이 경계라면 탈출가능하다 (현재 시간 + 1 하면 탈출시간, 그다음 탈출가능 여부 boolean 변형)
                    if(nr < 0 || nr > R-1 || nc < 0 || nc > C-1) {
                        answer = a.time + 1;
                        return true;
                    }


                    if(visited[nr][nc] == false && map[nr][nc].equals(".")) {
                        visited[nr][nc] = true;
                        me.add(new Node(nr, nc, nt));
                    }
                }
            }

        }

        return false;

    }



    static class Node {
        int r;
        int c;
        int time;

        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

}