class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static boolean a;
    static char[][] room;
    
    public int[] solution(String[][] places) {
        int[] answer = {1, 1, 1, 1, 1};
        
        for(int i = 0 ; i < 5 ; i++) {
            room = new char[5][5];
            a = false;
            
            for(int j = 0 ; j < 5 ; j++) {
                room[j] = places[i][j].toCharArray();
            }
            
            for(int r = 0 ; r < 5 ; r++) {
                for(int c = 0 ; c < 5 ; c++) {
                    if(room[r][c] == 'P') {
                        visited = new boolean[5][5];
                        backTracking(0, r, c);
                    }
                    
                    if(a) {
                        answer[i] = 0;
                        break;
                    }
                }
                if(a) break;
            }
        }
        
        return answer;
    }
    
    
    static void backTracking(int depth, int r, int c) {
        
        if(depth == 2) return;
        
        visited[r][c] = true;
        
        for(int i = 0 ; i < 4 ; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visited[nr][nc]) continue;
            
            
            if(room[nr][nc] == 'P') {
                a = true;
                return;
            }
            else if(room[nr][nc] == 'O') {
                backTracking(depth+1, nr, nc);
            }
            else {
                continue;
            }
            
        }
    }
}