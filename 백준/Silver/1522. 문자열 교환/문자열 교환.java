import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //문자열 주어지면, a 개수만큼의 크기의 슬라이딩 윈도 돌면서 b가 가장 최솟값일 때가 정답임.
        String s = br.readLine();
        int a_size = s.replace("b", "").length();

        //슬라이딩 윈도 초깃값 세팅
        int min_num_b = 0;
        for(int i = 0 ; i < a_size ; i++) {
            if(s.substring(i, i+1).equals("b")) min_num_b++;
        }

        int answer = min_num_b;
        
        //이제 슬라이딩 윈도 시작점 0~s.length()-1 까지 돌기 (end 크기 초과시 %s.length())
        int start = 0;
        while(true) {

            //시작점 빼주기
            if(s.substring(start, start+1).equals("b")) min_num_b--;

            //끝점 더해주기
            int end = (start + a_size) % s.length();
            if(s.substring(end, end+1).equals("b")) min_num_b++;
            
            //answer 값 갱신
            if(answer > min_num_b) answer = min_num_b;

            //탈출 조건
            start++;
            if(start == s.length()) break;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

}