import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		String str = br.readLine();
		
		str = str.trim();
		
		String strarray[] = str.split(" ");
		
		if(str.isEmpty()) {
			System.out.println(0);
		}
		else {
			System.out.println(strarray.length);
		}
		
		
		
			
	}
	
}
