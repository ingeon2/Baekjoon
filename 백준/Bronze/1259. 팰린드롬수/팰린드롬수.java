import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			if(Integer.parseInt(str) == 0) break;
			
			String[] arr1 = str.split("");
			String[] arr2 = new String[arr1.length];
			
			for(int i = 0 ; i <= str.length() - 1 ; i++) {
				arr2[i] = arr1[str.length() - (i+1)];
			}
			

			
			
			
			
			String result = "";
			for(int j = 0 ; j < str.length() ; j++) {
				if(Integer.parseInt(arr1[j]) == Integer.parseInt(arr2[j])) {
					result = "yes";
				}
				else {
					result = "no";
					break;
				}	
				
			}
			
			System.out.println(result); 
		}
		
		
		
		
	}
	
}