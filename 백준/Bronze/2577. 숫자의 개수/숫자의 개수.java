import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		String[] strarray = String.valueOf(A * B * C).split("");
		
		for(int i = 0 ; i < 10 ; i++) {
			int count = 0;
			for(int j = 0 ; j < strarray.length ; j++) {
				if(Integer.parseInt(strarray[j]) == i) {
					count++;
				}
			}
			System.out.println(count);
		}
		
			
	}
	
}
