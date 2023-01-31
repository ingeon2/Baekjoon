import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //노드 어레이리스트, 방문기록, int[] 디스턴스
    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int[] distance;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력값 N 받고 0빼고 1~N 사용하도록 어레이리스트, 비지티드, 디스턴스 만들자.
        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++){
            A[i] = new ArrayList<Node>();
        }
        visited = new boolean[N+1];
        distance = new int[N+1];


        //입력값 대입은 for문 N까지 st 첫토큰은 A[1토큰]
        //2토큰a (-1이면 스탑) 3토큰b A[첫토큰].add(a, b) 각각 num, value
        for(int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tk_1 = Integer.parseInt(st.nextToken());
            
            while(st.hasMoreTokens()){ //-1나오면 제끼자
                int a = Integer.parseInt(st.nextToken());
                if(a == -1)break;
                int b = Integer.parseInt(st.nextToken());
                A[tk_1].add(new Node(a, b));
            }
        }


        //DFS한번 한 후 가장 먼 점 나오면 한번더 그걸로돌리고 거기서 가장먼 점까지의 거리 출력
        DFS(1);
        int max_length_point = 0;
        for(int i = 1 ; i <= N ; i++){
            if(distance[i] > distance[max_length_point]) max_length_point = i;
        }

        //초기화 후 한번 더 최대길이점으로 돌리기 그러면 sort하고 마지막친구 뽑아내면 최대길이임
        distance = new int[N+1];
        visited = new boolean[N+1];
        DFS(max_length_point);
        Arrays.sort(distance);

        bw.write(String.valueOf(distance[N]));
        bw.flush();
        bw.close();
        


    }
    static void DFS(int point){ //여기서 매개변수는 오직 시작점만 의미. distance 배열에 거리 기록하고, 가장 먼 점 찾을거야.
        //이후에 최대 점 구해서 다시 초기화(디스턴스 비지티드)해서 DFS 넣고, 또 최대점 구해서 뽑아내면 그게 답.
        //방문기록 남기고, 디스턴스 더하기
        visited[point] = true;
        //for으로 순회하면서 안들렸다면 할거 하고(distance[노드.넘] = distance[point] + 노드.밸류) + 다시 DFS(노드 넘)
        for(Node n : A[point]){
            if(visited[n.num] == false){
                visited[n.num] = true;
                distance[n.num] = distance[point] + n.value;
                DFS(n.num);
            }
        }
    }




    static class Node{ //노드 클래스 생성, 생성자 생성 : (번호, 값)
        int num;
        int value;

        public Node(int num, int value){
            this.num = num;
            this.value = value;
        }
    }
}