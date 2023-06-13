import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken()); //국가의 수
        int K = Integer.parseInt(st1.nextToken()); //알고싶은 순위의 나라

        ArrayList<nations> arr = new ArrayList<>();

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int g = Integer.parseInt(st2.nextToken());
            int s = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            arr.add(new nations(g, s, b, a, 0));
        }

        Collections.sort(arr);
        
        arr.get(0).rate = 1; //정렬 후 0번째에 온 국가는 1등

        //순위 매겨주기
        for(int i = 1 ; i <= N ; i++) {
            nations now = arr.get(i);
            nations before = arr.get(i-1);

            if(now.gold == before.gold && now.silver == before.silver && now.bronze == before.bronze) {
                //금은동 숫자 같으면 동일순위
                now.rate = before.rate;
            }
            else{
                //아니라면 i+1 넣어주기
                now.rate = i+1;
            }

            if(now.index == K) {
                //원하는 index까지 오면 적어주고 끝내기
                bw.write(String.valueOf(now.rate));
                bw.flush();
                bw.close();
                break;
            }
        }




    }

    static class nations implements Comparable<nations>{
        int gold;
        int silver;
        int bronze;
        int index;
        int rate;

        public nations(int gold, int silver, int bronze, int index, int rate) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.index = index;
            this.rate = rate;
        }

        public int compareTo(nations n) { //내가 원래 이게(this) 더 크면 1 리턴(오름차순) 으로 외웠는데, 이건 이게 작으니 내림차순임
            if(n.gold == this.gold) {
                if(n.silver == this.silver) {
                    return n.bronze - this.bronze;
                }
                else {
                    return n.silver - this.silver;
                }
            }
            else {
                return n.gold - this.gold;
            }
        }
    }

}