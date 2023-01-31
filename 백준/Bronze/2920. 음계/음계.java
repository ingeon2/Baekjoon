import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int[] array = new int[8];
		
		int i = 0;
		while(st.hasMoreTokens()) {
			array[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		String output = "";
		
		for(int j = 0 ; j < array.length - 1 ; j++ ) {
			
			if(array[j] == array[j+1] - 1) {
				output = "ascending";
			}
			else if(array[j] == array[j+1] + 1) {
				output = "descending";
			}
			else {
				output = "mixed";
				break;
			}
		}
		
		System.out.println(output);

		
		
	}
	
}
