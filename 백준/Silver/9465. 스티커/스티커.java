import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static long d[][]; //d[0, 1, 2][i] 은 각각 길이 i, (위 색칠 아래 색칠 둘다 색칠X) 일떄의 점수 합의 최댓값 을 의미.
	public static long v[][]; // 입력값 넣어줄것
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		while(N -- > 0) {
			int n = Integer.parseInt(br.readLine());
			bw.write(String.valueOf(sticker(n)) + "\n");
		}
		
		
		bw.flush();
		bw.close();
	}
	
	public static long sticker(int n) throws IOException {
		
		v = new long[2][100001];
		d = new long[3][100001];
		
		StringTokenizer st0 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1 ; i <= n ; i++) { //입력값 v에 채우는 for문
			v[0][i] = Integer.parseInt(st0.nextToken());
			v[1][i] = Integer.parseInt(st1.nextToken());
		}
		
		d[0][1] = v[0][1]; //길이 1, 위만색칠
		d[1][1] = v[1][1]; //길이 1, 아래만색칠
		d[2][1] = 0; //길이 1, 색칠x
		
		for(int i = 2 ; i <= n ; i++) { //여기가 핵심
			d[0][i] = Math.max(d[1][i-1], d[2][i-1]) + v[0][i];
			d[1][i] = Math.max(d[0][i-1], d[2][i-1]) + v[1][i];
			d[2][i] = Math.max(d[0][i-1], d[1][i-1]); //얘는 왜 더하는게 없을까? i-1에서 위나 아래 색칠한 후 i에서는 색칠안한다는것.
		}
		
		long max =  Math.max(d[0][n], d[1][n]);
		return Math.max(max, d[2][n]);
	}
	
}