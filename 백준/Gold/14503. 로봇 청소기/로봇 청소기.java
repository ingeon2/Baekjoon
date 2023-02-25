import java.io.*;
import java.util.*;

public class Main {
    //매서드에서 사용할 방문여부
    static boolean[][] visited;
    //map 1은벽 0은청소할곳
    static int[][] map;
    //상 우 하 좌 dx dy, 여기는 행열. 맨 왼쪽 위 00 시작. (북동남서)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //이문제는 (0, 0)부터 (N-1, M-1) 까지임 가로N 세로M
        //첫줄은 N과 M 크기
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        //둘째줄은 두 점 위치와 방향 (숫자 세개)
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st2.nextToken());
        int y = Integer.parseInt(st2.nextToken());
        int direction = Integer.parseInt(st2.nextToken());


        //static 변수들 초깃값 설정. (청소, 맵)
        visited = new boolean[N][M];
        map = new int[N][M];

        //맵 먼저 하고
        //청소 할때는 맵이 1이면 true로 고쳐놓기
        for(int i = 0 ; i < N ; i++){ //행
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){ //열
                int a = Integer.parseInt(st3.nextToken());
                map[i][j] = a;
                if(a == 1)visited[i][j] = true; //1 이면 트루로 해놓기 (map에서 유효한 index상의 편의를 보기 위해)
            }
        }


        //초깃값 설정 후 DFS 이전의 true 개수 저장해놓기
        int before = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(visited[i][j]) before++;
            }
        }
        //설정 후 DFS
        DFS(x, y, direction);
        //DFS 이후의 true 개수 기록 후
        int after = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(visited[i][j]) after++;
            }
        }
        //두개 뺀 내용을 출력.
        bw.write(String.valueOf(after - before));
        bw.flush();
        bw.close();

    }
    //void 재귀이동 시작점, 방향
    static void DFS(int x, int y, int direction){
        //시작점 청소
        visited[x][y] = true;

        //주변네칸 다 청소 되어있거나 벽일때
        //[][] 배열의 index 생각 안해도 되는게 이거 테두리는 다 1로되어있음.
        if( visited[x + dx[0]][y + dy[0]]
                && visited[x + dx[1]][y + dy[1]]
                && visited[x + dx[2]][y + dy[2]]
                && visited[x + dx[3]][y + dy[3]] ){
            //내 방향쪽 후진가능이면 (내 방향 뒤쪽 0이면), direction + 2
            // 1 → 3, 2 → 4, 3 → 1 즉 (디렉션 + 2) mod4
            if(map[x + dx[(direction + 2) % 4]][y + dy[(direction + 2) % 4]] == 0){
                //한칸 후진(현재 디렉션과 반대방향) 후 재귀
                DFS(x + dx[(direction + 2) % 4], y + dy[(direction + 2) % 4], direction);
            }
            else{ //후진불가 1이면
                return;
            }
        }
        else{ //주변 4칸중 청소 안된칸 있을때
            
            //한번 돌고 (방향 맞아도 무조건 돌아)
            direction = (direction + 3) % 4;
            
            //와일문으로,       방향대로 전진가능하고, 전진했을때 청소 안되있는곳이          나올때까지
            while( map[x + dx[direction]][y + dy[direction]] != 0 || visited[x + dx[direction]][y + dy[direction]] != false){
                //방향 반시계90 바꿔줘라
                direction = (direction + 3) % 4;
            }
            //전진가능한 방향이 나오면 그 방향으로 전진
            DFS(x + dx[direction], y + dy[direction], direction);
        }
    }

}