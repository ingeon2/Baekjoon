import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //배열 주어지고, index 잡고, 해당 index의 숫자보다, 더 작은 수가 배열에 몇개 있는지.
        //이분탐색 로어바운드 찾기. 단순히 정렬하고 index를 출력하면 안된다.

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> a = new ArrayList<>();
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            a.add(Integer.parseInt(st.nextToken()));
            arr[i] = a.get(i);
        }

        List<Integer> a1 = a.stream().distinct().collect(Collectors.toList());
        Collections.sort(a1);






        for(int i = 0 ; i < N ; i++) {
            int s = 0;
            int e = a1.size()-1;

            while(s < e) {
                int m = (s+e)/2;

                if(a1.get(m) >= arr[i]) e = m;
                else s = m+1;
            }

            bw.write(String.valueOf(e) + " ");
        }

        bw.flush();
        bw.close();
    }

}