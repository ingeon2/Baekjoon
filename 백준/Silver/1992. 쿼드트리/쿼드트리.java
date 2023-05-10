import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static String[][] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];

        for(int i = 0 ; i < N ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = s.substring(j, j+1);
            }
        }

        self(0, 0, N);
        bw.flush();
        bw.close();




    }
    static void self(int x, int y, int N) throws IOException{
        if(allEqual(x, y, N)) {
            bw.write(map[x][y]);
            return;
        }


        bw.write("(");
        self(x, y, N/2);
        self(x, y+N/2, N/2);
        self(x+N/2, y, N/2);
        self(x+N/2, y+N/2, N/2);
        bw.write(")");
    }



    static boolean allEqual(int a, int b, int n) { //ab는 시작점, n은 볼 변의 크기 (모두 첫점 start와 같은지 판별해주는 매서드)
        String start = map[a][b];
        boolean result = true;
        for(int i = a ; i < a+n ; i++) {
            for(int j = b ; j < b+n ; j++) {
                if(!start.equals(map[i][j])) {
                    result = false;
                    break;
                }
            }
        }
        
        return result;
    }

    
}