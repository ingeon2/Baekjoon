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
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			String str = br.readLine() + "\n";
			Stack<Character> s = new Stack<Character>();
			
			for(char c : str.toCharArray()) {
				if(c == ' '|| c == '\n') {
					while(!s.isEmpty()) {
						bw.write(s.pop());
					}
					bw.write(c);
				}
				
				else {
					s.push(c);
				}
				
			}
			
		}
		
		bw.flush();
		bw.close();
		
	}

}
