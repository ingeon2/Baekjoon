import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> S = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		S.push(0);
		
		for(int i = 1 ; i < N ; i++) {
			while(!S.isEmpty() && arr[i] > arr[S.peek()]) {
				arr[S.pop()] = arr[i];
			}
			S.push(i);
		}
		
		while(!S.isEmpty()) {
			arr[S.pop()] = -1;
		}
		
		for(int i = 0 ; i < N ; i++) {
			bw.write(String.valueOf(arr[i]));
			if(i !=  N-1) {
				bw.write(" ");
			}
		}
		
		bw.flush();
		bw.close();
		

	}

	
}