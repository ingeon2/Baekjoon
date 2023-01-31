import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int t = 0;
		while(st.hasMoreTokens()) {
			array[t] = Integer.parseInt(st.nextToken());
			t++;
		}
		
		int numsofsosu = 0; // 소수의 수
		
		for(int j = 0 ; j < array.length ; j++) {
			int count = 0; //배열 안의 숫자의 약수의 개수
			for(int i = 1 ; i <= array[j] ; i++) {
				if(array[j]%i == 0) {
					count++;
				}
			}
			if(count == 2) {
				numsofsosu++;
			}
			
		}
		
		bw.write(String.valueOf(numsofsosu));
		bw.flush();
		bw.close();
		
	}

}
