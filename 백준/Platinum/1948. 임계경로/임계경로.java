import java.io.*;
import java.util.*;

public class Main {
    //마지막입력줄에 넣어줄것 (시작도시, 도착도시)
    static int start, end;

    //출발부터 도착 시간
    static int[] time;

    //A는 time 채울 용도 B는 돌아오며 도로 수 체크할 용도 (채우는 방법 다르다!)
    static ArrayList<Node>[] A,B;

    //time 채울 용도의 위상정렬 D
    static int[] D;

    //도로 중복되게 안셀 용도
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //time(도시개수) 채우고, 채워진 time 에서 도착도시 index의 값이 몇시간 후에 만나는지의 값임 (첫째줄 출력)
        //위의 로직 후, 도착 도시부터 출발 도시까지 실행하며 채워진 도착도시의time = 이전도시의time + 해당 경로의 time 이라면 이전도시를 큐에 넣고 도로의 수 ++


        //첫줄도시개수 n개
        int n = Integer.parseInt(br.readLine());
        //둘째줄 도로개수 m개
        int m = Integer.parseInt(br.readLine());

        //초깃값들 설정
        time = new int[n+1];
        D = new int[n+1];
        visited = new boolean[n+1];
        A = new ArrayList[n+1];
        B = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++) {
            A[i] = new ArrayList<Node>();
            B[i] = new ArrayList<Node>();
        }

        //m개 줄 도로 정보
        for(int i = 1 ; i <= m ; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int c = Integer.parseInt(st1.nextToken());


            A[a].add(new Node(b, c));
            D[b]++;
            B[b].add(new Node(a, c));
        }

        //마지막줄 시작, 끝점
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st2.nextToken());
        end = Integer.parseInt(st2.nextToken());

        //위상정렬 하면 time 끝점에 시간 기록
        topological_sort(start);
        bw.write(String.valueOf(time[end]) + "\n");

        //이후에 도로 수 세는 로직
        bw.write(String.valueOf(road(end)));

        bw.flush();
        bw.close();

    }

    //time 채우는 위상정렬 void
    static void topological_sort(int start) {
        //큐 생성하고 시작점에 넣고
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        //빌때까지
        while(!q.isEmpty()) {
            //하나 뽑고 그친구 어레이리스트 A 돌면서
            int a = q.poll();
            for(Node b : A[a]) {
                //a에서 b로 가는 로직
                //a 에서 b로 가는 시간에다가 a 까지의시간 더한게 현재 b 까지의 시간보다 크다면 갱신 (가장 오래걸리는 시간 찾으니깐)
                if(b.hour + time[a] > time[b.num]) {
                    time[b.num] = b.hour + time[a];
                }

                //D -- 해서 0이면 큐에 추가.
                D[b.num]--;
                if(D[b.num] == 0) {
                    q.add(b.num);
                }
            }
        }
    }
    
    
    //다시 거꾸로 가며 도로의 수 구하는 void
    static int road(int start) {
        int answer = 0;
        
        //큐생성, 시작지점넣기
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        
        //큐빌때ㅏㄲ지
        while(!q.isEmpty()) {
            //하나 뽑고
            int a = q.poll();

            //시작지점부터 B 돌며 이전 도시의 시간 + 이전도시부터 지금도시까지 걸리는시간 = 현재도시까지의 시간이라면 answer++; , 큐에 넣어주기
            for(Node b : B[a]) {
                if(time[a] == b.hour + time[b.num]) {
                    answer++;
                    if(visited[b.num] == false) {
                        q.add(b.num);
                        visited[b.num] = true;
                    }
                }
            }
        }
        
        return answer;
    }





    static class Node {
        int num;
        int hour;

        public Node(int num, int hour) {
            this.num = num;
            this.hour = hour;
        }
    }

}