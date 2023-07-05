import java.io.*;
import java.util.*;


public class Main {
    //호선 최대 10개
    //역 최대 100개
    static ArrayList<Integer>[] A = new ArrayList[101]; //같은역, 다른호선들  (A[1] = {2, 3} 1번 역이 2호선 3호선 걸침)
    static ArrayList<Integer>[] B = new ArrayList[11]; //같은호선, 다른역들 (B[3] = {4, 5} 3호선은 4번역 5번역 가짐)
    static HashMap<Integer, Integer> map = new HashMap<>(); //역 번호 2^(32-1) 까지니까, 따로 줄여줘야함. 해당 내용을 아래의 idx로 수행

    static boolean[][] visited = new boolean[11][101]; //2차원배열 이유는, 같은 역이더래도 해당 역의 호선에 따라 여러번 세줄 수 있음.


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0 ; i < 11 ; i++) {
            B[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i <= 100 ; i++) {
            A[i] = new ArrayList<Integer>();
        }



        int N = Integer.parseInt(br.readLine());
        int idx = 1;

        for(int i = 1 ; i <= N ; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken()); //역의 수

            for(int j = 1 ; j <= K ;j++) {
                int num = Integer.parseInt(st.nextToken());

                if(!map.containsKey(num)) {
                    map.put(num, idx);
                    A[idx].add(i);
                    B[i].add(idx);
                    idx++;
                }
                else {
                    A[map.get(num)].add(i);
                    B[i].add(map.get(num));
                }
            }

        }

        int end =Integer.parseInt(br.readLine());
        //여기까지 초깃값


        bw.write(String.valueOf(BFS(end)));
        bw.flush();
        bw.close();

    }

    static int BFS(int end) {
        int answer = -1;

        PriorityQueue<Station> q = new PriorityQueue<>();

        for(int i = 0 ; i < A[map.get(0)].size() ; i++) {
            q.add(new Station(0, map.get(0), A[map.get(0)].get(i))); //0번역 호선들 기록해서 추가해줌
        }

        while(!q.isEmpty()) {
            Station curStation = q.poll();

            if(curStation.num == map.get(end)) {
                answer = curStation.cnt;
                return answer;
            }

            int curCnt = curStation.cnt;
            int curNum = curStation.num;
            int curLine = curStation.line;

            for(int i = 0 ; i < B[curLine].size() ; i++) { //같은호선의 다른 역들 환승없이 큐에 넣기
                int nextNum = B[curLine].get(i);
                if(!visited[curLine][nextNum]) {
                    visited[curLine][nextNum] = true;
                    q.add(new Station(curCnt, nextNum, curLine));
                }
            }

            for(int i = 0 ; i < A[curNum].size() ; i++) { //같은역의 다른 호선들 환승있이 큐에 넣기
                int nextLine = A[curNum].get(i);
                if(!visited[nextLine][curNum]) {
                    visited[nextLine][curNum] = true;
                    q.add(new Station(curCnt+1, curNum, nextLine));
                }
            }


        }

        return answer;
    }




    static class Station implements Comparable<Station> {
        int cnt; //환승
        int num; //역번호
        int line; //호선

        public Station (int cnt, int num, int line) {
            this.cnt = cnt;
            this.num = num;
            this.line = line;
        }

        public int compareTo(Station e) {
            if(this.cnt > e.cnt) return 1;
            else return -1;
        }
    }

}