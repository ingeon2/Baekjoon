import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	
	public static int[][] v; //v[i][0] 은 입력값 대입한거. i번째 집의 0번째 색의 가격
	public static int[][] d; //d[i][0]은 i번째 집이 0번째 색(R)일때의 최솟값  
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		v = new int[1001][3]; //왜 3인지 생각
		d = new int[1001][3];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i < N+1 ; i++) { //입력값을 v에 대입하기
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			v[i][0] = Integer.parseInt(st.nextToken());
			v[i][1] = Integer.parseInt(st.nextToken());
			v[i][2] = Integer.parseInt(st.nextToken());
		}
		
		makeD(N); //아래 최솟값 만드는 매서드 실행
		
		int ans = Math.min(Math.min(d[N][0], d[N][1]), d[N][2]); //셋중 최솟값이 답이야
		
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();

	}
	
	public static void makeD(int N) {
		d[1][0] = v[1][0];
		d[1][1] = v[1][1];
		d[1][2] = v[1][2];
		
		for(int i = 2 ; i <= N ; i++) {
			d[i][0] = Math.min(d[i-1][1], d[i-1][2]) + v[i][0]; //★ 이 식 이해하기. i번째 집을 0번째 색으로 칠하는데 드는 최솟값은    
												     			// i-1번째 집을 1, i-1번째 집을 2의 색으로 칠하는데 드는 값중에서 (색 중복 불가라서)
																// 최소의 값에서 i번째 집의 0색 가격을 더한것.
			d[i][1] = Math.min(d[i-1][0], d[i-1][2]) + v[i][1];
			d[i][2] = Math.min(d[i-1][0], d[i-1][1]) + v[i][2];
		}
	 } //그럼 d[i][0], d[i][1], d[i][2] 는 각각 i번째 집을 0, 1, 2 색으로 칠했을때의 최솟값임. → 셋중에 젤작은값이 그럼 RGB의 최솟값이 나오겠네.
	
}