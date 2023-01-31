import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static int result = 64; //최솟값 갱신 전에 나올수 있는 제일 큰값으로 넣어준것
	public static boolean d[][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		d = new boolean[N][M];
		
		for(int i = 0 ; i < N ; i++) { //대입
			String S = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				if(S.charAt(j) == 'B') {
					d[i][j] = true;
				}
				else {
					d[i][j] = false;
				}
			}
		}
		
		for(int i = 0 ; i <= N-8 ; i++) {
			for(int j = 0 ; j <= M-8 ; j++) {
				result = Math.min(chess(i, j), result);
			}
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();

	}
	
	public static int chess(int x_start, int y_start) {
		boolean start = d[x_start][y_start];
		int sum = 0;
		
		for(int i = x_start ; i < x_start+8 ; i++) {
			for(int j = y_start ; j < y_start+8 ; j++) {
				if(d[i][j] != start) {
					sum++;
				}
				start = !start;
			}
			start = !start;
		}
		sum = Math.min(64-sum, sum);
		return sum;
	}
	
}