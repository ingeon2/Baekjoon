import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int d = gcd(X, Y);
		System.out.println(d);
		System.out.println(X * Y / d);
	}

	public static int gcd(int a, int b) {
	
		while(b != 0) {
			int r = a%b;
			a = b;
			b = r;
		}
	
		return a;
	}
	

}