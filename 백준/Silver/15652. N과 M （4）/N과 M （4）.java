import java.io.*;
import java.util.*;

public class Main {
    static int[] answer;
    static BufferedWriter bw;
    static boolean[] visited;
    public static void main(String[] args) throws IOException , NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        answer = new int[9];
        visited = new boolean[9];

        backtracking(N, M, 1, 0);

        bw.flush();
        bw.close();


    }
    static void backtracking(int N, int M, int start, int depth) throws IOException{
        if(depth == M) {
            for(int i = 0 ; i < M ; i++) {
                bw.write(String.valueOf(answer[i]));
                if(i != M-1)bw.write(" ");
            }
            bw.write("\n");
            return;
        }

        for(int i = start ; i <= N ; i++) {
            //if(visited[i] == true) continue;

            //visited[i] = true;
            answer[depth] = i;
            backtracking(N, M, i, depth+1);
            //visited[i] = false;
        }
    }

}