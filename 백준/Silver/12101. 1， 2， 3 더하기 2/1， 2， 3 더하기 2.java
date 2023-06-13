import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<String>[] answer = new ArrayList[11];

        for(int i = 0 ; i <= 10 ; i++) {
            answer[i] = new ArrayList<String>();
        }

        answer[1].add("1");

        answer[2].add("1+1");
        answer[2].add("2");

        answer[3].add("1+1+1");
        answer[3].add("1+2");
        answer[3].add("2+1");
        answer[3].add("3");

        for(int i = 4 ; i <= 10 ; i++) {
            for(int j = 1 ; j <= 3 ; j++) {
                for(String s : answer[i-j]) {
                    answer[i].add(j + "+" + s);
                }
            }
        }

        if(answer[n].size() >= k) {
            bw.write(answer[n].get(k-1));
        }
        else{
            bw.write(String.valueOf(-1));
        }

        bw.flush();
        bw.close();


    }

}