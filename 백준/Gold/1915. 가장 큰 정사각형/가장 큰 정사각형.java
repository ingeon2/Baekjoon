import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] D = new int[R][C];
        int answer = 0;

        for(int r = 0 ; r < R ; r++) {
            String s = br.readLine();
            for(int c = 0 ; c < C ; c++) {
                D[r][c] = Integer.parseInt(s.substring(c, c+1));
                if(D[r][c] == 1) answer = 1;
                //바로 위의 로직은, 직사각형이 1 일때 예외를 위해 해준다.
            }
        }


        for(int r = 1 ; r < R ; r++) {
            for(int c = 1 ; c < C ; c++) {
                if(D[r][c] == 0) continue; //현재 점이 0이라면, 해당 점으로는 정사각형을 만들 수 없다.
                D[r][c] = Math.min(D[r-1][c-1], Math.min(D[r-1][c], D[r][c-1])) + 1;
                answer = Math.max(answer, D[r][c]);
            }
        }

        bw.write(String.valueOf(answer * answer));
        bw.flush();
        bw.close();


    }

}