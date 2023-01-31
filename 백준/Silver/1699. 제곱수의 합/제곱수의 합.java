import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static int[] d; //아래 설명
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		d = new int[100001];
		
		
		
		bw.write(String.valueOf(squareSum(N)));	
		bw.flush();
		bw.close();
		

	}
	public static int squareSum (int n) {
		d[1] = 1;
		d[2] = 2;
		d[3] = 3;
		for(int i = 2 ; i < n+1 ; i++) {
			int min = d[i - 1*1]; // d[i-1], d[i-4], d[i-9], d[i-16]..... 이런식으로 제곱수가 i보다 작을때까지 min값 업데이트 하는 것. 
			for(int j = 2 ; j * j <= i ; j++) {
				if(d[i - j*j] < min) {
					min = d[i - j*j];
				}
				d[i] = min + 1; //+1은 j*j 제곱수 하나때문에 해주는 값.
			}
		}
		
		return d[n];
	} 
	
	
}//d[i] = min(d[i-1], d[i-4], d[i-9], .... , d[i-아이 제곱근 이하 정수의 제곱까지])