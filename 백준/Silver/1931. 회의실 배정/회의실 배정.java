import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Meet[] arr = new Meet[N];

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new Meet(s, e);
        }

        Arrays.sort(arr);

        int answer = 0;
        int nt = 0;

        for(int i = 0 ; i < N ; i++) {
            if(nt <= arr[i].s) {
                answer++;
                nt = arr[i].e;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static class Meet implements Comparable<Meet>{
        int s,e;

        public Meet(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Meet m) {
            if(this.e == m.e) {
                return this.s - m.s;
            }
            return this.e - m.e;
        }
    }
}