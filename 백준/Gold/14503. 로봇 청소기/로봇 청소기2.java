import java.io.*;
import java.util.*;

public class Main {
    //인덱스때문에
    static int N, M;
    //map 1은벽 0은청소할곳, 청소 후엔 3으로 바꿔주기.
    static int[][] map;
    //정답 보여줄 answer
    static int answer = 0;
    //상 우 하 좌 dr dc, 여기는 행열. 맨 왼쪽 위 00 시작. (북동남서) = 상 좌 하 우 / 후진은 +2, 반시계90도는 +3
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //이문제는 (0, 0)부터 (N-1, M-1) 까지임 가로N 세로M
        //첫줄은 N과 M 크기
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        //둘째줄은 두 점 위치와 방향 (숫자 세개)
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st2.nextToken());
        int c = Integer.parseInt(st2.nextToken());
        int direction = Integer.parseInt(st2.nextToken());


        //static 변수들 초깃값 설정. (청소, 맵)
        map = new int[N][M];

        //맵 먼저 하고
        for(int i = 0 ; i < N ; i++){ //행
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){ //열
                map[i][j] = Integer.parseInt(st3.nextToken());
            }
        }

        //여기까지 초깃값 설정.
        //DFS 갈겨주고
        DFS(r, c, direction);
        //answer을 출력
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }
    //void로 청소해주면서 static 변수 ++ 해주는 함수.
    static void DFS(int now_r, int now_c, int direction) {
        //청소안되어잇스면 청소하고 answer++;
        if(map[now_r][now_c] == 0) {
            map[now_r][now_c] = 3;
            answer++;
        }
        //맨 처음의 direction 기록해놓기 (네칸 다 청소 되어있다면, 기록해놓은 방향의 반대방향을 아래에서 사용해야하니.)
        int standard = direction;

        //네칸중에 아무 칸이라도 청소를 했는지 여부 (청소하면 트루로 바꿔줄것)
        boolean any_clean = false;

        //for문으로 4방향 돌아보며 각각의 다음칸과 다음 방향 기록하며,
        //청소 안되어있는곳 찾기.
        //여기 잘해야하는게 순서가 반시계 90 회전, 그 기준 한칸 앞방향이 청소 안되어있으면, 그 칸 청소(재귀)
        
        for(int i = 0 ; i < 4 ; i++) {
            direction = (direction + 3) % 4; //반시계 90도
            int next_r = now_r + dr[direction];
            int next_c = now_c + dc[direction];

            //인덱스 괜찮으면 청소 여부 보고
            if(next_r > 0 && next_r < N && next_c > 0 && next_c < M) {
                //청소 안되어있어서 청소 해준다면 boolean 하나 바꿔주기 (그래야지 청소되지 않은 빈칸이 없는 경우 실행 안하고 넘어가기 가능)
                if(map[next_r][next_c] == 0) {
                    DFS(next_r, next_c, direction);
                    any_clean = true; //청소해줬으니. 트루 만들고
                    break; //for문 안에서 위의 DFS 들어가고 나오면 그 방향으로 진격한 후니까 더이상 for문을 돌 필요 없어서 break; 해준다.
                }
            }
        }

        //for문 네번 돌고 나면, 주위 네칸중에 아무거나 청소 했는지 안헀는지 여부에 따라 청소안했다면
        if(any_clean == false) {
            int back_r = now_r + dr[(standard + 2) % 4];
            int back_c = now_c + dc[(standard + 2) % 4];

            //인덱스 괜찮으면
            if(back_r > 0 && back_r < N && back_c > 0 && back_c < M) {
                //바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                if(map[back_r][back_c] != 1) { //뒤로 후진가능하면
                    DFS(back_r, back_c, standard); //후진하고 방향은 그대로 청소 다시들어가기
                }
                else {
                    return;
                }
            }
        }

    }

}
