import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int N;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
		
		
		bw.flush();
		bw.close();
		
	}
	
	static void DFS(int num, int jari) throws IOException { //이게 핵심
		if(jari == N) {
			if(isprime(num)) {
				System.out.println(num);
			}
			return;
		}
		
		for(int i = 1 ; i < 10 ; i++) {
			if(i%2 == 0) {
				continue;
			}
			
			if(isprime(num*10 + i)) {
				DFS(num*10 + i, jari+1);
			}
			
		}
	}
	
	
	
	
	static boolean isprime(int n) { //소수구하는 매서드
		
		boolean result = true;
		for(int i = 2 ; i * i <= n ; i++) {
			if(n%i == 0) {
				result = false;
				break;
			}
		}
		return result;
	}
	
}