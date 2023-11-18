import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        //큐에 숫자들 넣고 숫자 빼고 12345 빼서 넣는거 계속 하다가
        //어느 순간 0보다 작아지면 큐에 넣고 그거 한꺼번에 뽑는게 암호

        for(int i = 1 ; i <= 10 ; i++) {
            int n = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                q.add(Integer.parseInt(st.nextToken()));
            }

            int m = 1;
            while(true) {
                int cur = q.poll();
                if(cur-m <= 0) {
                    q.add(0);
                    break;
                }

                q.add(cur-m);
                m++;
                if(m > 5) m = 1;
            }

            bw.write("#" + String.valueOf(i) + " ");
            for(int j = 0 ; j < 8 ; j++) {
                bw.write(String.valueOf(q.poll()) + " ");
            }
            bw.write("\n");
        }



        bw.flush();
        bw.close();
        br.close();
    }



}
