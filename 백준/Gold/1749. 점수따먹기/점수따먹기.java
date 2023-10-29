import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] sum = new int[R][C];
        int answer = Integer.MIN_VALUE;
        
        for(int r = 0 ; r < R ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < C ; c++) {
                sum[r][c] = Integer.parseInt(st.nextToken());
                answer = Math.max(sum[r][c], answer);
            }
        }
        
        for(int r = 1 ; r < R ; r++) {
            sum[r][0] += sum[r-1][0];
            answer = Math.max(sum[r][0], answer);
        }
        
        for(int c = 1 ; c < C ; c++) {
            sum[0][c] += sum[0][c-1];
            answer = Math.max(answer, sum[0][c]);
        }
        
        //여기까지 초깃값
        for(int r = 1 ; r < R ; r++) {
            for(int c = 1 ; c < C ; c++) {
                sum[r][c] += sum[r-1][c] + sum[r][c-1] - sum[r-1][c-1];
                answer = Math.max(answer, sum[r][c]);
                //0행 0열 부터 r행 c열 까지의 합
            }
        }


        for(int r = 1 ; r < R ; r++) {
            for(int c = 1 ; c < C ; c++) {
                //a행 b열부터 r행 c열까지의 합
                for(int a = 1 ; a <= r ; a++) {
                    for(int b = 1 ; b <= c ; b++) {
                        if(a == r && b == c) continue;
                        answer = Math.max(sum[r][c] - sum[a-1][c] - sum[r][b-1] + sum[a-1][b-1], answer);
                        //위의 식을 이해하기
                    }
                }

            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

}