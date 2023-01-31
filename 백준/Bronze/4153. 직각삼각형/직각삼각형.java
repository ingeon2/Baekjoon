import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] array = new int[3];
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			
			int i = 0;
			while(st.hasMoreTokens()) {
				array[i] = Integer.parseInt(st.nextToken());
				i++;
			}
			
			if((array[0]*array[0]) + (array[1]*array[1]) + (array[2]*array[2]) == 0) break;
			
			Arrays.sort(array);
			
			if((array[2]*array[2]) == ( (array[0]*array[0]) + array[1]*array[1]) ) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
		}
		
	}
	
}
