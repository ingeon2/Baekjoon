import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static int[] d;	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		d = new int[1001];
		
		bw.write(String.valueOf(tileling2(N)));
		bw.flush();
		bw.close();
		
	}
	
	public static int tileling2(int n) {
		d[1] = 1;
		d[2] = 3;
		
		for(int i = 3 ; i <= n ; i++) {
			d[i] = (d[i-1] + 2*d[i-2]) % 10007;  
		}
		
		return d[n];
	}
	
}