import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        int[] baby = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            baby[i] = Integer.parseInt(st2.nextToken());
        }

        int[] diff = new int[N-1]; //오름차순으로 정렬되어있는 애기들의 키를 자기보다 앞쪽의 애기와 키차이를 비교해서 넣을예정.

        for(int i = 0 ; i < N-1 ; i++) {
            diff[i] = baby[i+1] - baby[i];
        }

        Arrays.sort(diff);

        //잘 생각해보면, baby가 아기1키 아기2키 아기3키 아기4키 아기5키 이런식으로 있다면,
        //diff는 아기2-아기1, 아기3-아기2, 아기4-아기3, 아기5-아기4 이런식으로 들어가게 됨.
        //키 차이가 클수록 나가는 돈이 커지니까, 우리는 키 차이의 최솟값을 찾아야 함.
        //그래서 가장 키차이가 크게나는 쪽을 찢어줄 예정.
        //(diff를 sort후 가장 큰값 K-1개를 빼주면, K개의 집합이 나오고, 작은값 N-K+1개를 더해주면 sort 한 이후이더라도
        // 집합에서 가장 큰 아기 - 집합에서 가장 작은 아기 의 값(diff의 원소값 몇개의 합)은 K개 전부 더해진다.)
        // 바로 윗줄이 이해가 안간다면, abcd 값을 sort해서 adcb를 하더래도, a+b+c+d = a+d+c+b 이기 때문.

        int answer = 0;
        for(int i = 0 ; i < N-K ; i++) {
            answer += diff[i];
        }


        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

}