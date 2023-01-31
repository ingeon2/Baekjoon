import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		int sum = 0;
		for(int i = 0 ; i < str.length() ; i++) {
			 sum += ( (int)str.charAt(i) - 96 ) * Math.pow(31, i);
		}
		
		System.out.print(sum);
		
		
	}
	
}
