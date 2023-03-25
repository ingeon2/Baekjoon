import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();

        int answer = 0;
        String[] arr = S.split("-");

        for(int i = 0 ; i < arr.length ; i++) {
            if(i == 0) answer += sum_string(arr[i]);
            else answer -= sum_string(arr[i]);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();


     }

     static int sum_string(String s) {
        int sum = 0;
        String[] B = s.split("[+]");
        for(String b : B) {
            sum += Integer.parseInt(b);
        }

        return sum;
     }
}