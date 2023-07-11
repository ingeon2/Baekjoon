import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> [] A, B;
    //A는 어떤 역이 속한 호선 (A[1] = {2, 3, 4} == 1번역은 2, 3, 4 호선 지남)
    //B는 호선에 속한 역 (B[2] = {5, 6} == 2호선의 역이 5번, 6번역)

    static int N,L;

    static boolean[] visited;
    static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //최소 환승 경로를 구하는 프로그램을 작성하시오. 실제 경로를 구할 필요는 없고, 환승 회수만을 구하면 된다.

        //첫째 줄에 역의 개수 N(1≤N≤100,000), 노선의 개수 L(1≤L≤100,000)이 주어진다.
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        L = Integer.parseInt(st1.nextToken());
        A = new ArrayList[N+1];
        B = new ArrayList[L+1];
        visited = new boolean[N+ L + 1]; //1~N 까지는 역, N+1 ~ N+L 까지는 호선

        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= L ; i++) {
            B[i] = new ArrayList<>();
        }


        //다음 L개의 줄에는 각 노선이 지나는 역이 순서대로 주어지며 각 줄의 마지막에는 -1이 주어진다.
        for(int i = 1 ; i <= L ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            
            while(true) {
                int num = Integer.parseInt(st2.nextToken());
                if(num == -1) break;
                
                B[i].add(num); //호선에 속한 역
                A[num].add(i); //역이 지나는 호선
            }

        }

        //마지막 줄에는 출발지 역의 번호와 목적지 역의 번호가 주어진다.
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st3.nextToken());
        end = Integer.parseInt(st3.nextToken());

        int answer = BFS(start);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

        //역 번호는 1부터 N까지의 정수로 표현된다. 각 노선의 길이의 합은 1,000,000을 넘지 않는다.
    }

    static int BFS(int start) {
        PriorityQueue<Station> q = new PriorityQueue<>();

        visited[start] = true; //출발역

        for(int line : A[start]) {
            q.add(new Station(start, line, 0));
            visited[N+line] = true; //출발역의 호선들
        }

        while(!q.isEmpty()) {
            Station curStation = q.poll();
            int curNum = curStation.num;
            int curLine = curStation.line;
            int curCnt = curStation.cnt;

            if(curNum == end) return curCnt;

            //뽑은 역의 호선들
            for(int nextLine : A[curNum]) {
                if(!visited[N+nextLine]) {
                    visited[N+nextLine] = true;
                    q.add(new Station(curNum, nextLine, curCnt+1));
                }
            }

            //현재 호선의 다른역들
            for(int nextNum : B[curLine]) {
                if(!visited[nextNum]) {
                    visited[nextNum] = true;
                    q.add(new Station(nextNum, curLine,  curCnt));
                }
            }
        }

        //큐 빌때까지 못찾으면 아예 환승 불가.
        return -1;
    }
    
    
    
    
    
    //환승기준 우선순위 큐 만들 station 클래스
    static class Station implements Comparable<Station>{
        int num, line, cnt;
        
        public Station (int num, int line, int cnt) {
            this.num = num;
            this.line = line;
            this.cnt = cnt;
        }
        
        public int compareTo(Station s) {
            if(this.cnt > s.cnt) return 1;
            return -1;
        }
    }


}