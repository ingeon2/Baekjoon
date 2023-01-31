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
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			Stack<Character> s = new  Stack<Character>();
			
			int num1 = 0; // ( 의 개수
			int num2 = 0; // ) 의 개수
			
			for(char c : str.toCharArray()) {
				
				if(c == '(') {
					s.push(c); // ( 일때 스택에 넣고
					num1++;
				}
				else {
					if(s.isEmpty()) {
						num2++;
					}
					else {
						s.pop(); // ) 일때 하나의 괄호 세트 완성, 스택에서 빼줌
						num2++;
					}
					
				}
				
				
				
			}
			if(s.isEmpty() && num1 == num2) { // 만약 ) 의 수가 ( 보다 많으면 옳지 않아도  스택이 비기때문에, ( 와 ) 의 개수는 같도록 한것이 num1 == num2
				bw.write("YES" + "\n");
			}
			else {
				bw.write("NO" + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		
	}
	

}