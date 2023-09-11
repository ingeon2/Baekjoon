import java.util.*;
import java.io.*;


public class Main {
    static int[] red,green;
    static ArrayList<int[]> soil = new ArrayList<>();
    static int[][] visited;
    static int R,C;
    static int a,b; //전체 토양에서 a개 b개 뽑음
    static int[][] map;
    static int[][] time;
    static boolean[] v;
    static int answer = 0;

    static int[] dr = new int[] {-1, 1, 0, 0};
    static int[] dc = new int[] {0, 0, -1, 1};
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        red = new int[a];
        green = new int[b];

        map = new int[R][C];

        for(int r = 0 ; r < R ; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < C ; c++) {
                int n = Integer.parseInt(st.nextToken());
                map[r][c] = n;

                if(n == 2) {
                    soil.add(new int[] {r, c});
                }
            }
        }

        v = new boolean[soil.size()];

        bt1(0, soil.size(), 0);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }



    static void bt1(int depth, int n, int start) {
        if(depth == a) {
            bt2(0, n, 0);
            return;
        }

        for(int i = start ; i < n ; i++) {
            if(v[i]) continue;
            v[i] = true;
            red[depth] = i;
            bt1(depth+1, n, i+1);
            v[i] = false;
        }
    }


    static void bt2(int depth, int n, int start) {
        if(depth == b) {
            answer = Math.max(answer, BFS());
            return;
        }

        for(int i = start ; i < n ; i++) {
            if(v[i]) continue;
            v[i] = true;
            green[depth] = i;
            bt2(depth+1, n, i+1);
            v[i] = false;
        }
    }



    //red = 1, green = 2, flower = 3

    static int BFS() {
        Queue<Node> q = new LinkedList<>();
        visited = new int[R][C];
        time = new int[R][C];

        for(int i = 0 ; i < red.length ; i++) {
            int idx = red[i];
            q.add(new Node(soil.get(idx)[0], soil.get(idx)[1], 0, "R"));
            visited[soil.get(idx)[0]][soil.get(idx)[1]] = 1;
        }

        for(int i = 0 ; i < green.length ; i++) {
            int idx = green[i];
            q.add(new Node(soil.get(idx)[0], soil.get(idx)[1], 0, "G"));
            visited[soil.get(idx)[0]][soil.get(idx)[1]] = 2;
        }

        int flower = 0;

        while(!q.isEmpty()) {
            Node curN = q.poll();

            int r = curN.r;
            int c = curN.c;
            int cnt = curN.cnt;
            String type = curN.color;

            if(visited[r][c] == 3) continue;

            for(int i = 0 ; i < 4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];


                if(!isValid(nr, nc)) continue;

                if(visited[nr][nc] == 0) {
                    if(type.equals("R")) {
                        q.add(new Node(nr, nc, cnt+1, "R"));
                        visited[nr][nc] = 1;
                        time[nr][nc] = cnt+1;
                    }
                    else {
                        q.add(new Node(nr, nc, cnt+1, "G"));
                        visited[nr][nc] = 2;
                        time[nr][nc] = cnt+1;
                    }
                }
                else if(visited[nr][nc] == 2) {
                    if(visited[r][c] == 1 && time[nr][nc] == cnt+1) {
                        flower++;
                        visited[nr][nc] = 3;
                    }
                }
                else if(visited[nr][nc] == 1) {
                    if(visited[r][c] == 2 && time[nr][nc] == cnt+1) {
                        flower++;
                        visited[nr][nc] = 3;
                    }
                }

            }


        }
        return flower;
    }

    static boolean isValid(int r, int c) {
        if(r < 0 || r >= R || c < 0 || c >= C || map[r][c] == 0) return false;
        return true;
    }



    static class Node {
        int r, c, cnt;
        String color;

        public Node(int r, int c, int cnt, String color) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.color = color;
        }
    }

}