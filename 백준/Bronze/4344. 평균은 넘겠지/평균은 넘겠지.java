import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		int[][] array = new int[X][];
		
		
		
		for(int i = 0 ; i < X ; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			array[i] = new int[Integer.parseInt(st.nextToken())];
			
			int j = 0;
			while(st.hasMoreTokens()) {
				array[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
			
		}
		
		//동적 2차원 배열 하 좋나어렵네진짜
		
		for(int i = 0 ; i < X ; i++) {
			double numsOfColumn = array[i].length;
			
			double sumOfColumn = 0;
			
			for(int j = 0 ; j < numsOfColumn ; j++) {sumOfColumn += array[i][j];}
			
			double averageOfColumn = sumOfColumn / numsOfColumn;
			
			int count = 0;
			for(int scores : array[i]) {
				if(scores > averageOfColumn) {count++;}
			}
			
			double result = (count / numsOfColumn) * 100;
			
			System.out.println( String.format("%.3f", result) + "%" );
		}
		

	}

}
