import java.io.*;
import java.util.*;

public class Main {
    static int L,C;
    static char[] arr;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        String S = br.readLine();
        S = S.replace(" ", "");
        arr = S.toCharArray();
        Arrays.sort(arr); //알파벳순

        backTracking(0, "", 0);

        bw.flush();
        bw.close();
        
    }

    static void backTracking(int depth, String s, int start) throws IOException {
        if(depth == L) {
            if(aeiou(s) >= 1 && L-aeiou(s) >= 2) { //모음 수 1개 이상, 자음 수 2개 이상
                bw.write(s + "\n");
            }
        }


        for(int i = start ; i < C ; i++) {
            s += arr[i];
            backTracking(depth+1, s, i+1);
            s = s.substring(0, s.length()-1);
        }

    }



    static int aeiou(String s) {
        char[] arr = s.toCharArray();
        int answer = 0;

        for(char c : arr) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') answer++;
        }

        return answer;
    }

}