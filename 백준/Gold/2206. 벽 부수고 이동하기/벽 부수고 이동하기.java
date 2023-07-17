import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][][] visited; //세번째칸은 0, 1이고 각각 벽을 뚫기전인지 뚫은 후인지를 나타냄
    static int R, C;
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //벽을 한 개 까지 부수고 이동하여도 된다.
        //한 칸에서 이동할 수 있는 칸은 상하좌우로 인접한 칸이다.
        //맵이 주어졌을 때, 최단 경로를 구해 내는 프로그램을 작성하시오.

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());

        map = new int[R][C];

        for(int r = 0 ; r < R ; r++) {
            String[] arr = br.readLine().split("");
            for(int c = 0 ; c < C ; c++) {

                int tmp = Integer.parseInt(arr[c]);
                map[r][c] = tmp;

            }
        }

        visited = new boolean[R][C][2];

        //여기까지 초깃값
        int answer = BFS();
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();



    }
    static int BFS() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, false));

        while(!q.isEmpty()) {
            Node curNode = q.poll();
            int curR = curNode.r;
            int curC = curNode.c;
            int curCnt = curNode.cnt;
            boolean curBreak = curNode.isBreak;

            if(curR == R-1 && curC == C-1) return curNode.cnt;




            for(int i = 0 ; i < 4 ; i++) {
                int nextR = curR + dr[i];
                int nextC = curC + dc[i];
                
                if(!isValid(nextR, nextC)) continue;

                if(map[nextR][nextC] == 0) { //벽이 아니고
                    if(curBreak && !visited[nextR][nextC][1]) { //이전에 1회 뚫기 사용 한채로 해당 타일 지나지 않았다면
                        q.add(new Node(nextR, nextC, curCnt+1, true)); //1회뚫기 사용한채로 큐에 넣고 방문체크
                        visited[nextR][nextC][1] = true;
                    }
                    else if(!curBreak && !visited[nextR][nextC][0]){ //1회 뚫기 사용 안했고 사용 안한채로 해당 타일 지나지 않았다면
                        q.add(new Node(nextR, nextC, curCnt+1, false)); //1회뚫기 사용 안한채로 큐에 넣고 방문체크
                        visited[nextR][nextC][0] = true;
                    }

                }
                else if(map[nextR][nextC] == 1){ //벽에 마주쳤다면
                    if(!curBreak && !visited[nextR][nextC][1]) { //1회 뚫기 사용안했고 해당 타일을 방문하지 않았을때만
                        q.add(new Node(nextR, nextC, curCnt+1, true));
                        //여기부터는 1회뚫기 사용했기때문에 로직상, 앞으로 계속해서 사용한채로 큐에 추가될 예정
                        //한번 true로 바뀌면, 위의 if(!curBreak) 로직은 다시 작동할 수 없음. (다시는 벽 뚫을 수 없음)
                        visited[nextR][nextC][1] = true;
                    }
                }

            }
        }

        return -1; // 끝까지안나오면 못가는거고
    }

    static class Node {
        int r, c, cnt;
        boolean isBreak;

        public Node(int r, int c, int cnt, boolean isBreak) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.isBreak = isBreak;
        }
    }
    
    static boolean isValid(int r, int c) {
        if(r >= 0 && r < R && c >= 0 && c < C) return true;
        return false;
    }

}