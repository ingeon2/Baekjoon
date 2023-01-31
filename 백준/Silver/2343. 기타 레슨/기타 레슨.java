import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int[] arr = new int[N];
		
		int e = 0;
		int s = 0;
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
			e += arr[i];
			if(s < arr[i]) s = arr[i];
		}
		
		while(s <= e) {
			int m = (s+e)/2;
			
			int sum = 0;
			int split = 0;
			for(int i = 0 ; i < N ; i++) {
				if(sum + arr[i] > m) {
					sum = 0;
					split++;
				}
				sum += arr[i];
			}
			if(sum != 0) split++;
			
			if(split > M) s = m+1;
			else e = m-1;
		}
		
		bw.write(String.valueOf(s));
		bw.flush();
		bw.close();
		
	}
	
}