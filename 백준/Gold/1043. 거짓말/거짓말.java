import java.io.*;
import java.util.*;

public class Main {
    static int[] repre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //첫째 줄 사람수 N 파티 수 M
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());



        //둘째 줄 0 아니면 진실 아는 사람 수, 그 사람들의 번호 이런식으로 나옴, repre 초기화
        int trueperson = 0;
        repre = new int[N+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st2.nextToken()); //둘째줄의 첫 숫자
        //둘째줄이 0일때 그냥 M 출력
        if(a == 0) {

        }
        //0이 아닐때는
        else {
            //repre 대표노드로 초기화 해준 후 첫번째 숫자 딴걸로(a) for문 돌리고, 두번째 숫자를 standard로 가져간 후, 대표노드
            for(int i = 1 ; i <= N ; i++) {
                repre[i] = i;
            }

            if(a != 1) { //a가 1이 아니라면 처음 나온 숫자 standard로 진실 친구들의 대표노드 바꿔준다
                int standard = Integer.parseInt(st2.nextToken());
                trueperson = standard;
                for(int i = 1 ; i <= a-1 ; i++) {
                    repre[Integer.parseInt(st2.nextToken())] = standard;
                }
            }
            else { //1이라면 대표노드 작성해준 처음 repre 값으로 하고, standard 기록만 한다.
                int standard = Integer.parseInt(st2.nextToken());
                trueperson = standard;
            }
            
        }


        //어레이리스트 초기화
        ArrayList<Integer>[] A = new ArrayList[M+1];
        for(int i = 1 ; i <= M ; i++) {
            A[i] = new ArrayList<Integer>();
        }


        //이제 셋째줄부터 M개의 줄은 첫숫자 명수 두번쨰 숫자부터 파티 참여 인원. 이렇게 된다. (어레이리스트에 파티 대입하고 union까지 해주는것)
        //첫숫자(b)가 1이면 컨티 하고 (같은 대표노드로 묶어주려면 숫자는 최소 두개 이상), 1 아니면 첫숫자 뽑아서 잡고 나머지들 다 union 해준다.
        for(int i = 1 ; i <= M ; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st3.nextToken());
            if(b == 1) {
                A[i].add(Integer.parseInt(st3.nextToken()));
                continue;
            }
            else {
                int c = Integer.parseInt(st3.nextToken());
                A[i].add(c);
                for(int j = 1 ; j <= b-1 ; j++) {
                    int d = Integer.parseInt(st3.nextToken());
                    A[i].add(d);
                    union(c, d);
                }
            }
        }

        //파티 인원들까지 마무리되면, 어레이리스트 돌면서, 걔들 첫번째 잡아서 그친구의 대표노드가 trueperson의 대표노드와 같은지 보기.
        int answer = 0;
        for(int i = 1 ; i <= M ; i++) {
            if(find(A[i].get(0)) != find(trueperson)) answer++;
        }

        if(a == 0) {
            bw.write(String.valueOf(M));
        }
        else{
            bw.write(String.valueOf(answer));
        }

        bw.flush();
        bw.close();


    }

        

    //대표노드 찾아서 리턴해주며 빠져나오며 거쳐온 친구들의 대표노드도 갱신해주는 find
    static int find(int a) {
        if(repre[a] == a) return a;
        else return repre[a] = find(repre[a]);
    }

    //대표노드를 찾아 서로 연결시켜주는 union (작은 노드를 대표노드로 생각.)
    static void union(int a, int b) {
        int small = Math.min(find(a), find(b));
        int large = Math.max(find(a), find(b));

        repre[large] = small;
    }

}