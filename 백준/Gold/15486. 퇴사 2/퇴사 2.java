import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n  = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][2];
        for(int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //걸리는 날
            arr[i][1] = Integer.parseInt(st.nextToken()); //얻는 돈
        }

        int[] D = new int[n+2]; //n+1일에 퇴사하니까, n+1일까지 일할 수 있다.
        //D[i] = i일 까지 일했을때 벌 수 있는 돈의 최댓값

        int max = 0;
        for(int i = 1 ; i <= n ; i++) { //현재 i일
            int finish = i + arr[i][0]; //마치는 날짜는 i + i일에 시작하는 작업의 걸리는 날짜

            if(max < D[i]) max = D[i];

            //해당 로직이 i일 이하까지 벌 수 있는 최댓값 기록해놓는것
            // (예를 들어, 어떤 날은 쉬고 가는게 돈을 더 많이 벌 수 있다. 테스트케이스 4번)

            if(finish > n+1) continue;
            if(D[finish] < max + arr[i][1]) D[finish] = max + arr[i][1];
        }

        int answer = 0;
        for(int i = 2 ; i <= n+1 ; i++) {
            answer = Math.max(answer, D[i]);
        }

        System.out.println(answer);

    }

}