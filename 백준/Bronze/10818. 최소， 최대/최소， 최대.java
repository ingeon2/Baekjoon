import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] array = new int[N];
		
		int index = 0;
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		
		while(st.hasMoreTokens()) {
			array[index] = Integer.parseInt(st.nextToken());
			
			index++;
		}
		
		Arrays.sort(array);
		
		System.out.println(array[0] + " " + array[N-1]);
	}

}
