import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> [] A;
    static int[] answer;
    static boolean[] v;
    static int delete;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1];
        answer = new int[N+1];
        v = new boolean[N+1];

        for(int i = 0 ; i < N ; i++) {
            A[i] = new ArrayList<>();
        }
        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {

            int a = Integer.parseInt(st.nextToken());
            if(a == -1) {
                root = i;
                continue;
            }

            A[i].add(a);
            A[a].add(i);
        }

        delete = Integer.parseInt(br.readLine());

        //노드를 지웠을 때, 리프 노드의 개수를 출력한다.
        v[root] = true;
        dfs(root);
        
        int a = answer[root];
        if(root == delete) a = 0;
        bw.write(String.valueOf(a));
        bw.flush();
        bw.close();






    }
    static void dfs(int from) {

        int baby = 0;
        for(int to : A[from]) {
            if(!v[to]) {
                if(to == delete) continue;
                v[to] = true;
                baby++;
                dfs(to);
                answer[from] += answer[to];
            }
        }
        if(baby == 0) answer[from] = 1;
    }


}