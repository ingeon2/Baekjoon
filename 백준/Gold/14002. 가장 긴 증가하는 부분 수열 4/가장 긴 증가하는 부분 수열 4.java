import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	public static int[] a; // 얘는 입력값 넣어줄것
	public static int[] d; // 얘는 (LIS)출력값 넣어줄것
	public static int[] v; // 얘는 역추적 수 넣어줄것
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		a = new int[N];
		d = new int[N];
		v = new int[N];
	
		for(int i = 0 ; i < N ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0 ; i < N ; i++) {
			d[i] = 1;
			v[i] = -1;
			for(int j = 0 ; j < i ; j++) {
				if(a[i] > a[j] && d[i] < d[j] + 1) { //최댓값 만드는 if  a → 값 자체가 더 커야하고,d → j의 LIS 값에 1을 더한것(다음 값) 보다 작아야함(최댓값 위해)
					d[i] = d[j] + 1;
					v[i] = j; // ★이게 핵심★ 예를 들어, (아래의 처음 수열이니, 이후로 오는거니까 라는 말은 LIS 에서 의미하는 말.)
					  // 10 20 10 30 20있으면 순서대로 10은 처음 수열이니 아무데서도 안와서 0, 20은 10 이후로 오는거니까 10의 인덱스인 1,
					  // 10은 다시 처음 수열이니 아무데서도 안와서 0, 30은 LIS에서 20 이후니까 20의 인덱스 2, 20은 3번째 10 이후에서 오는거니까 3 이런식
					  // 헷갈리면 pdf 보기  ★결론 → a[i]는 a[j]번째 다음의 LIS 수열이다! 이걸 나타낸것.
				}
			}
		}
		int p = 0;
		int ans = d[0]; //이건 꼭 d[n] 이 최댓값이란 법 없지 ex) a 배열이 10 20 30 10
		for(int i = 1 ; i < N ; i++) {
			if(ans < d[i]) {
				ans = d[i];
				 p = i; //이거 왜해주는지 생각해보면, 예를들어 20 10 20 30이면 10부터 LIS 시작.
			}
		}
		
		bw.write(String.valueOf(ans) + "\n");
		backtracking(p);
		bw.flush();
		bw.close();
		

	}
	
	public static void backtracking(int n) throws IOException { //가장 긴 증가하는 부분수열을 역추적으로 구할 예정. 기제는 a[n]앞엔 a[v[n]] (pdf에 존재)
		if(n == -1) return; // 변하지 않은놈 차례가 되면(v[i] = j 에서 변한놈들은 -1값 아닐테니) 매소드 탈출해버리자
		backtracking(v[n]); //매소드 안의 매소드
		bw.write(String.valueOf(a[n]) + " ");
	}
	
}