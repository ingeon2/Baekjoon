import java.io.*;
import java.util.*;

public class Main {
    static int N,C;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램

        //입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        //이분 탐색
        int s = 1;
        int e = arr[N-1] - arr[0] + 1;

        while(s < e) {
            int m = (s+e)/2;
            if(C > num_houses(m)) e = m;
            else s = m+1;
        }

        bw.write(String.valueOf(e-1));
        bw.flush();
        bw.close();

    }


    static int num_houses(int length) { //거리에 따라 몇개 설치가능한지 나타내주는 매서드
        int a = 0;
        int b = 0;
        int answer = 1;

        while(b != N) {
            if(arr[b] - arr[a] < length) b++;
            else {
                a = b;
                b++;
                answer++;
            }
        }

        return answer;
    }

 }