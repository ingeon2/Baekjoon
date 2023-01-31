import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static int[] arr, temp;
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		temp = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		merge_sort(0, N-1);
		
		for(int i = 0 ; i < N ; i++) {
			bw.write(String.valueOf(arr[i]) + "\n");
		}
		bw.flush();
		bw.close();
		
		
	}
	public static void merge_sort(int s, int e) { //머지소트 구현
		int m = (s + e)/2;
		if(e-s < 1) return;
		
		merge_sort(s, m);
		merge_sort(m+1, e);
		
		for(int i = s ; i <= e ; i++) {
			temp[i] = arr[i];
		}
		
		int k = s; //얘는 각각의 set 에서 s~e 순환할 친구
		int index1 = s;
		int index2 = m+1;
		
		while(index1 <= m && index2 <= e) {
			if(temp[index1] < temp[index2]) {
				arr[k] = temp[index1];
				index1++;
				k++;
			}
			else {
				arr[k] = temp[index2];
				index2++;
				k++;
			}
		}
		
		while(index1 <= m) {
			arr[k] = temp[index1];
			index1++;
			k++;
		}
		
		while(index2 <= e) {
			arr[k] = temp[index2];
			index2++;
			k++;
		}
	}
}