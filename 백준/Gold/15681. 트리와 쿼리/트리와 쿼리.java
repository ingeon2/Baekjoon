import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> [] A;
    static int N, R, Q;
    static int[]  subTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        R = Integer.parseInt(st1.nextToken()); //루트 노드 R인 트리구조 (문제에서 트리라고 주어짐)
        Q = Integer.parseInt(st1.nextToken());

        subTree = new int[N+1];
        A = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i = 1 ; i <= N-1 ; i++) { //트리이다 -> 간선 N-1개 / 역은 안된다.
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken()); //시작점
            int b = Integer.parseInt(st2.nextToken()); //끝점
            
            A[a].add(b);
            A[b].add(a);
        }

        //해야할것 -> 그래프에서 1과 연결된 노드들을 A[1] 에 넣었는데, 경우의 수는 둘중하나이다.
        //A[1]에 1의 부모노드가 있거나, 없거나
        //그렇다면, A[1]을 순회하며 걸린 현재노드가 부모노드가 아니라면 서브트리에 속한 노드이므로 숫자를 세주면 된다.
        //visited 없어도 되는 이유도, 트리 특성상 부모노드 -> 자식노드 로 진행이 되는데,
        //어차피 부모 노드만 방문했고 나머지 노드는 미방문 상태이기 때문.
        DFS(-1, R);

        for(int i = 0 ; i < Q ; i++) {
            int a = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(subTree[a]) + "\n");
        }

        bw.flush();
        bw.close();


    }

    static void DFS(int parents, int baby) {
        subTree[baby] = 1; //자기 자신도 서브트리 수에 포함되니까.

        for(int friends : A[baby]) {
            if(friends == parents) continue;
            DFS(baby, friends);
            subTree[baby] += subTree[friends]; //DFS를 빠져나오면서, 누적된다
        }
    }


}