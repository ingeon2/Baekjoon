import java.io.*;
import java.util.*;

public class Main {
    static int N; //들어올 숫자 수
    static int[] numbers; //숫자들 저장
    static int[] operator; //연산자 저장 (index 0123 각각 + - * / 순서)

    static int max;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operator = new int[4];

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        //숫자채우기
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(st1.nextToken());
        }

        //연산자채우기
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++) {
            operator[i] = Integer.parseInt(st2.nextToken());
        }

        backTracking(numbers[0], operator, numbers, 1);

        bw.write(String.valueOf(max) + "\n");
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();

    }
    //재귀함수 두가지 기억.
    //1. 재귀함수는 언제 끝내야하는가?, 그리고 끝나면서 해줘야 하는 로직은?
    //2. 끝내러 가는 와중에 어떤 로직(문제에서 원하는)을 작성해야 하는가?

    //14888번. 최대 숫자 개수는 11개이므로, 최대 연산자는 10개이다.
    //각각 연산자마다 들어갈 수 있는 종류는 최대 4가지이므로, 4^10 경우의 수가 나온다.
    //그렇다면, 4^10 = (2*2)^10 = 2^10 * 2^10 이므로 대충 10^6이다.
    //그렇다면, 보통 1초당 1억회의 연산이 가능하므로 모든 경우의 수를 돌더래도 시간초과는 나오지 않는다.
    //또한, 결과는 -10억 ~ 10억이므로, long 대신 int형을 사용할 수 있다는 뜻이다.

    //여기까진 스스로 이해했다.

    //근데, 그리디 알고리즘에 매몰되어서 모든 경우의 수를 탐방하는 백트래킹을 생각을 못했다. 너무너무 아쉽다.

    //이제 재귀함수를 작성하자.
    //언제 끝나는가? = numbers를 다 사용했을때. (depth로 표현할 예정), 끝나면서 해줄 로직은? = max, min값 갱신.
    //가면서 실행할 로직은 무엇인가? = oprator에서 꺼내온 것에 따라서, +, -, /, * 해줄 예정.

    static void backTracking(int now, int[] operator, int[] numbers, int depth) {
        if(depth == numbers.length) {
            if(now > max) max = now;
            if(now < min) min = now;
            return; //리턴 써주는거 기억하기
        }

        //이부분이 헷갈림. 어.. 그럼 순서대로 되는거 아닌가? 싶지만, 만약 연산자가 충분하다면 0000 0001 0002 이런식으로 모든 경우의 수를 돌 수 있음.
        //여기서 operator이 visited느낌임. 한번 방문이 아니라 가지고 있는 값만큼 방문 가능하다고 생각하면 될듯.
        //여기가 숫자 하나당 연산자 4개씩 늘어나는 로직임.
        for(int i = 0 ; i < 4 ; i++) {
            if(operator[i] == 0) continue;
            operator[i]--;

            int next;

            if(i == 0) {
                next = now + numbers[depth];
            }
            else if(i == 1) {
                next = now - numbers[depth];
            }
            else if(i == 2) {
                next = now * numbers[depth];
            }
            else {
                next = now / numbers[depth];
            }

            backTracking(next, operator, numbers, depth+1);

            operator[i]++;
        }
    }

}