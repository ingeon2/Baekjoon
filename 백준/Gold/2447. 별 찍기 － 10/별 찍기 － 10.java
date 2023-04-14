import java.io.*;
import java.util.*;

public class Main {
    static String[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        map = new String[N][N];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = "*";
            }
        }

        star(0, 0, N);

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                bw.write(map[i][j]);
                if(j == N-1) bw.write("\n");
            }
        }

        bw.flush();
        bw.close();

    }

    //재귀 구현 두가지
    //1. 끝이 명확히 있는가?
    //2. 모든 입력값이 끝으로 수렴하는가?
    //끝으로 가는 과정에서 내가 구현할것 구현하기.

    static void star(int r, int c, int N) {
        if(N == 1) return;

        for(int i = N/3 ; i < 2*N/3 ; i++) {
            for(int j = N/3 ; j < 2*N/3 ; j++) {
                map[r + i][c + j] = " ";
            }
        }


        for(int i = 0 ; i < 3 ; i++) {
            for(int j = 0 ; j < 3 ; j++) {
                star(r + N/3 * i , c + N/3 * j, N/3);
            }
        }

    }
    
}