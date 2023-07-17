import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st1.nextToken());
        int W = Integer.parseInt(st1.nextToken()); //W 1이면 답 0

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        Stack<Integer> s = new Stack<>();

        int start = Integer.parseInt(st2.nextToken());
        int answer = 0;

        while(st2.hasMoreTokens()) {
            int tmp = Integer.parseInt(st2.nextToken());
            if(tmp >= start) {
                while(!s.isEmpty()) {
                    answer += start - s.pop();
                }
                start = tmp;
            }
            else {
                s.add(tmp);
            }
        }

        if(!s.isEmpty() && s.size() > 1) {
            int end = s.pop();

            while(true) {
                if(s.isEmpty()) break;
                int cur = s.pop();
                if(cur > end) {
                    end = cur;
                }
                else {
                    answer += end - cur;
                }

            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }


}