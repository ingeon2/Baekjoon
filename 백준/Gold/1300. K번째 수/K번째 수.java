import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[][] D;
    static int N,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //A 배열은 1*1 1*2 1*3 1*4.....1*N
        //          ....
        //        N*1 N*2 N*3 N*4.....N*N 배열. (long 넣기) 배열의 index 곱이 크기임.
        // K는  K <= min(10^9, N^2)을 만족하는 자연수
        //A 배열을 크기 N*N 1차원배열 B로 만든 후 오름차순 정렬 후 B[K] 구하기
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        long s = 1;
        long e = k;
        while(s<=e){
            long m = (s+e)/2;
            if(num_of_m_down(m) >= k) e = m-1;
            else s = m+1;
        }
        bw.write(String.valueOf(s));
        bw.flush();
        bw.close();


    }

    static long num_of_m_down(long m){
        long answer = 0;
        for(int i = 1 ; i <= N ; i++){
            answer += Math.min(m/i, N);
        }
        return answer;
    }
} //https://st-lab.tistory.com/281