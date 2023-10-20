import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String nums = br.readLine();
        char[] num = nums.toCharArray();

        Stack<Integer> s = new Stack<>();
        //해당 스택에 숫자 앞자리부터 넣어주면서, 더 큰숫자나왔을때 k 제한에 맞을때까지 뺴줄 예정
        //예를 들어, 4355, k = 2 일때
        //4 -> 43 -> 들어갈 숫자 5가 3보다 크니까, 스택에서 비교해서 빼줌 (숫자 하나 빼주고 다시비교 k--;)
        //43에서 3이 빠진 후의 4. 여기서도 들어갈 5가 4보다 크니까 스택에서 빼줌 (k--;) 이제 k가 0이 되어서 숫자 생략 불가능.
        //여기까지 스택에 있는 숫자들 거꾸로한것 + 남은 숫자들 붙여서 숫자 만들어주기


        for(int i = 0 ; i < n ; i++) {
            int cur = num[i] - '0';
            //num에서 i번째 숫자 cur

            while(true) {
                if(s.isEmpty() || k == 0 || s.peek() >= cur) break;
                //스택 비었거나 더이상 제외할 수 없거나 지금 스택 위의 숫자가 커서 밀어내지 못하면 브레이크
                s.pop();
                k--;
            }
            s.add(cur); //위에서 빼줄거 빼주고 스택에 다시 넣기 (와일문 거치지 않아도 여기는 거친다)
        }

        //여기까지 오면 스택에 바닥부터 k개 무시한 후 최댓값이 들어가있음

        //이부분이 애먹음.
        //9993333932 에서 5개 제외한다고 생각.
        //스택은 999932이고, k는 1인채고 위의 for문 마치게 된다.
        //k를 다 사용하지 않은채로 마치면, 무조건 스택 위의 값들은 아래 값들보다 더 작을 수 밖에 없다. (s.peek() >= cur break 작동.)
        //무조건 제외해야할 개수 전부 소진시켜야 하므로 아래의 로직을 사용한다.
        while(k != 0) {
            s.pop();
            k--;
        }
        //여기 지나고 나면 스택은 99993이 되고 k는 0이 된다.

        StringBuilder answer = new StringBuilder();

        while(!s.isEmpty()) {
            answer.append(s.pop());
        }
        //거꾸로 해주기 (123 -> 321)
        answer.reverse();


        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

}