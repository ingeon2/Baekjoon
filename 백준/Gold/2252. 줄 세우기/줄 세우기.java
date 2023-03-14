import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //첫줄에 N명, M개의 비교.
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        //배열 D 여기에는 index 앞에 몇개가 선행되어야 한다 라는 배열. arrayList만들 때 ++해주고, 큐 추가할때 --

        int[] D = new int[N+1];
        //arrayList
        ArrayList<Integer>[] A = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<Integer>();
        }

        //M개의 비교에선 처음나온친구가 뒤에나온친구보다 선행되어야 한다는 뜻.
        //뒤에 나온 친구를 arrayList에 넣어주고 D++해주기
        for(int i = 1 ; i <= M ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            A[a].add(b); //어레이리스트에 추가
            D[b]++; //D에 앞에 몇개 나와야하는지 추가
        }


        

        //Queue 만들고 D값 0인친구들 q에 넣기
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++) {
            if(D[i] == 0)q.add(i);
        }
        
        //q가 빌때까지
        while(!q.isEmpty()) {
            //q에서 하나씩 빼며 bw.write 하고 뺀놈의 친구들(list) D--하는데 0이라면 Queue에 다시 넣기
            int a = q.poll();
            bw.write(String.valueOf(a) + " ");
            for(int a_friends : A[a]) {
                D[a_friends]--;
                if(D[a_friends] == 0)q.add(a_friends);
            }
        }


        bw.flush();
        bw.close();
        //마치면 bw출력
    }

}