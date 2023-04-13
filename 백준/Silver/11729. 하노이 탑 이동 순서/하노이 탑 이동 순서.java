import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        //첫줄 옮긴횟수 출력 (An = 2An-1 + 1) -> An = 2^n -1;
        int a = (int) Math.pow(2, N) - 1;
        bw.write(String.valueOf(a) + "\n");

        if(N <= 20) hanoi(N, 1, 2, 3);

        bw.flush();
        bw.close();

    }

    //재귀 구현 두가지
    //1. 끝이 명확히 있는가?
    //2. 모든 입력값이 끝으로 수렴하는가?
    //끝으로 가는 과정에서 내가 구현할것 구현하기.

    static void hanoi(int heigth, int start, int mid, int end) throws IOException{
        if(heigth == 1) {
            bw.write(String.valueOf(start) + " " + String.valueOf(end) +"\n");
            return;
        }

        hanoi(heigth-1, start, end, mid);
        bw.write(String.valueOf(start) + " " + String.valueOf(end) +"\n");
        hanoi(heigth-1, mid, start, end);


    }


}