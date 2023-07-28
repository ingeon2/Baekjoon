import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] map;
    static int answer = 0;
    static int sharkR, sharkC;
    
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        R = N;
        C = N;
        map = new int[R][C];

        for(int r = 0 ; r < R ; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < C ; c++) {
                int a = Integer.parseInt(st.nextToken());
                map[r][c] = a;
                if(a == 9) {
                    sharkR = r;
                    sharkC = c;
                    map[r][c] = 0; //9로 남겨두면 이동 할수잇는데 못해버리는 수가 잇어서 위치만 기록 후 0으로 만들기
                }
            }
        }


        bw.write(String.valueOf(eatFish(new Shark(2, 0, sharkR, sharkC))));
        bw.flush();
        bw.close();

    }
    static int eatFish(Shark s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int r = 0 ; r < R ; r++) {
            for(int c = 0 ; c < C ; c++) {
                if(map[r][c] == 0) continue; //물고기업는곳 빼주고


                if(s.ce(r, c)) { //지금의 상어가 r, c 위치의 물고기를 먹을 수 잇다면 시간 구하고 0보다 크다면 큐에 넣기
                    int t = moveTime(s, r, c);
                    if(t > 0) pq.add(new Node(r, c, t));
                }

                
            }
        }
        
        if(pq.size() != 0) {
            Node nextNode = pq.poll(); //우선순위대로 하나뽑아서
            answer += nextNode.time; //걸린 시간 더해주고
            s.e(nextNode.r, nextNode.c); //해당 위치의 물고기 먹어주며 (크기 먹은 먹이 수 자동 업데이트 된다)
            eatFish(new Shark(s.big, s.eat, nextNode.r, nextNode.c)); //다른 위치로 물고기 먹으러 출발
        }

        //근데 이제 큐 사이즈 0이라면 먹을게 하나도 없으니 끝내기
        return answer;
        
    }
    
    
    
    
    
    static int moveTime(Shark s, int r, int c) { //상어 s 의 r, c까지 이동시간 구하는 매서드. 0 아니면 이동 가능한것
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s.r, s.c, 0));
        boolean[][] visited = new boolean[R][C];
        visited[s.r][s.c] = true;
        
        while(!q.isEmpty()) {
            Node cN = q.poll();
            int curR = cN.r;
            int curC = cN.c;
            int curT = cN.time;
            
            if(curR == r && curC == c) return curT;
            
            for(int i = 0 ; i < 4 ; i++) {
                int nR = curR + dr[i];
                int nC = curC + dc[i];
                
                if(nR >= 0 && nR < R && nC >= 0 && nC < C && //index 맞고 이동할 수 있으며 방문 안햇다면
                s.cm(nR, nC) && !visited[nR][nC]) {
                    q.add(new Node(nR, nC, curT+1));
                    visited[nR][nC] = true;
                }
            }
        }
        return 0;
    }
    
    
    static class Node implements Comparable<Node> { //이동시 사용할 클래스
        int r, c, time;

        public Node (int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }

        public int compareTo(Node n) { //걸린 시간, 가장 위, 가장 왼쪽 순
            if(this.time == n.time) {
                if(this.r == n.r) {
                    return this.c - n.c;
                }
                else {
                    return this.r - n.r;
                }
            }
            else {
                return this.time - n.time;
            }
        }
    }




    static class Shark { // 아가상어 클래스
        int big, eat, r, c;
        
        public Shark(int big, int eat, int r, int c) {
            this.big = big;
            this.eat = eat;
            this.r = r;
            this.c = c;
        }
        
        public boolean ce (int r, int c) { //상어가 r c 위치 고기 먹을 수 잇는지
            if(this.big > map[r][c]) return true;
            return false;
        }

        public boolean cm (int r, int c) { //상어가 r c 위치 이동 가능한지
            if(this.big >= map[r][c]) return true;
            return false;
        }
        
        public void e (int r, int c) { //r c 위치 물고기 먹어버리기~
            map[r][c] = 0;
            this.eat++;

            //크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3 + 다시 먹이 0됨
            if(this.eat == this.big) {
                this.big++;
                this.eat = 0;
            }
        }
        
    }

}