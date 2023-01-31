import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> s = new Stack<Integer>();
		int m = 0;
		for(int a : arr) {
			if(a > m) {
				while( a != m ) {
					s.push(++m);
					sb.append("+" + "\n");
				}
				s.pop();
				sb.append("-" + "\n");
			}
			else if( a == s.peek() ) {
				s.pop();
				sb.append("-" + "\n");
			}
			else {
				System.out.println("NO");
				return;
			}
			
		}
		
		System.out.println(sb);

		
	}

	
}