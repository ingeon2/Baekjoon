import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static long[][] p; //p[a][0],p[a][1] 각각 길이 a계단만드는데 마지막이 0,1인 갯수
	static long mod = 1000000000;
							 
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		p = new long[N+1][10];
		
		bw.write(String.valueOf(stairs(N)));
		bw.flush();
		bw.close();

	}
	
	public static long stairs(int n) {
		
		for(int i = 1 ; i < 10 ; i++) {
			p[1][i] = 1;
		}
		
		for(int i = 2 ; i < n+1 ; i++) {
			p[i][0] = p[i-1][1]; //0으로 마치는건 이전 마지막 수 1로 끝나는 얘들밖에 못만들지
			p[i][9] = p[i-1][8]; //9로 마치는건 이전 마지막 수 8로 끝나는 얘들밖에 못만들고.
			
			for(int j = 1 ; j <= 8 ; j++) { //위의 둘을 제외한 나머지 2부터 8까지는 아래의 식임.(이해하기)
				p[i][j] = (p[i-1][j-1] + p[i-1][j+1]) % mod;
			}
			
		}
		return (p[n][0] + p[n][1] + p[n][2] + p[n][3] + p[n][4] + p[n][5] + p[n][6] + p[n][7] + p[n][8] + p[n][9]) % mod;
		
	}
}