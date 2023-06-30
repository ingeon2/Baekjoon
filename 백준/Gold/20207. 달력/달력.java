import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //숫자 두개 주어지면, 해당 index++;
        //그러면 값이 0이 아니면 가로 있는것, 해당 값이 높이
        int N = Integer.parseInt(br.readLine());
        int[] schedule = new int[367]; //1~365

        int min = 1000;
        int max = -1;

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            min = Math.min(S, min);
            max = Math.max(E, max);

            for(int j = S ; j <= E ; j++) {
                schedule[j]++;
            }


        }

        //여기까지 오면
        //그러면 값이 0이 아니면 가로 있는것, 해당 값이 높이 완료.

        int answer = 0;
        int width = 0;
        int height = 0;
        for(int i = min-1 ; i <= max+1 ; i++) {
            if(schedule[i] == 0) {
                answer += width * height;
                width = 0;
                height = 0;
                continue;
            }

            width++;
            if(schedule[i] > height) height = schedule[i];

        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }


}