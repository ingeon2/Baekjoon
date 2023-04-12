import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        bw.write(String.valueOf(self(A, B, C)));
        bw.flush();
        bw.close();

    }

    // 1. 어떤입력에서 종료? - 지수 1일때
    // 2. 모든 경우가 지수 1로 수렴하는가?
    static long self(long A, long B, long C) {
        // 지수 1일때 리턴
        if(B == 1) return A%C;

        //여기는 이제 재귀로 지수 1만들어주는 로직, B를 절반씩 줄여 1로 만들 예정
        long temp = self(A, B/2, C);

        //각각 B가 짝수일때 홀수일때 달라
        if(B%2 == 1) {
            return (temp * temp % C) * A % C;
        }

        return (temp * temp) % C;
    }


}