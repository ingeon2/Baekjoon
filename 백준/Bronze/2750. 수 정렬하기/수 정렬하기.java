import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		
		for(int i = 0 ; i < arr.length-1 ; i++) {
			for(int j = 0 ; j < arr.length-i-1 ; j++) {
				if(arr[j] <= arr[j+1]) {
					continue;
				}
				else {
					int a = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = a;
				}
			}
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			bw.write(String.valueOf(arr[i]) + "\n");
		}
		
		bw.flush();
		bw.close();
	}

	
}