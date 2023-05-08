import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if(s.length() == 1) {
                bw.write("1 1\n");
            }
            else {
                //초깃값세팅
                int max = -1;
                int min = Integer.MAX_VALUE;
                ArrayList<Integer>[] A = new ArrayList[26];

                for(int j = 0 ; j < 26 ; j++) {
                    A[j] = new ArrayList<Integer>();
                }

                //여기부터.
                //A[0] = 'a' 의 index들, A[1] = 'b'의 index들...

                for(int j = 0 ; j < s.length() ; j++) {
                    int x = s.charAt(j) - 'a';
                    A[x].add(j);
                }

                for(int j = 0 ; j < 26 ; j++) {
                    if(A[j].size() < k) continue; //문자열에 해당 알파벳이 최소 k개는 나와야지 크기측정가능

                    for(int u = 0 ; u+k-1 <= A[j].size()-1 ; u++) {
                        int length = A[j].get(u+k-1) - A[j].get(u)+1;
                        if(min > length) min = length;
                        if(max < length) max = length;
                    }
                }

                if(max == -1)bw.write("-1\n");
                else bw.write(String.valueOf(min) + " " + String.valueOf(max) + "\n");
            }
        }

        bw.flush();
        bw.close();

    }

}