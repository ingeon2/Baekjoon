import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        int[] D = new int[max+1];
        D[1] = 1;
        if(max >= 2) D[2] = 2;

        for(int i = 3 ; i <= max ; i++) {
            D[i] = D[i-1] + D[i-2];
        }

        boolean[] fix = new boolean[max+1];
        for(int i = 0 ; i < t ; i++) {
            fix[Integer.parseInt(br.readLine())] = true;
        }

        int answer = 1;
        int l = 0;
        for(int i = 1 ; i <= max ; i++) {
            if(fix[i]) {
                if(l != 0) answer *= D[l];
                l = 0;
            }
            else {
                l++;
            }
        }

        if(l != 0) answer *= D[l];


        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

        
    }

}