import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < T ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			if(N%H == 0) {
				
				if(N/H <= 9) {
					System.out.println((H) + "0" + (N/H) );
				}
				else {
					System.out.println((H) +""+ (N/H) );
				}
				
			}
			else {
				
				if(N/H < 9) {
					System.out.println((N%H) + "0" + (N/H + 1) );
				}
				else {
					System.out.println((N%H) +""+ (N/H + 1) );
				}
				
			}
			
			
			
		}
		
		
	}
	
}
