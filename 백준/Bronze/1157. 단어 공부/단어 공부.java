import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		String str = br.readLine();
		
		int[] intarray = new int[26];
		
		for(int i = 0 ; i < str.length() ; i++) {
			if((int)str.charAt(i) > 96) {
				intarray[(int)str.charAt(i) - 97]++;
			}
			else {
				intarray[(int)str.charAt(i) - 65]++;
			}
		}
		
		int max = -1;
		char result = '?';
		
		for(int i = 0 ; i < 26 ; i++) {
			if(intarray[i] > max) {
				max = intarray[i];
				result = (char)(i + 65);
			}
			else if(max == intarray[i]) {
				result = '?';
			}
		}
		
		System.out.println(result);
			
	}
	
}
