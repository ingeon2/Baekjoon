import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	public static boolean[] p; //p 안에서 트루이면 소수 아니고, 폴스이면 소수임
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		p = new boolean[B+1];
		
		prime(); // 함수 실행
		for(int i = A ; i < p.length ; i++) {
			if(p[i] == false) { //p[i]가 폴스이면 = i가 소수이면
				bw.write(String.valueOf(i) + "\n");
			}
		}
		
		bw.flush();
		bw.close();

	}
	
	public static void prime() {
		p[0] = true;
		p[1] = true;
		
		for(int i = 2 ; i <= Math.sqrt(p.length) ; i++) { //에라토스체네의 체 2의배수,3의배수,.....,길이의 제곱근보다 작거나 같은 수의 배수까지 제거 = (트루로 바꿔줌)
			if(p[i] == true) continue; //이미 트루인건(이미 소수로 제껴버린것들) 넘어가고
			
			for(int j = i*i ; j < p.length ; j+=i) { //배수들 제거하는 for문
				p[j] = true;
			}
		}
	}
}