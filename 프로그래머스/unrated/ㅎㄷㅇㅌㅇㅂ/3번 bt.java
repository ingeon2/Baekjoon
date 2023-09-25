import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<int[]>> arr;
    static int[] a = {0, 1, 2};
    static int[] selected = new int[3];
    static char[][] map;
    static int answer = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int R, C;

    static boolean[] v;
    static boolean[][] v1;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new ArrayList<>();
        for(int i = 0 ; i < 3 ; i++) {
            arr.add(new ArrayList<>());
        }

        v = new boolean[3];


        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        v1 = new boolean[R][C];
        map = new char[R][C];

        for(int r = 0 ; r < R ; r++) {
            map[r] = br.readLine().toCharArray();
            for(int c = 0 ; c < C ; c++) {
                if(map[r][c] == '1' || map[r][c] == '2' || map[r][c] == '3') {
                    arr.get(map[r][c] - '1').add(new int[] {r, c});
                }
            }
        }

        bt1(0);
        System.out.println(answer);
    }

    static void bt(int d, int cnt) {

        if(d == 3) {
            answer = Math.min(answer, cnt); //깊이 끝까지 도달하면 최솟값 로직
            return;
        }


        for(int i = 0 ; i < arr.get(selected[d]).size() ; i++) {
            int fr = arr.get(selected[d]).get(i)[0]; //각각 0, 1, 2가 끼워진 selected에서 i번째를 잡고 해당 점을 목표로 가기
            int fc = arr.get(selected[d]).get(i)[1];


            int dist = bfs(fr, fc); //해당 점까지의 거리, -1나오면 거기까지는 갈 수 없는것

            if(dist != -1) {
                char tmp = map[fr][fc];
                map[fr][fc] = 'X'; //도달 후 들어가기 전에 이제 해당 점 못들어가니까 X로 표시해주기
                bt(d+1, cnt + dist);
                map[fr][fc] = tmp; //다시 원상복구해주기
            }

        }

    }
    
    static int bfs(int fr, int fc) { //00부터 fr fc까지 최단구하기 만약 못가면 -1리턴
        v1 = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0});
        v1[0][0] = true;
        
        while(!q.isEmpty(기
            return;
        }

        for(int i = 0 ; i < 3 ; i++) {
            if(v[i]) continue;
            v[i] = true;
            selected[d] = a[i];
            bt1(d+1);
            v[i] = false;
        }
    }

    static boolean isValid(int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || map[r][c] == 'X' || v1[r][c]) return false;
        return true;
    }

}

//보통 최단거리 -> BFS하기 (bt + BFS 가능하니까)

//입력
//4 5
//...X3
//X...X
//X1..3
//12X.2

//출력 
//13
