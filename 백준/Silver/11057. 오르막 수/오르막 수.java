import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static long d[][]; //d[i][j] 는 길이 i 마지막 수 j인 오르막 수 방법 가짓수를 의미
	public static int mod = 10007;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		d = new long[1001][10];
		
		bw.write(String.valueOf(methods(N)));
		bw.flush();
		bw.close();
	}
	
	public static long methods(int n) {
		
		for(int i = 0 ; i <= 9 ; i++) { 
			d[1][i] = 1; //길이 1 마지막수 i 만드는 방법은 전부 1가지씩임
		}
		
		for(int i = 2 ; i <= n ; i++) {
			for(int j = 0 ; j <= 9 ; j++) {
				
				int k = 0;
				while(k <= j) {
					d[i][j] += d[i-1][k]; //이게 핵심 (d[i][j]는 d[i-1][0]부터 d[i-1][j] 까지 로 밖에 못만듦, 오르막 수이기 때문)
					k++;				  // (ex) 1x3을 만드려면 103 113 123 뿐 (위의 주석과 비교해서 생각) 
				}
				d[i][j] = d[i][j]%mod;
				
			}
		}
		
		long ans = 0;
		for(int i = 0 ; i <= 9 ; i++) {
			ans += d[n][i]; //답은 길이 n의 오름수가 각각 0부터 9까지 끝나는 경우의 수의 합이니까.
		}
		
		return ans%mod;
	}
	
}