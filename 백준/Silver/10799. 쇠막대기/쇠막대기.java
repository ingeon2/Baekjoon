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
		
		String str = br.readLine(); //레이저로 쇠막대기 자르기
		int result = 0; //나중에 답낼놈
		char[] c = str.toCharArray(); //받아놓고 차어레이로 만들기
		Stack<Character> s = new Stack<Character>(); //스택 생성
		
		for(int i = 0 ; i < c.length ; i++) { //for(char c : str.toCharArray(); 할랬는데, 크기 1차이나는거 구현 생각하느라 이걸로함)
			
			if(c[i] == '(') { //  (이면 스택푸쉬
				s.push(c[i]);
			}
			else {
				if(c[i] == ')' && c[i-1] == '(') { // )이면서, 바로 이전게( 라면 레이저이므로 지금껏 만든 막대기들 개수만큼(s.size - 1) 결과에 더하기
					result += s.size() - 1;
					if(!s.isEmpty()) {s.pop();} //스택에서 하나 빼주기. ( 이전 ( 가 레이저이므로 )
				}
				else {
					result += 1; // )이면서, 바로 이전게( 이 아니라면 그냥 막대기의 끝을 의미하므로 막대 끝(1) 결과에 더하기 
					if(!s.isEmpty()) {s.pop();}//스택에서 하나 빼주기 ( 놓여있는 막대기 하나 사라진다는 뜻이므로 )
				}
			}
			
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		
	}
	
}