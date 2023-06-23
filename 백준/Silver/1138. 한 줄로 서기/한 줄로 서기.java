import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //arr 이 주어짐
        //주어지는 arr 의 숫자는 해당 index의 사람이  자신보다 앞에있고 && 자신보다 키큰사람의 수임.
        //그리고 index 자체가 키의 크기임
        int N = Integer.parseInt(br.readLine());
        
        boolean[] visited = new boolean[N+1];
        int[] arr = new int[N+1];
        int[] answer = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 1 ; i <= N ; i++) {
            int count = Integer.parseInt(st.nextToken());
            int index = 1;

            while(visited[index] || count != 0) { //나는 여기가 제일 어렵네.. while문은 true일때 동작한다 라고 기억하자
                if(!visited[index]) {
                    count--;
                    index++;
                }
                else {
                    index++;
                }
            }

            answer[index] = i;
            visited[index] = true;

        }

        for(int i = 1; i <= N ; i++) {
            bw.write(String.valueOf(answer[i]) + " ");
        }

        bw.flush();
        bw.close();
    }

}