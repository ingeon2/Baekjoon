import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        nums = new int[26]; //각각의 알파벳이 몇개 나왔는지 (자릿수 반영)
        //(ex - bcd -> 100b + 10c + d 이므로, 각각  알파벳 -'A' += 해줄 예정)

        for(int i = 0 ; i < N ; i++) {
            makeInt(br.readLine());
        }

        Arrays.sort(nums);

        int i = 0;
        int answer = 0;
        while(true) {
            int a = nums[25 - i];
            if(a == 0) break;
            answer += a * (9-i);
            i++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    static void makeInt(String s) { //주어진 모든 단어 돌리면, nums에 저장.
        char[] arr = s.toCharArray();
        int index = 1;
        for(char c : arr) {
            nums[c - 'A'] += Math.pow((double) 10, (double) arr.length - index);
            index++;
            //(ex - bcd -> 100b + 10c + d 이므로, 각각  알파벳 -'A' += 100b 이런식으로.)
        }
    }


}