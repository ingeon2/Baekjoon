import java.io.*;
import java.util.*;

public class Main {
    //물보내는쪽
    static int[] send = {0, 0, 1, 1, 2, 2};
    //물받는쪽
    static int[] receieve = {1, 2, 0, 2, 0, 1};
    //abc 기준값
    static int[] standard;
    //그 뭐냐 물 A가 0리터일때, C의 물의 양 기록해놓는곳
    static boolean[] answer;
    //방문여부
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //ABC 세 물통 존재. 첫 두개는 비어있고 세번째 물통 가득 차 있음.
        //다른 물통으로 붓기. (하나가 비거나, 다른 하나가 가득 찰 때까지 쏟음.)
        //위 과정에서 첫번째 물통이 비어있을때 세번쨰 물통에 담겨있는 물의 양을 구하자.
        
        //초깃값 대입후(불리언도 해줘)
        StringTokenizer st = new StringTokenizer(br.readLine());
        standard = new int[3];
        standard[0] = Integer.parseInt(st.nextToken());
        standard[1] = Integer.parseInt(st.nextToken());
        standard[2] = Integer.parseInt(st.nextToken());

        visited = new boolean[201][201][201];
        answer = new boolean[201];

        //BFS 거쳐서 answer 바뀌면
        BFS(standard[2]);
        //for문 돌면서 true인곳 체크하기 (자연스레 오름차순이 된다.)
        for(int i = 0 ; i <= 200 ; i++) {
            if(answer[i] == true) bw.write(String.valueOf(i) + " ");
        }
        bw.flush();
        bw.close();

    }
    //BFS for문 6보다 작게 가자 (한 경우당 6가지씩 생기거든.)
    static void BFS(int c) {
        //큐 만들고, 00c 넣어주고, 방문 체크하고, 처음엔 무조건 a가 0이니까 c값 answer에 체크해주기
        Queue<ABC> q = new LinkedList<>();
        q.add(new ABC(0, 0, c));
        answer[c] = true;
        visited[0][0][c] = true;
        //큐가 빌때까지
        while(!q.isEmpty()) {
            //abc까지 같이 뽑아준 후 int[] now 만들기
            ABC abc = q.poll();


            //for문으로 6보다 작게 받아주는 로직. 여기가 좀 헷갈릴듯.
            for(int i = 0 ; i < 6 ; i++) {
                int[] now = {abc.a, abc.b, abc.c};
                //보내주는 친구의 전부를 받는 친구에게 주기
                now[receieve[i]] += now[send[i]];
                now[send[i]] = 0;
                //근데 받은놈이 선을 넘어버렸다면 크기조정(여기가 헷갈리고 어려워!!!!)
                if(now[receieve[i]] > standard[receieve[i]]) {
                    now[send[i]] = now[receieve[i]] - standard[receieve[i]];
                    now[receieve[i]] = standard[receieve[i]];
                }
                
                //여기까지 하면 크기조정 끝났으니
                //방문 안했다면 방문해주고 q에 추가해주기, 혹시라도 a값이 0이면 값도 answer에 체크
                if(visited[now[0]][now[1]][now[2]] == false) {
                    visited[now[0]][now[1]][now[2]] = true;
                    q.add(new ABC(now[0], now[1], now[2]));
                    if(now[0] == 0) { //여기 핵심
                        answer[now[2]] = true;
                    }
                }

            }
        }
    }

    //abc 클래스 만들어주기. 각각 a b c 물의 양
    public static class ABC {
        int a;
        int b;
        int c;

        public ABC (int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}