import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/*첫째 줄에 테스트 케이스의 개수가 주어진다. 
	  "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다. */


	public static void main(String[] args) throws IOException {
		
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] strarray = new String[N];
		
		for(int i = 0 ; i < N ; i++) {
			strarray[i] = br.readLine();
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			
			int count = 0;
			int sum = 0;
			
			for(int j = 0 ; j < strarray[i].length() ; j++) {
				if(strarray[i].charAt(j) == 'O') {
					count ++;
				}
				else {
					count = 0;
				}
				sum += count;
			}
			System.out.println(sum);
		}
		
		
	}
	
}
