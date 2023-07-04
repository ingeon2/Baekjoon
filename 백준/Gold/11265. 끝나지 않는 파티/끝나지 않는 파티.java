import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 새로운 파티장과 기존의 모든 파티장이 직접적으로 연결이 될 수 있는 도로들을 만들었다.
        // 이때 만들어진 도로들은 사용자들의 편의를 위해 일방통행

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        int[][] floyd = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++) {
                floyd[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        //초깃값 완성

        for(int k = 0 ; k < N ; k++) {
            for(int i = 0 ; i < N ; i++) {
                if(k == i) continue;
                for(int j = 0 ; j < N ; j++){
                    if(i == j || j == k) continue;
                    if(floyd[i][j] > floyd[i][k] + floyd[k][j]) floyd[i][j] = floyd[i][k] + floyd[k][j];

                }
            }
        }

        //플로이드, 와샬 알고리즘으로 floyd[i][j] 는 i에서 j까지의 최솟값으로 바뀜.

        for(int i = 0 ; i < M ; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st3.nextToken()); //현재 위치
            int B = Integer.parseInt(st3.nextToken()); //가고싶은 위치
            int C = Integer.parseInt(st3.nextToken()); //주어진 시간

            if(floyd[A-1][B-1] > C) { //최솟값이 주어진 시간보다 크다면 못가
                bw.write("Stay here\n");
            }
            else {
                bw.write("Enjoy other party\n");
            }
        }


        bw.flush();
        bw.close();
        
    }
    
}