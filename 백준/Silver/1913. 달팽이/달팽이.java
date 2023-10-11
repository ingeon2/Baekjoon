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

    //어떤 수가 주어지면 해당 수의 제곱수를 배열에 채우는 문제.
    //나는 위치를 변경할때 네 방향 다 while 문으로 해결했지만, dr과 dc를 잡고 방향 int d를 사용해서 때에 맞춰 해결해주면 된다.
    //쭉 내려간 후 보는게 아니라, 이동할 자리 보면서(isValid) 값 넣어주면 된다.

    //isValid 안에서 경계를 닿는건 마찬가지로 헀는데, 한번 방문해서 0이 아닌 값이 된 친구들을 만나는 로직을 (map[r][c] != 0)
    //v, 즉 방문 배열로 바꿔주었다. (v[r][c])


    static void fill() {
        int x = N*N;
        int d = 0;
        int nr = -1;
        int nc = 0;

        while(x > 0) {
            nr += dr[d];
            nc += dc[d];

            if(isValid(nr, nc)) {
                if(x == w) {
                    a = nr+1;
                    b = nc+1;
                }
                map[nr][nc] = x--;
                v[nr][nc] = true;
            }
            else {
                nr -= dr[d];
                nc -= dc[d];
                d = (d+1)%4;
            }
        }
    }

    static boolean isValid(int r, int c) {
        if(r < 0 || r >= N || c < 0 || c >= N || v[r][c]) return false;
        return true;
    }

}