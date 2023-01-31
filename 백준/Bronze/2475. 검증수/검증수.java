import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int[] array = new int[5];
		
		int i = 0;
		while(st.hasMoreTokens()) {
			array[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		int b = 0;
		int sum = 0;
		for(int j = 0 ; j < 5 ; j++){
			b = array[j] * array[j] ;
			sum += b;
		}
		
		System.out.println(sum%10);
		
		
	}
	
}
