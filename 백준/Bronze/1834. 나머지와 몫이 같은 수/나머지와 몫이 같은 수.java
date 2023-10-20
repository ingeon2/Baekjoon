import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long answer = 0;

        for(long i = 1 ; i <= n-1 ; i++) {
            answer += i + (n * i);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }


}