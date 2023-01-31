import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine(), " ");
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i = 1 ; i < arr.length ; i++) {
			for(int j = i-1 ; j >= 0 ; j--) {
				if(arr[j] > arr[j+1]) {
					int a = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = a;
				}
                else{
                    break;
                }
			}
		}
		
		int result = 0;
		
		for(int i = 0 ; i < arr.length ; i++) {
			result += (arr.length-i)*arr[i];
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		

	}

	
}