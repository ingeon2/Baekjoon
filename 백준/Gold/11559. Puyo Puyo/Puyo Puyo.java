import java.io.*;
import java.util.*;

public class Main {
    //앞뒤양옆 (상하좌우)
    static int[] dr = { 1, 0, 0};
    static int[] dc = {0, -1, 1};
    //map, 방문가능한지 여부 boolean(캔낫 비지티드, 불이든 벽이든 통과못하는건 마찬가지이니)
    static String[][] map;

    //방문여부체크(BFS 돌고 나서 초기화 해야지, 한번 뿌요 터지고 다시 방문 가능하니)
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //초깃값 설정
        map = new String[12][6];
        visited = new boolean[12][6];
        //입력값 map 기록
        for(int i = 0 ; i < 12 ; i++) {
            String S = br.readLine();
            for(int j = 0 ; j < 6 ; j++) {
                map[i][j] = S.substring(j, j+1);
            }
        }

        int answer = 0;


        //터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가
        while(true) {
            //갯수 세주며 조건만족하면 ㄱㄱ
            int nums = 0;
            visited = new boolean[12][6];

            for(int i = 0 ; i < 12 ; i++) {
                for(int j = 0 ; j < 6 ; j++) {


                    //visited가 nums_puyo로 변하기 전에 기록해놓기
                    if(visited[i][j] == false && pop(i, j)) { //방문안햇고 드갓는데 크기 4이상이라면
                        //갯수만족하면 nums++, 맵 바꿔주기()
                        nums++;
                    }


                }
            }

            if(nums == 0){
                break;
            }
            else {
                answer ++;
                change_map();
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }



    //몇개 터지는지 갯수세고, 터지는놈들 visited true, map은 . 으로 만들어주는 static 매서드
    static boolean pop(int r, int c) {
        boolean pop = false;
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> how_many = new ArrayList<>();

        String a = map[r][c];

        //맵에서 . 아니면 갯수새주기 (BFS로직)
        if(!a.equals(".")) {
            q.add(new int [] {r, c});
            how_many.add(new int[] {r, c});
            visited[r][c] = true;
            while(!q.isEmpty()) {
                int[] arr = q.poll();
                for(int k = 0 ; k < 3 ; k++) { //하 좌 우 탐색이다. 상은 필요없어
                    int nr = arr[0] + dr[k];
                    int nc = arr[1] + dc[k];

                    //인덱스 맞고 알파벳 같고 방문안햇스면 방문체크 후 숫자올려주고 다시큐ㅜ]에넣기
                    if(nr < 12 && nc < 6 && nc >= 0 && map[nr][nc].equals(a) && visited[nr][nc] == false) {
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                        how_many.add(new int[] {nr, nc});
                    }
                }
            }
            
            //while문 끝나고 나서
            if(how_many.size() >= 4) { //어레이리스트 크기가 4이상이면 트루이고, 맵 바꿔주기
                for(int i = 0 ; i < how_many.size() ; i++) {
                    map[how_many.get(i)[0]][how_many.get(i)[1]] = ".";
                    pop = true;
                }
            }
            else { //4이하라면 폴스리턴 끝
                pop = false;
            }

        }
        return pop;
    }

    //비지티드 트루이면 맵 바꿔주는 로직
    static void change_map() {

        //여기는 열마다 돌면서 뿌요뿌요 내려주는 로직
        for(int j = 0 ; j < 6 ; j++) {
            String S = "";
            for(int i = 0 ; i < 12 ; i++) {
                S += map[i][j];
            }

            S = S.replace(".", "");

            while(S.length() != 12) {
                S = "." + S;
            }

            for(int k = 0 ; k < 12 ; k++) {
                map[k][j] = S.substring(k, k+1);
            }
        }

    }

}