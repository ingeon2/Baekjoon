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
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] d = new int [N+1];
		d[1] = Integer.parseInt(st.nextToken());
		
		for(int i = 2 ; i < N+1 ; i++) {
			 int min = Integer.parseInt(st.nextToken());//일단 넣어주고 최솟값 바뀌면 바꿔줄겨 
			 
			int j = 1; //while 조건 안에서 사용해줄값
			
			while(i-j >= i/2) {
				if(min > (d[i-j] + d[j])) { // d[n] = max{(d[n-1]+d[1]),(d[n-2]+d[2]),......,(d[n/2] + d[n/2])} 표현한 while문
					min = d[i-j] + d[j];
				}
				j++;
			}
			d[i] = min; //여기 들어가는건 i개의 카드를 사는데 드는 돈의 최솟값임.
		}
		bw.write(String.valueOf(d[N]));
		bw.flush();
		bw.close();

		
	}
	

}