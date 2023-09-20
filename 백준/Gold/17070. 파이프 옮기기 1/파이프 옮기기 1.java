import java.util.*;
import java.io.*;


public class Main {
    static int answer = 0;
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

        bt(new Node(1, 0, 1));

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    static void bt(Node cur) {
        int s = cur.s;
        int r = cur.r;
        int c = cur.c;

        if(r == N-1 && c == N-1) {
            answer++;
            return;
        }

        if(s == 1) {
            if(isValid(r, c+1) && map[r][c+1] == 0) bt(new Node(1, r, c+1));
            if(isValid(r+1, c+1) && map[r][c+1] == 0 && map[r+1][c+1] == 0 && map[r+1][c] == 0) bt(new Node(3, r+1, c+1));
        }
        else if(s == 2) {
            if(isValid(r+1, c) && map[r+1][c] == 0) bt(new Node(2, r+1, c));
            if(isValid(r+1, c+1) && map[r][c+1] == 0 && map[r+1][c+1] == 0 && map[r+1][c] == 0) bt(new Node(3, r+1, c+1));
        }
        else {
            if(isValid(r, c+1) && map[r][c+1] == 0) bt(new Node(1, r, c+1));
            if(isValid(r+1, c) && map[r+1][c] == 0) bt(new Node(2, r+1, c));
            if(isValid(r+1, c+1) && map[r][c+1] == 0 && map[r+1][c+1] == 0 && map[r+1][c] == 0) bt(new Node(3, r+1, c+1));

        }
    }


    static boolean isValid(int r, int c) {
        if(r < 0 || r >= N || c < 0 || c >= N) return false;
        return true;
    }

    static class Node {
        int s,r,c;

        public Node(int s, int r, int c) {
            this.s = s;
            this.r = r;
            this.c = c;
        }
    }

}