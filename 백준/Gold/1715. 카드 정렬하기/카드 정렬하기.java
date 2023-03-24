import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }
        long answer = 0;
        while(q.size() != 1) {
            int a = q.poll() + q.poll();
            q.add(a);
            answer += a;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

}