import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int N = Integer.parseInt(br.readLine());
		
		for(int j = 0 ; j < N ; j++) {
			System.out.println(N - j);
		}
		
	}
	
}
