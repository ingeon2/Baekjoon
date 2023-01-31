import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 

public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < X ; i++) {
			int k = Integer.parseInt(br.readLine()); //층수
			int n = Integer.parseInt(br.readLine()); //호수
			
			int[][] apartment = new int [k+1][n];
			
			for(int j = 0 ; j < n ; j++) { //1층에 집어넣기
				apartment[0][j] = j+1;
			}
			
			for(int c = 0 ; c <= k ; c++) { // 1호에 집어넣기
				apartment[c][0] = 1;
			}
			
			for(int a = 1 ; a < k+1 ; a++) {
				for(int b = 1 ; b < n ; b++) {
					
					apartment[a][b] += apartment[a][b-1] + apartment[a-1][b];
					
				}
			}
			
			System.out.println(apartment[k][n-1]);
			
		}
		
	}

}