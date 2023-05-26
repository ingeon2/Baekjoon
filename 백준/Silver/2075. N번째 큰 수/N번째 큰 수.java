import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                q.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0 ; i < N-1 ; i++) {
            q.poll();
        }

        bw.write(String.valueOf(q.poll()));
        bw.flush();
        bw.close();

    }

}