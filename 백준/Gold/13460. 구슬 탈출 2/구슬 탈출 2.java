import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // char[][] board, visited[][][][](R, B위치), int r_hole,c_hole, boolean R_hole, B_hole
    // dx, dy 상하좌우 순서
    static char[][] board;
    static boolean[][][][] visited;
    static int r_hole, c_hole;
    static balls start_R, start_B;
    static int[] dx, dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //초깃값 설정 visited, board, NM행렬
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        visited = new boolean[N][M][N][M];
        board = new char[N][M];
        dx = new int[] {-1, 1, 0, 0}; //상하좌우 순서
        dy = new int[] {0, 0, -1, 1};


        //입력값 넣기. 넣으면서, R, B시작점과 int r_hole,c_hole 찾아놓기. 나중에 balls 클래스에 넣을거임

        for(int i = 0 ; i < N ; i++){
            String S = br.readLine();
            for(int j = 0 ; j < M ; j++){
                board[i][j] = S.charAt(j);

                if(S.charAt(j) == 'O'){
                    r_hole = i;
                    c_hole = j;
                }
                if(S.charAt(j) == 'R'){
                    start_R = new balls(i, j, 0, 0, 0);
                    board[i][j] = '.';
                }
                if(S.charAt(j) == 'B'){
                    start_B = new balls(0, 0, i, j, 0);
                    board[i][j] = '.';
                }
            }
        }

        //BFS
        bw.write(String.valueOf(BFS()));
        bw.flush();
        bw.close();

    }
    // balls 큐 로 BFS
    public static int BFS(){
        //큐 생성,
        Queue<balls> q = new LinkedList<balls>();
        // 추가(위에서 기록한 R, B 시작점, 깊이 0)
        q.add(new balls(start_R.R_r, start_R.R_c, start_B.B_r, start_B.B_c, 0));
        //방문기록
        visited[start_R.R_r][start_R.R_c][start_B.B_r][start_B.B_c] = true;



        //큐가 빌때까지
        while(!q.isEmpty()){
            //큐에서 하나 뽑고, 현재 위치 기록
            balls a = q.poll();
            int nowRr  = a.R_r; //지금의 레드 로우
            int nowRc = a.R_c;
            int nowBr= a.B_r;
            int nowBc = a.B_c;
            int nowDepth = a.depth;

            //큐에서 뽑은거 마지막변수 깊이가 10보다 크면 -1 리턴
            if(nowDepth >= 10)return -1;

            //for문 dx dy 돌기 (할거 하기)
            for(int i = 0 ; i < 4 ; i++){

                //큐에서 기록한친구들 새로운 변수들로 기록해놓기
                int nextRr = nowRr; //다음의 레드 로우
                int nextRc = nowRc;
                int nextBr = nowBr;
                int nextBc = nowBc;
                int nextDepth = nowDepth + 1;

                boolean Is_R_hole = false;
                boolean Is_B_hole = false;

                //R : while문으로 # 만나기전까지 돌기 (새로운 변수들 += dx[i], +=dy[i] 로 갱신해주기)
                //while 안에서 hole 만나면 boolean 기록후 while 탈출
                while(board[nextRr + dx[i]][nextRc + dy[i]] != '#'){
                    nextRr += dx[i];
                    nextRc += dy[i];

                    if(nextRr == r_hole && nextRc == c_hole) {
                        Is_R_hole = true;
                        break;
                    }
                }

                //위의 두줄 B에서도 해주기
                while(board[nextBr + dx[i]][nextBc + dy[i]] != '#') {
                    nextBr += dx[i];
                    nextBc += dy[i];

                    // 이동 중 구멍을 만날 경우
                    if(nextBr == r_hole && nextBc == c_hole) {
                        Is_B_hole = true;
                        break;
                    }
                }


                //근데 (B_hole boolean이 true이면) for문에서 큐 다음타자로 넘어갈거니 continue; (동시 빠져도 실패)
                if(Is_B_hole == true)continue;

                //그리고 (에이홀 투트루이고 비홀 폴스이면) R만 빠졌다는 소리니까, 만족했다는것, 즉 리턴 depth
                if(Is_R_hole == true && Is_B_hole == false)return nextDepth;

                //for문 하나 하고나서 R과 B의 위치가 같아진다면..?
                if(nextRr == nextBr && nextRc == nextBc){
                    // if문 네개로
                    //i가 0, 1, 2, 3 인지에 따라 설정 (0, 즉, 상으로 간거면, 현재 위치에서 행이 더 큰놈(더 아래)이 뉴 -= dx[i]이다)

                    if(i == 0){ //상 하 좌 우 순서
                        if(nowRr > nowBr)nextRr -= dx[i]; //레드가 더 아래 행
                        else nextBr -= dx[i]; //블루가 더 아래 행
                    }
                    else if(i == 1){
                        if(nowRr < nowBr)nextRr -= dx[i]; //블루가 더 아래 행
                        else nextBr -= dx[i];
                    }
                    else if(i == 2){
                        if(nowRc > nowBc)nextRc -= dy[i]; //더 오른쪽에잇던놈 nowRc
                        else nextBc -= dy[i];
                    }
                    else{
                        if(nowRc < nowBc)nextRc -= dy[i]; //더 왼쪽에잇던놈 nowRc
                        else nextBc -= dy[i];
                    }
                    // 여기까지 하면 한번 기울였을때 위치가 확정됨.
                }

                //확청된 위치로 방문 안했다면, 큐에 추가(depth+1)하고 방문기록 남기기
                if(visited[nextRr][nextRc][nextBr][nextBc] == false){
                    q.add(new balls(nextRr, nextRc, nextBr, nextBc, nextDepth));
                    visited[nextRr][nextRc][nextBr][nextBc] = true;
                }
            }
        }
        //큐 빌때까지 안나오면 -1 리턴이지
        return -1;
    }



    //구슬으로 클래스만들고 생성자 5개. R로우 컬럼 B 로우 컬럼 몇번움직엿는지 depth. R볼과 B 볼 한꺼번에 움직일 예정.
    //depth 도 기록해야 return 값 뽑을예정.
    public static class balls{
        int R_r; //레드 로우
        int R_c; //레드 컬럼
        int B_r; //블루 로우
        int B_c; //블루 컬럼
        int depth;

        public balls(int R_r, int R_c, int B_r, int B_c, int depth){
            this.R_r = R_r;
            this.R_c = R_c;
            this.B_r = B_r;
            this.B_c = B_c;
            this.depth = depth;
        }
    }

}