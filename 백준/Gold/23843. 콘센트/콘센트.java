import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken()); //5
        int M = Integer.parseInt(st1.nextToken()); //2

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Long[] time = new Long[N];
        for(int i = 0 ; i < N ; i++) {
            time[i] = Long.parseLong(st2.nextToken()); // 1 4 4 8 1
        }
        Arrays.sort(time, Collections.reverseOrder()); //내림차순 정렬
        //8 4 4 1 1

        PriorityQueue<Long> q = new PriorityQueue<>();

        long max = 0;
        
        if(N > M) { //전자기기가 콘센트보다 많을떄
            for(int i = 0 ; i < M ; i++) { // 8 4 큐에 넣기
                q.add(time[i]);
            }

            for(int i = M ; i < N ; i++) { //8 4를 큐에 넣은 후 우선순위 큐에서 뽑고(작은수 먼저 나와서 크게 만들 예정) 시간 더해주고 다시 넣기
                long now = q.poll();
                long next = now + time[i];
                q.add(next);
            }

            //여기까지 오면, 우선순위 큐엔 M개만 담겨있음, 가장 큰값은 큐의 맨 처음에 들어가있음
            
            for(int i = 0 ; i < M ; i++) {
                if(i != M-1) {
                    q.poll();
                }
                else { //최댓값
                    max = q.poll();
                }
            }
            
        }
        else { //전자기기가 콘센트보다 적거나 같을때
            max = time[0];
        }

        //8 4
        //8 8
        //9 8
        //9 9

        

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

}