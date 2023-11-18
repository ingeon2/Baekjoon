import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        for(int i = 1 ; i <= 10 ; i++) {

            int n = Integer.parseInt(br.readLine());
            //행렬 대각선 합 최댓값
            int[][] arr = new int[100][100];

            for(int r = 0 ; r < 100 ; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0 ; c < 100 ; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            
            //행,열 최대
            for(int j = 0 ; j < 100 ; j++) {
                int sumR = 0;
                int sumC = 0;
                for(int k = 0 ; k < 100 ; k++) {
                    sumR += arr[j][k];
                    sumC += arr[k][j];
                }
                answer = Math.max(answer, sumR);
                answer = Math.max(answer, sumC);
            }

            //대각선 오른쪽아래 최대
            int r = 0;
            int c = 0;
            int sum = 0;
            while(true) {
                sum += arr[r][c];
                r++;
                c++;
                if(r == 100) {
                    answer = Math.max(answer, sum);
                    break;
                }
            }

            //대각선 왼쪽아래 최대
            r = 0;
            c = 99;
            sum = 0;
            while(true) {
                sum += arr[r][c];
                r++;
                c--;
                if(r == 100) {
                    answer = Math.max(answer, sum);
                    break;
                }
            }

            bw.write("#" + String.valueOf(i) + " " + String.valueOf(answer) + "\n");

        }



        bw.flush();
        bw.close();
        br.close();
    }


}
