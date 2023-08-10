import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //길이, 열
        int H = Integer.parseInt(st.nextToken()); //높이, 행

        int[] s = new int[H+1]; //index 높이의 석순 수를 구한 다음, 낮을수록 누적합(높이 3일때 부러지면, 높이 1일때도 부러지니)
        int[] j = new int[H+1];

        for(int i = 0 ; i < N ; i++) {
            int h = Integer.parseInt(br.readLine());
            if(i % 2 == 0) {
                s[h]++;
            }
            else {
                j[h]++;
            }
        }

        for(int i = H-1 ; i >= 1 ; i--) {
            s[i] += s[i+1]; //i 높이로 갔을때 부수는 석순 수
            j[i] += j[i+1]; //H-i+1 높이로 갔을때 부수는 종유석 수
        }

        int[] broken = new int[H+1];

        int min = N;
        for(int i = 1 ; i <= H ; i++) {
            int a = s[i] + j[H-i+1];
            broken[i] = a;
            min = Math.min(a, min);
        }

        int nums = 0;
        for(int i = 1 ; i <= H ; i++) {
            if(broken[i] == min) nums++;
        }

        bw.write(String.valueOf(min + " " + nums));
        bw.flush();
        bw.close();


    }



}