import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;


public class Main {
	
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		arr = new int[11];
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			bw.write(String.valueOf(plus123(Integer.parseInt(br.readLine()))) + "\n");
		}
		bw.flush();
		bw.close();
		

	}
	
	public static int plus123(int n) {
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		for(int i = 4 ; i < 11 ; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];//점화식 핵심.
            //1,2,3 더하기이기 때문에 세번째까지. 각각에 곱하기 상수가 없는 이유는 타일링과 연결해서 생각해보기
		}
		
		return arr[n];
	}
	

}

