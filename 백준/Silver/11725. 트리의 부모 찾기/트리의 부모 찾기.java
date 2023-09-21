import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> [] A;
    static int[] answer;
    static boolean[] v;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1];
        answer = new int[N+1];
        v = new boolean[N+1];

        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 1 ; i <= N-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }
        v[1] = true;
        dfs(1);

        for(int i = 2 ; i <= N ; i++) {
            bw.write(String.valueOf(answer[i]) + "\n");
        }

        bw.flush();
        bw.close();


    }
    static void dfs(int from) {

        for(int to : A[from]) {
            if(!v[to]) {
                v[to] = true;
                answer[to] = from;
                dfs(to);
            }
        }
    }


}