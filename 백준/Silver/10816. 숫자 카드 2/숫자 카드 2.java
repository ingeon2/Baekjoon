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
		
		int[] result = new int[20000001]; //result 배열 마이너스 천만에서 플러스 천만까지
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " "); 
		while(N -- > 0) {
			result[Integer.parseInt(st1.nextToken()) + 10000000]++; //둘째줄 숫자들 result 배열에 빈도 수 측정
		}
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " "); 
		for(int i = 0 ; i < M ; i++) { //넷째 줄 숫자들 하나하나씩, 기록된 result 배열의 빈도수 호출
			bw.write(String.valueOf(result[Integer.parseInt(st2.nextToken()) + 10000000]) + " ");
		}
		
		bw.flush();
		bw.close();

	}
	
}