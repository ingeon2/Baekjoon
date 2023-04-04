import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //첫 숫자 N
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> s = new Stack<>(); //0은 인덱스 1은 타워높이

        for(int i = 0 ; i < N ; i++) {
            int n_tower = Integer.parseInt(st.nextToken());
            
            if(!s.isEmpty()) {
                while(true) {
                    //빼다가 비면 비어있을때 로직
                    if(s.isEmpty()) {
                        bw.write(String.valueOf(0) + " ");
                        s.add(new int[] {i, n_tower});
                        break;
                    }
                    
                    //지금 타워 값으로 뽑힌 n_tower보다 큰값 나올때까지 스택에서 빼다가 그 이하값나오면 인덱스+1을 기록
                    if(s.peek()[1] < n_tower) s.pop();
                    else {
                        bw.write(String.valueOf(s.peek()[0] + 1) + " ");
                        s.add(new int[] {i, n_tower});
                        break;
                    }
                }
            }
            else {
                bw.write(String.valueOf(0) + " ");
                s.add(new int[] {i, n_tower});
            }
        }

        bw.flush();
        bw.close();

    }

}