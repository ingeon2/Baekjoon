import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> arr = new HashSet<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        for(int i = 0 ; i < N ; i++) {
            arr.add(br.readLine());
        }

        for(int i = 0 ; i < M ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), ",");
            while(st2.hasMoreTokens()) {
                arr.remove(st2.nextToken());
            }
            bw.write(String.valueOf(arr.size()) + "\n");
        }

        bw.flush();
        bw.close();



    }

}