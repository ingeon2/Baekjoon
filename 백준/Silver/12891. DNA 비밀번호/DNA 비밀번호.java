import java.io.*;
import java.util.*;

public class Main {
    //고정된 원하는 ACTG개수, 변하는 실제 ACTG개수
    static int[] want_ACTG, real_ACTG;

    //실제가 원함 개수를 뛰어넘을때마다 체크해줄것 (ACTG다 만족하면 4여야 하는 수)
    static int check;

    //슬라이딩 윈도로 세주면서 개수 넘어가면 ++ 해줄 출력 수
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //초깃값
        want_ACTG = new int[4];
        real_ACTG = new int[4];
        check = 0;
        answer = 0;
        
        //첫줄 숫자 두개 DNA문자열 길이 S 사용할 비밀번호 길이 P
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st1.nextToken());
        int P = Integer.parseInt(st1.nextToken());
        
        //둘째 줄 길이 S의 DNA 문자열 나옴
        String DNA = br.readLine();
        
        //셋째 줄 각각 내가 원하는 ACTG의 개수 (want에 넣기)
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++) {
            want_ACTG[i] = Integer.parseInt(st2.nextToken());
            if(want_ACTG[i] == 0) {
                check++;
            }
        }



        //초기값설정 want 보고 0이면 check++해주고, for문 1부터 P 까지 DNA 순회하며 ADD
        char[] C = DNA.toCharArray();
        for(int i = 0 ; i < P ; i++) {
            ADD(C[i]);
        }

        //맨 처음 다 넣어주고 check이 P와 같으면 answer++ 해주고,
        if(check == 4) answer++;

        //for문으로 1부터 S-P+1 까지 ADD,REMOVE 하고 check 보면서 answer++
        for(int i = 0 ; i < S-P ; i++) {
            REMOVE(C[i]);
            ADD(C[P+i]);
            if(check == 4) answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }
    //슬라이딩윈도 구현.
    //추가, 삭제함수 구현

    //c가 무엇인가에 따라
    //리얼++해주고 원트랑 같다면 첵++
    static void ADD(char c) {
        if(c == 'A') {
            real_ACTG[0]++;
            if(real_ACTG[0] == want_ACTG[0]) {
                check++;
            }
        }
        else if(c == 'C') {
            real_ACTG[1]++;
            if(real_ACTG[1] == want_ACTG[1]) {
                check++;
            }
        }
        else if(c == 'G') {
            real_ACTG[2]++;
            if(real_ACTG[2] == want_ACTG[2]) {
                check++;
            }
        }
        else {
            real_ACTG[3]++;
            if(real_ACTG[3] == want_ACTG[3]) {
                check++;
            }
        }
    }


    //c가 무엇인가에 따라
    //리얼이랑 원트랑 같다면 첵--해주고 리얼--

    static void REMOVE(char c) {
        if(c == 'A') {
            if(real_ACTG[0] == want_ACTG[0]) {
                check--;
            }
            real_ACTG[0]--;
        }
        else if(c == 'C') {
            if(real_ACTG[1] == want_ACTG[1]) {
                check--;
            }
            real_ACTG[1]--;
        }
        else if(c == 'G') {
            if(real_ACTG[2] == want_ACTG[2]) {
                check--;
            }
            real_ACTG[2]--;
        }
        else {
            if(real_ACTG[3] == want_ACTG[3]) {
                check--;
            }
            real_ACTG[3]--;
        }
    }

}