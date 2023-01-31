import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static long[][] d; //d[i][0], d[i][1], d[i][2] 는 각각 i번째 줄의 방이 비워져있는것, 왼쪽만, 오른쪽만 채워져있을때의 ★경우의 수★ 
							  //(붙을수 없으니 둘다 채워진 경우는 X)
                              // 이렇게 가도 모든상황 포괄 가능. 2만 생각해도 사자 0마리, 1마리, 2마리 다 포함함
	public static long mod = 9901;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		d = new long[100001][3];
		
		int N = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf(zoo(N)));
		bw.flush();
		bw.close();
		
	}
	
	public static long zoo(int n) {
		d[1][0] = 1;
		d[1][1] = 1;
		d[1][2] = 1;
		
		for(int i = 2 ; i < n+1 ; i++) {
			d[i][0] = (d[i-1][0] + d[i-1][1] + d[i-1][2]) % mod; //i번째에 안채우려면(0) i-1번째의 세가지 상황(0, 1, 2) 모두에서 가능
			d[i][1] = (d[i-1][0] + d[i-1][2]) % mod;
			d[i][2] = (d[i-1][0] + d[i-1][1]) % mod;
		}
		return (d[n][0] + d[n][1] + d[n][2]) % mod;
	}

}