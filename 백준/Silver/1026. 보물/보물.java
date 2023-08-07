import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            arr1.add(Integer.parseInt(st1.nextToken()));
            arr2.add(Integer.parseInt(st2.nextToken()));
        }

        Collections.sort(arr1);
        Collections.sort(arr2, Collections.reverseOrder());

        int answer = 0;

        for(int i = 0 ; i < N ; i++) {
            answer += arr1.get(i) * arr2.get(i);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }


}