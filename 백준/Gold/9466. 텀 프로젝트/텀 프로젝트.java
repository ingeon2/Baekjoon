import java.util.*;
import java.io.*;


public class Main {
    static int[] arr;
    static boolean[] v;
    static boolean[] f;
    static int cnt = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int c = 1 ; c <= T ; c++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            v = new boolean[N+1];
            f = new boolean[N+1];
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1 ; i <= N ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                if(i == arr[i]) {
                    f[i] = true;
                    cnt++;
                }
            }

            for(int i = 1 ; i <= N ; i++) {
                if(!f[i]) dfs(i);
            }

            bw.write(String.valueOf(N-cnt) + "\n");

        }
        bw.flush();
        bw.close();

    }

    static void dfs(int start) {

        if(v[start]) { //사이클에 포함된경우 (방문햇는데 또방문했어)
            cnt++;
            f[start] = true;
        }
        else {
            v[start] = true;
        }

        if(!f[arr[start]]) {
            dfs(arr[start]);
        }

        v[start] = false;
        f[start] = true; //사이클에 포함되지 않은경우
    }

    
}