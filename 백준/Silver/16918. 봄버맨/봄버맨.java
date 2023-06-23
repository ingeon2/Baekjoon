import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0}; //상하좌우 순
    static int[] dc = {0, 0, -1, 1};
    
    static int R, C, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st1.nextToken());
        C = Integer.parseInt(st1.nextToken());
        N = Integer.parseInt(st1.nextToken());

        map = new int[R][C];

        for(int i = 0 ; i < R ; i++) {
            String line = br.readLine();
            for(int j = 0 ; j < C ; j++) {
                if(line.substring(j, j+1).equals("O")) map[i][j] = 1; //폭탄있음
            }
        }

        int time = 1;
        while(time != N) {
            if(time%2 == 1) {
                installBomb();
            }
            else {
                removeBomb();
            }
            time++;
        }

        //여기까지 오면 상황 끝.

        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                if(map[i][j] == 0) {
                    bw.write(".");
                }
                else {
                    bw.write("O");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();


    }


    
    static void installBomb() {
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                map[i][j]++; //폭탄 없는곳에 폭탄 설치 map[i][j] = 1; 과 map[i][j]++; 두개 다르다
                //폭탄이 없는곳에만 설치 + 있는 폭탄은 시간 더해주기가 위의 한줄으로 가능하다.
            }
        }
    }

    static void removeBomb() {
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                map[i][j]++;
            }
        }
        
        
        int[][] temp = new int[R][C]; //초기 상태를 기록해놓고 그 기록을 기반으로 로직을 짜야함
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                temp[i][j] = map[i][j];
            }
        }


        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                if(temp[i][j] >= 3) { //폭탄이 터질 시간이 지났다면
                    map[i][j] = 0; //해당 점 폭탄 터짐

                    for(int k = 0 ; k < 4 ; k++) {
                        int r = i + dr[k];
                        int c = j + dc[k];
                        if(r >= 0 && c >= 0 && r < R && c < C) { //index 알맞다면
                            map[r][c] = 0; //연쇄 폭발 점
                        }
                    }
                }
            }
        }

        


    }

}