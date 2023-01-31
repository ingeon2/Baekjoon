import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] array = new int[26];
		
		for(int j = 0 ; j < 26 ; j++) {
			array[j] = -1;
		}
			
			
		for(int i = 0 ; i < str.length() ; i++) {
			if(array[(int)(str.charAt(i))-97] == -1) {
				array[(int)(str.charAt(i))-97] = i;
			}
		}
		
		for(int k = 0 ; k < 26 ; k++) {
			System.out.print(array[k] + " ");
		}
		
		
	}
	
}
