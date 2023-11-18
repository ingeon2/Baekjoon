import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int c = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= c ; i++) {

            //// N=4
            int N = Integer.parseInt(br.readLine());

            //// A1=2, A2=4, A3=7, A4=10
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < N ; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int answer = 0;

            for(int j = 0 ; j < N-1 ; j++) {
                for(int k = j+1 ; k < N ; k++) {
                    if(isOk(arr[j] * arr[k])) answer = Math.max(answer, arr[j] * arr[k]);
                }
            }




            if(answer != 0) bw.write("#" + String.valueOf(i) + " " + String.valueOf(answer) + "\n");
            else bw.write("#" + String.valueOf(i) + " " + String.valueOf(-1) + "\n");


        }



        bw.flush();
        bw.close();
        br.close();
    }
    
    static boolean isOk(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        for(int i = arr.length-1 ; i >= 1 ; i--) {
            if((int) arr[i] < (int) arr[i-1]) return false;
        }

        return true;
    }

    
}