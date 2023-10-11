import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;

        int[][] map = new int[N][N];
        int x = N*N;

        int r = 0;
        int c = 0;

        while(true) {
            // 아래
            while(true) {
                map[r][c] = x;
                if(x == w) {
                    a = r+1;
                    b = c+1;
                }
                x--;
                r++;
                if(r == N) {
                    r--;
                    c++;
                    break;
                }

                if(map[r][c] != 0) {
                    r--;
                    c++;
                    break;
                }
            }
            if(x == 0) break;

            //오른
            while(true) {
                map[r][c] = x;
                if(x == w) {
                    a = r+1;
                    b = c+1;
                }
                x--;
                c++;
                if(c == N) {
                    c--;
                    r--;
                    break;
                }

                if(map[r][c] != 0) {
                    c--;
                    r--;
                    break;
                }
            }


            //위
            while(true) {
                map[r][c] = x;
                if(x == w) {
                    a = r+1;
                    b = c+1;
                }
                x--;
                r--;
                if(r == -1) {
                    r++;
                    c--;
                    break;
                }

                if(map[r][c] != 0) {
                    r++;
                    c--;
                    break;
                }
            }

            //왼
            while(true) {
                map[r][c] = x;
                if(x == w) {
                    a = r+1;
                    b = c+1;
                }
                x--;
                c--;
                if(c == -1) {
                    c++;
                    r++;
                    break;
                }

                if(map[r][c] != 0) {
                    c++;
                    r++;
                    break;
                }
            }
        }

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

}