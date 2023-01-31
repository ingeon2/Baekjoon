import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	

		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long [][] d = new long[100001][4];
		d[1][1] = 1;
		d[1][2] = 0;
		d[1][3] = 0;
		
		d[2][1] = 0;
		d[2][2] = 1;
		d[2][3] = 0;
		
		d[3][1] = 1;
		d[3][2] = 1;
		d[3][3] = 1;
		
		for(int i = 4 ; i < 100001 ; i++) { //d[i][j] = i를 맨 마지막엔 j를 더하고, 1,2,3을 더해서 만드는 방법   (ex) 1+2+1 = 4 → d[4][1]에 들어감
			d[i][1] = (d[i-1][2] + d[i-1][3]) % 1000000009; 
			d[i][2] = (d[i-2][1] + d[i-2][3]) % 1000000009; 
			d[i][3] = (d[i-3][1] + d[i-3][2]) % 1000000009; 
		}

		int N = Integer.parseInt(br.readLine());
		while(N-- > 0) {
			int a = Integer.parseInt(br.readLine());
			long result = (d[a][1] + d[a][2] + d[a][3]) % 1000000009;
			bw.write(String.valueOf(result) + "\n");
		}
		bw.flush();
		bw.close();
		
		
	}
	
}