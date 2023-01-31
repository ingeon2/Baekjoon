import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		bw.write(String.valueOf(Least(N)));
		bw.flush();
		bw.close();
		
	}
	
	public static int Least(int n) {
		arr[1] = 0;
		
		for(int i = 2 ; i < n+1 ; i++) {
			arr[i] = arr[i-1] + 1;
			
			if(i%2==0 && arr[i] > arr[i/2] + 1) {
				arr[i] = arr[i/2] + 1;
			}
			if(i%3==0 && arr[i] > arr[i/3] + 1) {
				arr[i] = arr[i/3] + 1;
			}
		}
		return arr[n];
	}

}


