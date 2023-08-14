import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[a];
        for(int i = 0 ; i < a ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int b = Integer.parseInt(br.readLine());
        
        int answer = 0;
        
        for(int i = 0 ; i < a ; i++) {
            if(b == arr[i]) answer++;
        }


        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        
        
    }

}