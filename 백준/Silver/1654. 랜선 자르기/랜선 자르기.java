import java.io.*;
import java.util.*;

public class Main {
    static long[] lines; //랜선의 길이는 2^31-1보다 작거나 같은 자연수 = 대충 33*33*10^10, int범위초과
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st1.nextToken()); //전선 수
        int N = Integer.parseInt(st1.nextToken()); //원하는 전선 개수
        //K는 1이상 10,000이하의 정수이고, N은 1이상 1,000,000이하의 정수

        lines = new long[K];
        long max = Long.MIN_VALUE;

        for(int i = 0 ; i < K ; i++) {
            long line = Long.parseLong(br.readLine());
            lines[i] = line;
            max = Math.max(max, line);
        }

        long s = 0;
        long e = max+1;

        while(s < e) {
            long m = (s+e)/2;

            if(N > howMany(m)) e = m;
            else s = m+1;
        }

        bw.write(String.valueOf(s-1));
        bw.flush();
        bw.close();


    }

    static long howMany(long cut) {
        long answer = 0;
        for(long line :lines) {
            answer += line/cut;
        }
        return answer;
    }


}