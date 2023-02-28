import java.io.*;
import java.util.*;

public class Main {
    static int[] repre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //첫줄 N 도시의 수
        int N = Integer.parseInt(br.readLine());
        //둘째줄 M 여행할 도시의 수
        int M = Integer.parseInt(br.readLine());

        //초깃값 (대표노드 작은숫자)
        repre = new int[N+1];
        for(int i = 1; i <= N ; i++) {
            repre[i] = i;
        }
        //나머지 줄 N개의 줄에는 N개의 정수,
        //i번째 줄의 j번째 수는 i번 도시와 j번 도시의 연결 정보를 의미.
        for(int i = 1 ; i <= N ; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine()); //여기서 숫자 N개, 1이면 연결된 것이고 0이면 연결이 되지 않은 것
            for(int j = 1 ; j <= N ; j++) {
                if(Integer.parseInt(st1.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }
        //마지막줄 여행 계획
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        boolean answer = true;
        int start = Integer.parseInt(st2.nextToken());
        int b = find(start);
        //이거 주어진 입력값 입력받고, 유니온파인드로 대표 다 통합하면
        while(st2.hasMoreTokens()) {
            if(find(Integer.parseInt(st2.nextToken())) != b) {
                answer = false;
                break;
            }
        }
        
        //여행 계획의 첫번째 친구의 대표노드가 나머지들 대표노드이면 YES 아니면 NO (boolean 으로 하장)
        if(answer == true) bw.write("YES");
        else bw.write("NO");

        bw.flush();
        bw.close();

    }
    //대표노드 찾아서 리턴해주며 빠져나오며 거쳐온 친구들의 대표노드도 갱신해주는 find
    static int find(int a) {
        if(repre[a] == a) return a;
        else return repre[a] = find(repre[a]);
    }

    //대표노드를 찾아 서로 연결시켜주는 union
    static void union(int a, int b) {
        int small = Math.min(find(a), find(b));
        int large = Math.max(find(a), find(b));

        repre[large] = small;
    }

}