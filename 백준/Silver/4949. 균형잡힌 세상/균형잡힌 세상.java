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
		
		String str = "";
		while(!(str = br.readLine()).equals(".")) { //EOF 통째로 외우기
			bw.write(balance(str) + "\n");
		}
		bw.flush();
		bw.close();
		
	}
	
	public static String balance(String str) {
		Stack<Character> s = new Stack<Character>();
		for(char c : str.toCharArray()) {
			if(c == '(' || c == '[') { //괄호시작하면 스택에 투입
				s.push(c);
			}
			else if(c == ')') { // ) 일때
				if(s.isEmpty() || s.peek() != '(') { //스택이비어있거나  스택에서 꺼낸게 )랑 세트인 ( 아니면
					return "no"; //노 리턴
				}
				else { //아니라면
					s.pop(); //세트 맞는다는 뜻이므로 스택에서 하나 제거
				}
			}
			else if(c == ']') {
				if(s.isEmpty() || s.peek() != '[') {
					return "no";
				}
				else {
					s.pop();
				}
			}
			
			
			/*else if(!s.isEmpty()) { //스택 안비어있을때
				if(c == ')' && s.peek() == '(') { // 스택 맨위 ( 이고 문자가 ) 이면 스택에서 꺼내라
					s.pop();
				}
				else if(c == ']' && s.peek() == '[') { // 스택 맨위 [ 이고 문자가 ] 이면 스택에서 꺼내라
					s.pop();
				}
				
			}*/
			
			else { //다른 문자이면 그냥 for문 계속하기
				continue;
			}
			
		}
		if(s.isEmpty()) {
			return "yes";
		}
		else {
			return "no";
		}
	
	}
}