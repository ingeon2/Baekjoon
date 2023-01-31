import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] array = new int[9];		
		
		for(int i = 0 ; i < array.length ; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		int max = 0;
		int index = 0;
		int count = 0;
		
		for(int nums : array) {
			count++;
			if(nums > max) {
				max = nums;
				index = count; //if 조건이 맞으면 index에 count 할당인데, 마지막으로 if 조건이 맞을때 = 최댓값을 찾았을때. 
			}
			
		}
		
		System.out.println(max);
		System.out.println(index);

	}

}
