import java.io.*;
import java.util.*;

public class Main {
    static String S,T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        T = br.readLine();
        bw.write(String.valueOf(DFS(S, T)));
        bw.flush();
        bw.close();

    }

    static int DFS(String S, String T) {
        if(S.length() == T.length()) { //도달했을때 로직 또한 잘 짜야함.
            if(S.equals(T)) {
                return 1;
            }
            return 0;
        }
        int answer = 0; //DFS 들어올때마다 0으로 바뀜
        //거꾸로 가는데(늘리는것보다 규칙에서 제한두니 경우의 수 더 적어서), A_____B는 불가함 (변화하는 로직때문에)
        if(T.substring(T.length()-1).equals("A")) { //마지막 A이면, 마지막 A 떼주고 다시넣기
            answer += DFS(S, T.substring(0, T.length()-1));
        }
        
        if(T.substring(0,1).equals("B")) { //처음이 B이면, 처음 B빼주고 거꾸로 돌려서 다시넣기
            answer += DFS(S, backward(T.substring(1)));
        }

        if(answer > 0) return 1;
        else return 0;
    }





    static String backward(String S) {
        String answer = "";
        int s = S.length();
        for(int i = s ; i >= 1 ; i--) {
            answer += S.substring(i-1, i);
        }

        return answer;
    }
 }