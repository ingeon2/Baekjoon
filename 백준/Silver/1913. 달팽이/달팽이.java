import java.util.*;
import java.io.*;

public class Main {
    static int N, w, a, b;
    static int[][] map;
    static int[] dr = {1, 0, -1, 0}; //하 우 상 좌 순서
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] v;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());
        a = 0;
        b = 0;

        map = new int[N][N];
        v = new boolean[N][N];

        fill();

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                bw.write(String.valueOf(map[i][j]) + " ");
            }
            bw.write("\n");
        }

        bw.write(String.valueOf(a) + " " + String.valueOf(b));
        bw.flush();
        bw.close();
        
    }

    static void fill() {
        int x = N*N;
        int r = 0;
        int c = 0;
        int d = 0;
        
        while(x > 0) {
            map[r][c] = x;
            v[r][c] = true;
            if(x == w) {
                a = r+1;
                b = c+1;
            }
            x--;

            r += dr[d];
            c += dc[d];

            if(!isValid(r, c)) {
                r -= dr[d];
                c -= dc[d];
                d = (d+1)%4;
                r += dr[d];
                c += dc[d];
            }
        }
    }

    static boolean isValid(int r, int c) {
        if(r < 0 || r >= N || c < 0 || c >= N || v[r][c]) return false;
        return true;
    }

}