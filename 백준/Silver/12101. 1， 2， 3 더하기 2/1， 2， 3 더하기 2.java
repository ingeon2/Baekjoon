import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<String> [] A = new ArrayList[11];

        for(int i = 1 ; i <= 10 ; i++) {
            A[i] = new ArrayList<>();
        }


        A[1].add("1");
        A[2].add("1+1");
        A[2].add("2");
        A[3].add("1+1+1");
        A[3].add("1+2");
        A[3].add("2+1");
        A[3].add("3");

        for(int i = 4 ; i <= n ; i++) {
            for(int j = i-1 ; j >= i-3 ; j--) {
                for(String s : A[j]) {
                    A[i].add(String.valueOf(i-j) + "+" + s);
                }
            }
        }

        if(A[n].size() >= k) {
            bw.write(A[n].get(k-1));
        }
        else{
            bw.write(String.valueOf(-1));
        }


        bw.flush();
        bw.close();


    }

}