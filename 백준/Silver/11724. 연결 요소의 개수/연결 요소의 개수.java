import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean[] visited;
	public static ArrayList<Integer>[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for(int i = 1 ; i <= M ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			
			A[x].add(y);
			A[y].add(x);
		}
		//위가 전부 입력, 초깃값 설정
		
		int result = 0;
		for(int i = 1 ; i <= N ; i++) {
			if(visited[i] == false) {
				result++;
				DFS(i);
			}
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		
	}
	
	static void DFS(int v) {
		if(visited[v]) return;
		visited[v] = true;
		
		for(int a : A[v]) {
			if(visited[a] == false) {
				DFS(a);
			}
		}
	}
	
}