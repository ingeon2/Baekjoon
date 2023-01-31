import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int[] arr = new int[S.length()];
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = Integer.parseInt(S.substring(i, i+1));
		}
		
		for(int i = 0 ; i < arr.length ; i++) {
			int max_index = i; //초기값은 인덱스 i일때가 arr값 최대니깐.
			for(int j = i+1 ; j < arr.length ; j++) {
				if(arr[j] > arr[max_index]) {
					max_index = j;
				}
			}
			int a = arr[i];
			arr[i] = arr[max_index];
			arr[max_index] = a;
		}
		
		for(int i = 0 ; i < arr.length ; i++) {
			bw.write(String.valueOf(arr[i]));
		}
		bw.flush();
		bw.close();
		

	}

	
}