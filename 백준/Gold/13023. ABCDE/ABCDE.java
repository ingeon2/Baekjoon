import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static boolean arrive;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		visited = new boolean[N];
		A = new ArrayList[N];
		
		
		for(int i = 0 ; i < N ; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i= 0 ; i < M ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			A[a].add(b);
			A[b].add(a);
			
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			
			if(visited[i] == false) {
				DFS(i, 1);
			}
			if(arrive) break;
		}
		
		if(arrive) {
			bw.write(String.valueOf(1));
		}
		else {
			bw.write(String.valueOf(0));
		}
		bw.flush();
		bw.close();
		
		//얼마나깊은지
	}
	static void DFS(int num_person, int depth) {
		if(depth == 5||arrive) {
			arrive = true;
			return;
		}
		visited[num_person] = true;
		
		
		for(int a : A[num_person]) {
			if(!visited[a]) {
				DFS(a, depth + 1);
			}
		}
		
		visited[num_person] = false; 
		//들어갔다 나오면서 false 해야 깊이만 탐색 가능.
		/*예를 들어 1 - 2, 3 ㅁ 2 - x ㅁ 3 - 4 ㅁ 4- 5 ㅁ 5 - 6 생각.
		 * 만약 1에서 2가고 다시 탐색시작하면 1이 true라서 안된다면  3 4 5 6 으로 정답 맞음에도 불구하고 정답쳐리가 안됨.*/
		
	}
	
}