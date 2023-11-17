import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 1 ; i <= t ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //음식 개수
            int c = Integer.parseInt(st.nextToken()); //칼로리 제한

            int[] cs = new int[n]; //i번째 음식 칼로리
            int[] sc = new int[n]; //i번째 음식 점수
            
            int[] D = new int[c+1]; //i 칼로리까지의 최대 점수

            for(int j = 0 ; j < n ; j++) {
                st = new StringTokenizer(br.readLine());
                sc[j] = Integer.parseInt(st.nextToken()); //점수
                cs[j] = Integer.parseInt(st.nextToken()); //칼로리
            }
            
            //DP문제, 한번 사용한 재료는 사용할 수 없음
            int answer = 0;
            for(int j = 0 ; j < n ; j++) { //j번째 음식 하나잡고
                for(int k = c ; k - cs[j] >= 0 ; k--) { // 칼로리 제한부터 칼로리 줄여나가며
                    D[k] = Math.max(D[k], D[k-cs[j]] + sc[j]); 
                    //지금 칼로리와, 해당 음식 먹기 전 칼로리에 해당음식 만족값 더한것 둘중 더 큰값
                    answer = Math.max(answer, D[k]);
                }
            }

            bw.write("#" + String.valueOf(i) + " " + String.valueOf(answer) + "\n");

        }



        bw.flush();
        bw.close();
        br.close();
    }


}
