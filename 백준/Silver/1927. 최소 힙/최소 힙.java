import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0 ; i < N ; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a == 0) {
                if(q.isEmpty()) {
                    bw.write(String.valueOf(0) + "\n");
                }
                else {
                    bw.write(String.valueOf(q.poll()) + "\n");
                }
            }
            else {
                q.add(a);
            }
        }

        bw.flush();
        bw.close();
    }

}