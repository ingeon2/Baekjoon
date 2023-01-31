import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] x_friend = {-1, 1, 0, 0};
	static int[] y_friend = {0, 0, -1, 1};
	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static int M;
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				arr[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		
		BFS(0,0);
		
		bw.write(String.valueOf(arr[N-1][M-1]));
		bw.flush();
		bw.close();
		
		
		
	}
	public static void BFS(int a, int b) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] first = {a, b};
		visited[a][b] = true;
		q.add(first);
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i = 0 ; i < 4 ; i++) {
				int x = now[0] + x_friend[i];
				int y = now[1] + y_friend[i];
				
				if(x >= 0 && y >= 0 && x < N && y < M && visited[x][y] == false && arr[x][y] != 0) { //친구 될(BFS 다음단계 넘어갈) 6가지 조건
					int[] friend_now = {x, y}; 
					q.add(friend_now);
					visited[x][y] = true; //방문했다고 기록 남기고
					arr[x][y] = arr[now[0]][now[1]] +1; //이전단계보다 1씩 더해주고
				}
			}
		}
	}

	
}