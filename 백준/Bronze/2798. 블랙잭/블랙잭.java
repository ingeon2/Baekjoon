import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] arr = new int[N]; 
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int a = 0;
		while(st2.hasMoreTokens()) {
			arr[a] = Integer.parseInt(st2.nextToken());
			a++;
		}
		
		int max = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			
			for(int j = 0 ; j < arr.length ; j++) {
				
				if(i == j)continue;
				
				for(int k = 0 ; k < arr.length ; k++) {
					
					if(j == k || i == k) continue;
					
					if( (arr[i] + arr[j] + arr[k]) > max && X >= arr[i] + arr[j] + arr[k] ) {
						max = arr[i] + arr[j] + arr[k];
					}
					
				}
				
			}
			
		}
		
		System.out.println(max);
		
		
	}
	
}
