import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		Stack<Integer> s = new Stack<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < N ; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a != 0) {
				s.push(a);
			}
			else {
				s.pop();
			}
		}
		
		int result = 0;
		if(s.isEmpty()) {
			result = 0;
		}
		else {
			while(!s.isEmpty()) {
				result += s.pop();
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
	
	
}

