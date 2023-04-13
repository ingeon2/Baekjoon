import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Z(N, r, c);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    //재귀 구현 두가지
    //1. 끝이 명확히 있는가?
    //2. 모든 입력값이 끝으로 수렴하는가?
    //끝으로 가는 과정에서 내가 구현할것 구현하기.
    static void Z(int N, int r, int c) {
        if(N == 0) {
            return;
        }

        int temp = (int) Math.pow(2, N-1); //인덱스 위한 값
        int quad = temp * temp; //4등분 값

        if(r >= temp && c >= temp) {
            answer += 3 * quad;
            Z(N-1, r-temp, c-temp);
        }
        else if(r >= temp) {
            answer += 2 * quad;
            Z(N-1, r-temp, c);
        }
        else if(c >= temp) {
            answer += quad;
            Z(N-1, r, c-temp);
        }
        else {
            Z(N-1, r, c);
        }


    }



}