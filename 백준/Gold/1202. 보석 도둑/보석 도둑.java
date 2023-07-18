import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000) (가각 보석, 가방 수)
        //
        //다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)
        //
        //다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)
        //
        //모든 숫자는 양의 정수이다.

        //보석을 arraylist로 입력받은 후 무게 순서대로 오름차순 정렬한다.
        //가방에 담을 수 있는 최대 무게를 입력 받은 후 오름차순 정렬한다.
        //가격 순서대로 내림차순 정렬을 하는 우선순위 큐를 생성한다.

        //현재 가방이 담을 수 있는 최대 무게보다 작거나 같은 무게를 가진 보석을 우선순위 큐에 담아준다.
        //우선순위 큐의 제일 첫 번째 값(가장 가격이 비싼 보석)을 꺼내어 더해준다.
        //위의 두 순서를 반복해주면 된다.

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        ArrayList<Jewel> list = new ArrayList<>();

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            list.add(new Jewel(w, v));
        }
        
        Collections.sort(list, (o1, o2) -> o1.w - o2.w); //무게 오름차순

        int[] bags = new int[K];
        for(int i = 0 ; i < K ; i++) {
            bags[i] = (Integer.parseInt(br.readLine()));
        }
        
        Arrays.sort(bags); //가방 용량순 오름차순
        PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v); //가격 내림차순

        long answer = 0;
        int index = 0;
        //현재 가방이 담을 수 있는 최대 무게보다 작거나 같은 무게를 가진 보석을 우선순위 큐에 담아준다.
        //우선순위 큐의 제일 첫 번째 값(가장 가격이 비싼 보석)을 꺼내어 더해준다.
        for(int i = 0 ; i < K ; i++) {
            while(index < N && list.get(index).w <= bags[i]) {
                Jewel curJewel = list.get(index);
                pq.add(new Jewel(curJewel.w, curJewel.v));
                index++;
            }

            if(!pq.isEmpty()) {
                answer += pq.poll().v;
            }

        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        
    }

    static class Jewel {
        int w, v;

        public Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }


    }


}