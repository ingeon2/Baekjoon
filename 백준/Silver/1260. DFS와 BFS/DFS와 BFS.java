import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] A;
	static boolean[] visited1, visited2;
	static BufferedWriter bw1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int start = Integer.parseInt(st1.nextToken());
		
		visited1 = new boolean[N+1];
		visited2 = new boolean[N+1];
		
		bw1 = new BufferedWriter(new OutputStreamWriter(System.out));
		
		A = new ArrayList[N+1];
		for(int i = 1 ; i <= N ; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i < M ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			A[a].add(b);
			A[b].add(a);
		}
        
        for(int i = 1 ; i <= N ; i++) {
			Collections.sort(A[i]);
		}
		
		DFS(start);
		bw1.write("\n");
		BFS(start);
		
		bw1.flush();
		bw1.close();

	}
	
	static void DFS(int n) throws IOException {
		if(visited1[n])return;
		visited1[n] = true;
		bw1.write(String.valueOf(n) + " ");
		
		for(int i : A[n]) {
			if(visited1[i] == false) {
				DFS(i);
			}
		}
		
	}
	
	static void BFS(int n) throws IOException {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited2[n] = true;
		
		while(!q.isEmpty()) {
			int a = q.poll();
			bw1.write(String.valueOf(a) + " ");
			
			for(int i : A[a]) {
				if(!visited2[i]) {
					q.add(i);
					visited2[i] = true;
				}
			}
			
		}
	}
	
	
}