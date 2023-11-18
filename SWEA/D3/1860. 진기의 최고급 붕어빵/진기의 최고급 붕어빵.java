import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int c = Integer.parseInt(br.readLine());
        //진기는 0초부터 붕어빵을 만들기 시작하며, M초의 시간을 들이면 K개의 붕어빵을 만들 수 있다.
        //서빙은 진기가 하는 것이 아니기 때문에, 붕어빵이 완성되면 어떤 시간 지연도 없이 다음 붕어빵 만들기를 시작할 수 있다.
        //0초 이후에 손님들이 언제 도착하는지 주어지면, 모든 손님들에게 기다리는 시간없이 붕어빵을 제공할 수 있는지 판별하는 프로그램을 작성하라.

        for(int i = 1 ; i <= c ; i++) {
            //첫 번째 줄에는 세 자연수 N, M, K(1 ≤ N, M, K ≤ 100)가 공백으로 구분되어 주어진다.
            //M초동안 K개 붕어빵
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] bb = new int[11112]; //idx 초에 만들 수 있는 붕어빵의 개수

            for(int j = 0 ; j <= 11111 ; j++) { //1초부터 손님 옴
                bb[j] = K * (j / M);
            }

            //두 번째 줄에는 N개의 정수가 공백으로 구분되어 주어지며,
            //각 정수는 각 사람이 언제 도착하는지를 초 단위로 나타낸다. 각 수는 0이상 11,111이하이다.
            st = new StringTokenizer(br.readLine());

            int[] needs = new int[11112]; //idx 초에 필요한 붕어빵의 수
            int maxT = 0;
            for(int j = 0 ; j < N ; j++) { //해당 시간에 필요한 붕어빵 수 넣어주고,
                int curT = Integer.parseInt(st.nextToken());
                maxT = Math.max(maxT, curT);
                needs[curT]++;
            }

            //붕어빵 값을 끌어와서 누적합 시켜주어야 한다. (2초 1개 3초 1개 필요하면 3초에는 총 2개 필요하다)
            for(int j = 1 ; j <= maxT ; j++) {
                needs[j] += needs[j-1];
            }
            
            //이제 bb에는 idx 초에 만들 수 있는 붕어빵의 개수, needs에는 idx 초에 필요한 붕어빵의 수 입력.
            //그렇다면 순회하며 필요한 붕어빵의 수가 더 많다 -> 임파서블
            //아니다 -> 파서블

            //손님 오는 최대 시간까지만 체크해주면 된다.
            boolean can = true;
            for(int j = 0 ; j <= maxT ; j++) {
                if(bb[j] < needs[j]) {
                    can = false;
                    break;
                }
            }

            if(!can) { //임파서블
                bw.write("#" + String.valueOf(i) + " Impossible\n");
            }
            else {
                bw.write("#" + String.valueOf(i) + " Possible\n");
            }

            

        }



        bw.flush();
        bw.close();
        br.close();
    }


}
