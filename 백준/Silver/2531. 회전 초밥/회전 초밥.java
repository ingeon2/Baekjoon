import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //회전 초밥 음식점의 벨트 상태, 메뉴에 있는 초밥의 가짓수,
        //연속해서 먹는 접시의 개수, 쿠폰 번호가 주어졌을 때,
        //손님이 먹을 수 있는 초밥 가짓수의 최댓값을 구하는 프로그램을 작성

        //첫 번째 줄에는 회전 초밥 벨트에 놓인 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
        //단, 2 ≤ N ≤ 30,000, 2 ≤ d ≤ 3,000, 2 ≤ k ≤ 3,000 (k ≤ N), 1 ≤ c ≤ d
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //접시
        int d = Integer.parseInt(st.nextToken()); //초밥종류수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹을 접시 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰번호
        
        //초깃값 how_many, 회전초밥 만들고 그거 채우기, 종류 숫자 만들기
        int[] how_many = new int[d+1]; //index 종류의 초밥이 슬라이딩 윈도 안에 몇개잇는지
        int[] rotationSushi = new int[N];
        int answer = 0;
        
        //회전초밥 채우기
        for(int i = 0 ; i < N ; i++) {
            rotationSushi[i] = Integer.parseInt(br.readLine());
        }
        
        //슬라이딩윈도 초기세팅
        for(int i = 0 ; i < k ; i++) {
            how_many[rotationSushi[i]]++;
            if(how_many[rotationSushi[i]] == 1) answer++;
        }
        //c 포함안하면 쿠폰으로 먹게되니 종류 늘려주고

        int max = answer;

        if(how_many[c] == 0) {
            max = answer+1;
        }
        else {
            max = answer;
        }

        //슬라이딩윈도 + c 포함하는지 ㄱㄱ
        //슬라이딩 윈도 안에, 해당 번호의 초밥이 몇개 있는지를 기록, 윈도로 슬라이딩하면서 how_many 배열의 개수 업데이트.
        int start = 0;

        int realAnswer = max;

        while(true) {
            if(realAnswer == k+1) break;
            //start index 빼고, 하우매니가 0이면 사라진거니까 종류 하나빼주기
            how_many[rotationSushi[start]]--;
            if(how_many[rotationSushi[start]] == 0) answer--;

            //end index 더해주고, 하우매니가 1이면 하나뿐인거니 종류 하나 더해주기, 단 index 크기 설정해야함
            int end = (start + k) % N; //회전초밥은 끝과 처음이 연결되어있으니.
            how_many[rotationSushi[end]]++;
            if(how_many[rotationSushi[end]] == 1) answer++;

            if(how_many[c] == 0) {
                max = answer+1;
            }
            else {
                max = answer;
            }

            if(realAnswer < max) realAnswer = max;


            start++;
            if(start == N) break;
        }
        //개수 업데이트하며 1이면 종류++, 아니면 종류-- 
        //그다음 how_many의 index c-1이 0이면 슬라이딩 윈도에 c 포함 안한거니까 종류++;
        //만약 종류가 k+1 이라면 그만두고 때려치기
        //시작점 0 부터, 시작점 N-1 까지. 시작점 N-1은 어떻게구현할까..? 슬라이딩윈도 끝번 할거잖아. 끝번이 N보다 크거나 같다면 N-1 빼주기.

        bw.write(String.valueOf(realAnswer));
        bw.flush();
        bw.close();


    }

}