import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static long[][] p; //p[a][0],p[a][1] 각각 길이 a 의 이친수에서 마지막이 0인,1인 이친수의 수를 의미
							 
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		p = new long[N+1][2];
		
		bw.write(String.valueOf(BinaryNum(N)));
		bw.flush();
		bw.close();

	}
	
	public static long BinaryNum(int n) { //롱 안하면 오버플로나서 틀림!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		p[1][0] = 0;
		p[1][1] = 1;
		
		for(int i = 2 ; i < n+1 ; i++) {
			p[i][0] = p[i-1][0] + p[i-1][1]; //0으로 마치는건 이전 마지막 수 1,0으로 끝나는 얘들
			p[i][1] = p[i-1][0]; //1로 마치는건 이전 마지막 수 0로 끝나는 얘들밖에 못만들고.
			
			
			
		}
		return p[n][0] + p[n][1];
		
	}
}