import java.util.*;
import java.io.*;


public class Main {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static ArrayList<Integer> answerList = new ArrayList<>();
    static int[] arr;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        A = new ArrayList[101];

        for(int i = 1 ; i <= 100 ; i++) {
            A[i] = new ArrayList<>();
        }
        arr = new int[101];

        for(int i = 1 ; i <= N ; i++) {
            int a = Integer.parseInt(br.readLine());
            A[i].add(a);
            arr[i] = a;
        }

//        int answer = 0;
//        boolean[] check = new boolean[101];
//        for(int i = 1 ; i <= N ; i++) {
//            if(comeback(i)) {
//                answer++;
//                check[i] = true;
//            }
//        }
//
//        bw.write(String.valueOf(answer) + "\n");
//
//        for(int i = 1 ; i <= 100 ; i++) {
//            if(check[i]) bw.write(String.valueOf(i) + "\n");
//        }

        visited = new boolean[101];
        for(int i = 1 ; i <= N ; i++) {
            visited[i] = true;
            DFS(i, arr[i]);
            visited[i] = false;
        }
        bw.write(String.valueOf(answerList.size()) + "\n");
        for(int i = 0 ; i < answerList.size() ; i++) {
            bw.write(String.valueOf(answerList.get(i)) + "\n");
        }
        bw.flush();
        bw.close();

    }


    static boolean comeback(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited = new boolean[101];
        int times = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            //start가 두번 나와야함
            if(cur == start) {
                times++;
                if(times == 2) return true;
            }

            for(int next : A[cur]) {
                if(visited[next]) continue;
                visited[next] = true;
                q.add(next);
            }
        }

        return false;
    }

    static void DFS(int start, int next) { //next = arr[start]
        if(start == arr[next]) {
            answerList.add(start);
            return;
        }

        if(!visited[arr[next]]) {
            visited[arr[next]] = true;
            DFS(start, arr[next]);
            visited[arr[next]] = false;
        }
    }

}