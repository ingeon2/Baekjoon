import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int x = ((X%10) * 100) + ((X%100)-(X%10)) + (X/100);
		int y = ((Y%10) * 100) + ((Y%100)-(Y%10)) + (Y/100);
		
		int max = x > y ? x : y ;
		
		System.out.println(max);
		
			
	}
	
}
