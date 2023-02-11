import java.io.*;
import java.util.*;

public class Main {
    static int [] represent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        //첫줄 N M, N은 그래프 점의 수, M은 들어올 연산의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //represent 배열 초깃값 설정 represent[i] = i 로
        represent = new int[N+1];
        for(int i = 1; i <= N ; i++){
            represent[i] = i;
        }

        //다음줄부터는 M번  0이면 파인드와 유니온, 1이면 대표노드가 같은지 여부 확인(대표노드가 같다면 연결되어있다는것이고, 같은집합이라는 것.)
        for(int i = 1 ; i <= M ; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st1.nextToken());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());


            if(x == 0){
                union(a, b);
            }
            else{ //1일때는 같은 집합인지 여부 파악. 즉, 대표노드가 같은지 파악하기. 대표노드 찾는 매서드가 find매서드.
                if(find(a) == find(b)) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();

    }

    //대표노드를 찾아주는 find 함수는 재귀로 구현. 얘 단순 찾기만하는게아니라 void처럼 represnt 바꿔주는 역할도 한다! (생각)
    static int find(int a){
        // 대표노드 찾는 기준이 뭐냐? represent[index] == index  || 여기선 index가 매서드 매개변수.
        if(represent[a] == a) return a;
        //★중요한것은 빠져나오며 값을 갱신해주는 것★
        // 찾는 로직 자체는 return find(represent[a]) 로 가능.
        //갱신은 represent[a] =  로 해주기.
        else return represent[a] = find(represent[a]);
    }

    //find 매서드를 통해 대표노드를 찾고 합집합을 구현하는 union 매서드 구현.
    // 대표노드 기준은 더 작은숫자!
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        int small_repre = 0;
        int large_repre = 0;

        if(a > b){
            large_repre = a;
            small_repre = b;
        }
        else if(a < b){
            large_repre = b;
            small_repre = a;
        }
        else{
            return;
        }
        represent[large_repre] = small_repre;
    }

}