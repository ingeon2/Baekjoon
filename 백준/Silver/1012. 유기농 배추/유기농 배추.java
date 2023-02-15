import java.io.*;
import java.util.*;

public class Main {
    //맵 만들기. 배추잇는데만 1로가자. 디폴트값이 0임.
    static int[][] map;
    //비지티드도 만들기.
    static boolean[][] visited;
    //dr,dc 만들기 상 하 좌 우 순서.
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    //여기는 BFS에서 index관련해서 사용
    static int M,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //맨 첫줄은 테스트케이스 몇개 갈길까임.
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0 ; t < T ; t++){
            //테스트케이스 하나마다 가로 세로 배추개수
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로 = 컬럼
            N = Integer.parseInt(st.nextToken()); //세로 = 로우
            int K = Integer.parseInt(st.nextToken()); //배추개수
            //배추의 개수만큼 위치좌표 이렇게 나옴.
            //그러면 테스트케이스마다 맵, 비지티드 크기 바꿔줘야함.
            map = new int[N][M];
            visited = new boolean[N][M];
            //배추 k개 위치 표시해주기(map 값을 1으로 변경)
            for(int k = 0 ; k < K ; k++){
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int column = Integer.parseInt(st1.nextToken());
                int row = Integer.parseInt(st1.nextToken());
                map[row][column] = 1;
            }
            int answer = 0;
            //여기까지 초기값 설정했음.

            //정답은 BFS가 몇번 돌아가는지로 체크하면 되겠네.
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    //BFS 돌릴 조건은 비지티드가 폴스(뭉탱이들 트루로 바뀌고 나오니) + 맵은 배추를 의미하는 1이어야 함.(배추 아닌곳은 할 필요 없으니)
                    if(visited[i][j] == false && map[i][j] == 1){
                        BFS(i, j);
                        answer++;
                    }
                }
            }

            bw.write(String.valueOf(answer) + "\n");
        }
        bw.flush();
        bw.close();

    }
    //BFS 할건데 입력값 점 두개. BFS돌고오면 그 점이랑 포함된 뭉텅이의 visited가 true로 만들어지도록.
    //리턴값은 보이드, 매개변수는 로우시작점, 컬럼시작점
    static void BFS(int r, int c){
        //큐int[] 만들기, 첫 시작점 방문체크, 큐에 넣어주기
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[] {r, c});
        //큐가 빌때까지
        while(!q.isEmpty()){
            //시작 int[]뽑아내고 그걸로 현재로우 현재컬럼 뽑아내기
            int[] start = q.poll();
            int now_r = start[0];
            int now_c = start[1];
            //for문 시작 0이상 4미만
            for(int i = 0 ; i < 4 ; i++){
                //미래로우 미래컬럼을 현재로우 + dr,현재컬럼 + dc랑 조합해서 만들기
                int new_r = now_r + dr[i];
                int new_c = now_c + dc[i];
                //만든 미래로우 미래컬럼이
                //인덱스 >= 0 + 로우인덱스 < 세로 + 컬럼인덱스 > 가로 + 방문안했고 + 맵의 값이 0이 아니라면
                if(new_r >= 0 && new_c >= 0 && new_r < N && new_c < M && visited[new_r][new_c] == false && map[new_r][new_c] != 0){
                    //큐에 추가 + 방문 체크
                    q.add(new int[] {new_r, new_c});
                    visited[new_r][new_c] = true;
                }

            }
            
        }
        //여기까지 BFS끝나면 한 뭉탱이들 다 폴스로 만들어진다.
    }


}