import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        for(int i = 1 ; i <= 10 ; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];

            for(int j = 0 ; j < n ; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            bw.write("#" + String.valueOf(i) + " " + String.valueOf(calc(arr)) + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }


    static int calc(int[] arr) {
        //0번쨰 1번째, n-2번째, n-1번째는 무조건 0
        int answer = 0;
        for(int i = 2 ; i <= arr.length-3 ; i++) {
            if(check(arr, i)) {
                int max1 = Math.max(arr[i-2], arr[i-1]);
                int max2 = Math.max(arr[i+2], arr[i+1]);
                int max = Math.max(max1, max2);
                answer += arr[i] - max;
            }
        }

        return answer;
    }

    static boolean check(int[] arr, int idx) {
        //조망권 가리면 false
        if(arr[idx-2] >= arr[idx] || arr[idx-1] >= arr[idx] || arr[idx+1] >= arr[idx] ||arr[idx+2] >= arr[idx]) return false;
        return true;
    }
}