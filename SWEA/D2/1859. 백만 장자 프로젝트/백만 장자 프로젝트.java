import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int c = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= c ; i++) {

            //int[] arr 받고 거꾸로 가기
            //11312 -> 2 최댓값 지정, 1 만나면 +=2-1 해주고 그다음 3나오면 최댓값 3으로 변경 이런식으로
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[n];

            for(int j = 0 ; j < n ; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            bw.write("#" + String.valueOf(i) + " " + String.valueOf(makeMax(arr)) + "\n");


        }



        bw.flush();
        bw.close();
        br.close();
    }

    static long makeMax(int[] arr) {
        int l = arr.length;
        int max = arr[l-1];
        long answer = 0;
        for(int i = l-2 ; i >= 0 ; i--) {
            if(max < arr[i]) max = arr[i];
            else answer += max - arr[i];
        }

        return answer;
    }


}
