import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //answer, visited, recieve, send
    static boolean[] answer;
    static boolean[][][] visited;
    static int[] recieve;
    static int[] send;
    static int[] standard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        //초깃값 satndard {abc입력} 만들기(비교대상)
        StringTokenizer st = new StringTokenizer(br.readLine());

        standard = new int[3];
        standard[0] = Integer.parseInt(st.nextToken());
        standard[1] = Integer.parseInt(st.nextToken());
        standard[2] = Integer.parseInt(st.nextToken());

        answer = new boolean[201];
        visited = new boolean[201][201][201];
        recieve = new int[] {0, 0, 1, 1, 2, 2};
        send =    new int[] {1, 2, 0, 2, 0, 1};
        
        //BFS 만들기
        
        //BFS 돌고 나서 for문으로 answer 순회하며 트루이면 bw에 넣기
        BFS();

        for(int i = 0 ; i < answer.length ; i++){
            if(answer[i] == true)bw.write(String.valueOf(i)+" ");
        }
        bw.flush();
        bw.close();

    }
    public static void BFS() {
        //Queue<Node> 구현하고, q 에 add하고, 방문기록 남기고, 정답에 남기기
        Queue<Node> q = new LinkedList<Node>();
        q.add(new Node(0, 0, standard[2]));
        answer[standard[2]] = true;
        visited[0][0][standard[2]] = true;


        //각각의 상태에서 진행할수 있는것 (a의 물을 b로 .......c의 물을 b로 까지 총 6가지. dy dx처럼 static변수로 만들기)
        //while 큐 빌때까지, 노드 하나 뽑고 걔로 숫자 딴 다음에, for문 i로 돌리기
        while(!q.isEmpty()) {
            //q에서 하나 뽑고 방문기록
            Node first = q.poll();

            //for문은 dy dx처럼 숫자세기. 총 6가지니까 1~6까지. recieve, send (dy, dx)
            for(int i = 0 ; i < 6 ; i++) {
                int[] next = {first.a, first.b, first.c};
                //for 안에서 할 일이 물 옮기는것
                //물 옮기는게 next[]에서 next[recieve[i]] += next[send[i]], next[send[i]] = 0
                next[recieve[i]] += next[send[i]];
                next[send[i]] = 0;

                // 근데 next[recieve[i]] 이게 기준보다 크면(> standard[recieve[i]]) (물 넘칠때)
                //next[send[i]] =  next[recieve[i]] - standard[recieve[i]], next[recieve[i]] = standard[recieve[i]]
                if(next[recieve[i]] > standard[recieve[i]]){
                    next[send[i]] = next[recieve[i]] - standard[recieve[i]];
                    next[recieve[i]] = standard[recieve[i]];
                }

                //바꿔준 후에 비지티드 넥스트a,b,c 방문 안했다면
                if(visited[next[0]][next[1]][next[2]] == false) {
                    //노드로서 큐에 추가해주고, 방문여부 체크하고
                    q.add(new Node(next[0], next[1], next[2]));
                    visited[next[0]][next[1]][next[2]] = true;
                    //노드에서 A가 0이라면 답에 체크해주기 (답은 boolean형태로(answer[]), true 해주기, 나중에 순회하며 true인 얘들 답에 입력)
                    if(next[0] == 0){
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    //노드 abc 만들기. 생성자까지
    static class Node{
        int a;
        int b;
        int c;

        public Node(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}