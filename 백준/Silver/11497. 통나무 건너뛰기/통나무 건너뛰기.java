import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] tree = new int[N]; //나무 주어진대로 넣기
            int[] answer = new int[N]; //나무 높이 차 최솟값으로 넣기
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0 ; i < N ; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(tree); //정렬된 tree를 처음 index부터 차례대로 왼쪽, 오른쪽으로 넣기 = 인접한 통나무의 높이 차가 최소가 된다.

            if(N % 2 ==0) {
                int i = 0;
                int left = 0;
                int right = N-1;
                while(left+1 <= right) {
                    answer[left] = tree[i];
                    answer[right] = tree[i+1];
                    i+=2;
                    left++;
                    right--;
                }
            }
            else {
                int i = 0;
                int left = 0;
                int right = N-1;
                while(left != right) {
                    answer[left] = tree[i];
                    answer[right] = tree[i+1];
                    i+=2;
                    left++;
                    right--;
                }
                answer[N/2] = tree[N-1];
            }
            //여까지오면 answer엔 높이 차 최솟값으로 넣어놨음.

            int max = Math.abs(answer[N-1] - answer[0]);

            for(int j = 0 ; j < N-1 ; j++) {
                if(max < Math.abs(answer[j] - answer[j+1])) max = Math.abs(answer[j] - answer[j+1]);
            }

            bw.write(String.valueOf(max) + "\n");

        }

        bw.flush();
        bw.close();
    }

}