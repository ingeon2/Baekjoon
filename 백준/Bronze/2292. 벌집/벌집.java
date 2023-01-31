import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int N = Integer.parseInt(str);
		
		int sum = 0;
		int i = 0;
		
		if(N == 1) {
			System.out.println(1);
		}
		else {
			for( ; ; ) {
				sum += i;
				if(N <= (6 * sum) + 1) break;
				i++;
			}
			System.out.println(i + 1);
		}
		
		
		
	}
	
}
