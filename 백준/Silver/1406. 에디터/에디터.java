import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        int N = Integer.parseInt(br.readLine());

        Stack<Character> head = new Stack<>();
        Stack<Character> tail = new Stack<>();

        for(int i = 0 ; i < S.length() ; i++) {
            head.add(S.charAt(i));
        }

        for(int i = 0 ; i < N ; i++) {
            String s = br.readLine();

            char a = s.charAt(0);

            if(a == 'L') {
                if(!head.isEmpty()) {
                    tail.add(head.pop());
                }
            }
            else if(a == 'D') {
                if(!tail.isEmpty()) {
                    head.add(tail.pop());
                }
            }
            else if(a == 'B') {
                if(!head.isEmpty()) {
                    head.pop();
                }
            }
            else {
                head.add(s.charAt(2));
            }
        }

        while(!head.isEmpty()) {
            tail.add(head.pop());
        }

        while(!tail.isEmpty()) {
            bw.write(tail.pop());
        }

        bw.flush();
        bw.close();

    }

}