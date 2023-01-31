import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	public static int[] d;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());  
		d = new int[1001];
		bw.write(String.valueOf(tile(N)));
		bw.flush();
		bw.close();

	}
	
	public static int tile(int n) {
		d[1] = 1;
		d[2] = 2;
		for(int i  = 3 ; i < n+1 ; i++) {
			d[i] =((d[i-1] % 10007) + (d[i-2]% 10007)) % 10007;
		}
		return d[n];
	}

}

