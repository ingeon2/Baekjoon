import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	public static long[][] d; //d[i][j] = i를 j개의 정수의 합으로 나타낼수 있는 방법의 수
	public static long mod = 1000000000; 
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		d= new long[201][201];

		bw.write(String.valueOf(sumdecomposition(N, K)));
		bw.flush();
		bw.close();

	}
	
	public static long sumdecomposition(int N, int K) {
		for(int i = 0 ; i < N+1 ; i++) {
			d[i][0] = 0; //i를 0개의 정수의 합으로 표현하려면 방법이 없어서 0임
			d[i][1] = 1; //i를 하나의 정수의 합으로 표현하려면 i 하나 뿐이라서 d[i][1] = 1
		}
		
		for(int i = 0 ; i < N+1 ; i++) {
			for(int j = 2 ; j < K+1 ; j++) {
				
				
				for(int k = 0 ; k <= i ; k++) {
					d[i][j] += d[i-k][j-1]; //이게 핵심. d[i][j]는 d[0][j-1] ..... d[i][j-1]의 합임 
											//(j-1개의 수에서 위에서 순서대로 각각 i, i-1, ... , 1, 0 더하면 d[i][j]될 수 있거든요)
				}
				
				d[i][j] = d[i][j]%mod;
			}
		}
		
		return d[N][K];
	}
	
}