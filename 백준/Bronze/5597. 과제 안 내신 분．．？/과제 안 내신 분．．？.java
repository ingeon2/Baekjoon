import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] check = new boolean[31]; //1~30만 사용

        for(int i = 0 ; i < 28 ; i++) {
            check[Integer.parseInt(br.readLine())] = true;
        }

        for(int i = 1 ; i <= 30 ; i++) {
            if(!check[i]) bw.write(String.valueOf(i) + "\n");
        }

        bw.flush();
        bw.close();
    }

}