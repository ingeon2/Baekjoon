import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long[] d = new long[1000001]; //왜 이숫자일까? → 문제에서 주어진 n의 범위
		long mod = 1000000009;
		
		int N = Integer.parseInt(br.readLine());
		
		d[0] = 0;
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		
		for(int i = 4 ; i < 1000001 ; i++) { //매소드로 안만들고 여기서 하는 이유 생각 → 매소드로 매번 출력값 구하는것보다 한번 구해놓고 입력하면 더 효율적
			d[i] = (d[i-1] + d[i-2] + d[i-3]) % mod; 
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			bw.write(String.valueOf(d[Integer.parseInt(br.readLine())]) + "\n"); //이거 이해되냐? d[입력값] 이 long 형이라 String.valueOf 한 다음
																				 // write 해주는거
		}
		
		bw.flush();
		bw.close();
	}

}