import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int sum = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i = 0 ; i < 9 ; i++) {
			int a = Integer.parseInt(br.readLine());
			sum += a; //입력값 다 더해줘라 (이걸로 두명 빼줘서 크기 100될때로 풀거니까.)
			arr.add(a);
		}
		
		for(int i = 0 ; i < 9 ; i++) {
			
			for(int j = 0 ; j < i ; j++) {
				if(sum - (arr.get(i) + arr.get(j)) == 100) { //일곱 난장이의 키가 100이 될때,
					arr.remove(i); //i 와 j 번째를 빼줘라
					arr.remove(j);
					break;
				}
			}
			if(arr.size() == 7)break; //크기 7되면(크기 9에서 i, j 두개 지우니까) 그냥 for문 빠져나오자!
		}
		
		Collections.sort(arr); //오름차순 정렬하고
		
		for(int i = 0 ; i < 7 ; i++) { //출력값에 넣자
			bw.write(String.valueOf(arr.get(i)) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
}