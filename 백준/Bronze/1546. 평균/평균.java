import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.

	  세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.  (3  60 70 80 평균)*/


	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] array = new int[N];
		
		int i = 0;
		double sum = 0;
		double max = array[0];
		
		while(st.hasMoreTokens()) {
			array[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		for(int scores : array) {
			sum += scores;
			if(max < scores) {
				max = scores;
			}
		}
		
		double averageScore =  ((sum/max) * 100 / N);
		System.out.println(averageScore);
		
	}
	
}
