import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[1001];
        int N = Integer.parseInt(br.readLine());

        int first_index = 1000;
        int max_first_index = 0;
        int max_last_index = 0;
        int max = 0;
        int last_index = 0;
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            arr[L] = H;
            if(H > max) {
                max = H;
            }
            if(last_index < L) last_index = L;
            if(first_index > L) first_index = L;
        }

        for(int i = first_index ; i <= last_index ; i++) {
            if(arr[i] == max) {
                max_first_index = i;
                break;
            }
        }
        for(int i = last_index ; i >= first_index ; i--) {
            if(arr[i] == max) {
                max_last_index = i;
                break;
            }
        }



        int width = 0;
        int heigth = arr[first_index];
        int now = first_index;
        int answer = 0;

        while(now <= max_first_index) {
            if(arr[now] > heigth) {
                answer += heigth * width;
                width = 0;
                heigth = arr[now];
            }
            else {
                now++;
                width++;
            }
        }

        heigth = arr[last_index];
        now = last_index;
        width = 0;

        while (now >= max_last_index) {
            if(arr[now] > heigth) {
                answer += heigth * width;
                width = 0;
                heigth = arr[now];
            }
            else {
                now--;
                width++;
            }
        }

        answer += (max_last_index - max_first_index + 1) * max;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

}