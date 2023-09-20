import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int N;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int r = 0 ; r < N ; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < N ; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] D = new int[N][N][3];

        for(int i = 1 ; i < N ; i++) {
            if(map[0][i] == 1) break;
            D[0][i][0] = 1;
        }

        for(int r = 1 ; r < N ; r++) {
            for(int c = 1 ; c < N ; c++) {
                if(map[r][c] == 1) continue;
                //가로
                D[r][c][0] += D[r][c-1][0];
                D[r][c][0] += D[r][c-1][2];

                //세로
                D[r][c][1] += D[r-1][c][1];
                D[r][c][1] += D[r-1][c][2];

                if(map[r-1][c] == 1 || map[r][c-1] == 1) continue;
                //대각
                D[r][c][2] += D[r-1][c-1][0];
                D[r][c][2] += D[r-1][c-1][1];
                D[r][c][2] += D[r-1][c-1][2];
            }
        }

        bw.write(String.valueOf(D[N-1][N-1][0] + D[N-1][N-1][1] + D[N-1][N-1][2]));
        bw.flush();
        bw.close();

    }

    
}