import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	public static int[] a; // 얘는 입력값 넣어줄것
	public static int[] d; // 얘는 (LIS)출력값 넣어줄것
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		a = new int[N];
		d = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		
		bw.write(String.valueOf(LIS(N)));
		bw.flush();
		bw.close();
		

	}
	
	public static int LIS(int n) { //가장 긴 증가하는 부분수열
		
		for(int i = 0 ; i < n ; i++) {
			d[i] = 1;
			for(int j = 0 ; j < i ; j++) {
				if(a[i] > a[j] && d[i] < d[j] + 1) { //최댓값 만드는 if  a → 값 자체가 더 커야하고,d → j의 LIS 값에 1을 더한것(다음 값) 보다 작아야함(최댓값 위해)
					d[i] = d[j] + 1;
				}
			}
		}
		int ans = d[0]; //이건 꼭 d[n] 이 최댓값이란 법 없지 ex) a 배열이 10 20 30 10
		for(int i = 1 ; i < n ; i++) {
			if(ans < d[i]) {
				ans = d[i];
			}
		}
		
		return ans;
	}
	
}