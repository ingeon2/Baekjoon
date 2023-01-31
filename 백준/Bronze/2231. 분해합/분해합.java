import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int N = Integer.parseInt(str);
		
		for(int i = 0 ; i <= N ; i++) {
			
			String istr = Integer.toString(i);
			String[] array = istr.split("");
			int sum = 0;
			
			for(int j = 0 ; j < array.length ; j++) {
				sum += Integer.parseInt(array[j]);
			}
			
			if(i + sum == N) {
				System.out.println(i);
				break;
			}
            else if(i == N) {
				System.out.println(0);
			}
			
		}
		
	}
	
}
