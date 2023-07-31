import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static int n,m;
    static BufferedWriter bw;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //nPm 백트래킹 문제
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());

        arr = new int[n];
        visited = new boolean[n];

        answer = new int[m];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);

        backTracking(0);
        bw.flush();
        bw.close();

    }

    static void backTracking(int depth) throws IOException{

        if(depth == m) {
            for(int i = 0 ; i < m ; i++) {
                bw.write(String.valueOf(answer[i]));
                if(i != m-1) bw.write(" ");
            }
            bw.write("\n");
            return;
        }

        int before = 0;
        for(int i = 0 ; i < n ; i++) {
            if(visited[i]) continue;


            if(before != arr[i]) {
                visited[i] = true;
                before = arr[i];
                answer[depth] = arr[i];
                backTracking(depth+1);
                visited[i] = false;
            }


        }
    }

}