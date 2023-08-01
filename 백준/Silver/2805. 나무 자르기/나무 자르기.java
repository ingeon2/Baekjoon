import java.io.*;
import java.util.*;

public class Main {
    static int[] trees;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken()); //나무수
        int M = Integer.parseInt(st1.nextToken()); //가져갈 최소 길이

        trees = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        long max = Long.MIN_VALUE;

        for(int i = 0 ; i < N ; i++) {
            int h = Integer.parseInt(st2.nextToken());
            trees[i] = h;
            max = Math.max(max, h);
        }

        long s = 0;
        long e = max;

        while(s < e) {
            long m = (s+e)/2;

            if(M > getTree(m)) e = m;
            else s = m+1;
        }

        bw.write(String.valueOf(s-1));
        bw.flush();
        bw.close();


    }
    static long getTree(long cut) {
        long answer = 0;
        for(int i = 0 ; i < N ; i++) {
            if(trees[i] > cut) answer += trees[i] - cut;
        }
        return answer;
    }

}