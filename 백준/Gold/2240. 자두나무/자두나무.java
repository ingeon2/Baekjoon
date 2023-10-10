import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //자두는 하나의 나무 아래에 서 있다가 다른 나무 아래로 빠르게(1초보다 훨씬 짧은 시간에) 움직일 수 있다.
        //최악의 경우를 생각해보자. T는 1000이고, 움직일 수 있는 횟수는 30이다.
        //자두는 1초보다 훨씬 짧은 시간에 움직일 수 있다고 했으므로, 정해진 하나의 초에 W회를 다 움직이는 것도 가능하다.
        //그렇다면, 경우의 수는 1000^30 이 된다. (움직일 수 있는 1회당 1000초가 존재하고, 30회를 움직일 수 있으므로)
        //2초, 2억번을 아득히 뛰어넘는다.
        //그렇다면, 문제는 DP로 접근해야 한다.
        
        StringTokenizer st = new StringTokenizer(br.readLine()); //첫줄 입력
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[T+1]; //t미터에 떨어지는 자두의 위치 입력
        for(int i = 1 ; i <= T ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int[][] D = new int[T+1][W+1]; //T미터에 W만큼 이동했을 때의 얻을 수 있는 자두의 최댓값, 다이나믹 프로그래밍.
        
        
        // D 채우기
        for(int t = 1 ; t <= T ; t++) {
            int cur = arr[t];

            //한번도 이동하지 않은것은 따로 값을 매겨줘야 함 (D[t][w-1]값은 index가 유효하지 않으므로)
            if(cur == 1) { //지금 자두 떨어지는 위치 1이라면
                D[t][0] = D[t-1][0] + 1; //가만히 있어도 자두 얻을 수 있다. (자두는 1번 자두나무 아래 위치가 초깃값이다.)
            }
            else { //자두 떨어지는 위치 2라면
                D[t][0] = D[t-1][0]; //가만히 있으면 자두를 얻을 수 없다.
            }

            for(int w = 1 ; w <= W ; w++) {
                if(cur == 1) { //지금 자두 떨어지는 위치 1이라면,
                    if(w%2 == 0) { //현재 w 값이 짝수라서 짝수 횟수만큼 이동하여 자두가 현재 위치 1에 있다면
                        D[t][w] = Math.max(D[t-1][w] + 1, D[t-1][w-1]);
                        //D 배열에는, 이동하지 않고 그대로 자두 하나를 얻는것과, 이동하여 자두 하나를 얻지 않는 것 중에 최댓값이 들어가게 된다.
                    }
                    else { //현재 w가 홀수라서 내 위치가 2라서 떨어지는 자두와 위치가 일치하지 않는다면
                        D[t][w] = Math.max(D[t-1][w-1] + 1, D[t-1][w]);
                        //이동하여 자두를 하나 얻는것과, 이동하지 않고 자두를 얻지 않는것 중 최댓값
                    }
                }
                else { //현재 자두가 떨어지는 위치가 2라면
                    if(w%2 == 0) {
                        D[t][w] = Math.max(D[t-1][w-1] + 1, D[t-1][w]);
                    }
                    else {
                        D[t][w] = Math.max(D[t-1][w] + 1, D[t-1][w-1]);
                    }
                }
            }
        }

        int answer = 0;
        for(int i = 0 ; i <= W ; i++) {
            answer = Math.max(D[T][i], answer);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        
    }

}