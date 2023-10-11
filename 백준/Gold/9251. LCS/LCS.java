import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = br.readLine();
        String s2 = br.readLine();

        int l1 = s1.length();
        int l2 = s2.length();
        
        int[][] D = new int[l2][l1];
        //D[i][j] = s1이 j 길이만큼 s2가 i 길이만큼 존재 할 때 최장 공통 부분수열의 길이

        if(s1.indexOf(s2.substring(0,1)) != -1) {
            for(int i = s1.indexOf(s2.substring(0, 1)) ; i < l1 ; i++) {
                D[0][i] = 1;
            }
        }

        if(s2.indexOf(s1.substring(0,1)) != -1) {
            for(int j = s2.indexOf(s1.substring(0, 1)) ; j < l2 ; j++) {
                D[j][0] = 1;
            }
        }

        for(int r = 1 ; r < l2 ; r++) {
            for(int c = 1 ; c < l1 ; c++) {
                if(s2.charAt(r) == s1.charAt(c)) {
                    D[r][c] = D[r-1][c-1] + 1;
                }
                else {
                    D[r][c] = Math.max(D[r-1][c], D[r][c-1]);
                }
            }
        }

        bw.write(String.valueOf(D[l2-1][l1-1]));
        bw.flush();
        bw.close();
    }

}