import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	public static int[] a; //입력값
	public static int[] d; //아래 설명
	
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		a = new int[N+1];
		d = new int[N+1];
		
		for(int i = 1 ; i < N+1 ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(String.valueOf(consecutivePlus(N)));	
		bw.flush();
		bw.close();
		

	}
	public static int consecutivePlus(int n) {
		
		d[1] = a[1];
				
		for(int i = 2 ; i < n+1 ; i++) { 
										 
			if(d[i-1] < 0) {			 //여기 if 문은 연속해서 작아진다면(d[i-1]에서 a[i] 더했는데 작아진다면, 즉 d[i-1]이 음수라면) 그냥 연속 포기하고 a[i]값 그대로 넣자 라는 의미
                                         //이래도 되는 이유는,d[i]자체가 i만큼 갔을때의 부분합의 최대를 의미하는 것이 아니기 때문. d[i]중의 최댓값이 부분합의 최대이기 때문.
				d[i] = a[i];
			}
			else {
				d[i] = d[i-1] + a[i];
			}
		}
		
		
		int ans = a[1]; //여기서부턴 d[i] 의 최댓값
		for(int i = 2 ; i < n+1 ; i++) {
			if(d[i] > ans) {
				ans = d[i];
			}
		}
		
		return ans;
	} 
	
	
}