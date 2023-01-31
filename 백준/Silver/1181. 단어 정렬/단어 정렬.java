import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int N = Integer.parseInt(br.readLine());
		
		String arr[] = new String[N];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = br.readLine();
		}
		
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) { //다른사람이 한거 (원래 라이브러리에잇는 String의 compare 매서드 그대로 사용. 진짜똑똑.)
					return o1.compareTo(o2);
				}
				else { //길이 안같으면 길이 오름차순
					return o1.length() - o2.length();
				}
			}
			
		});
		
		 
		bw.write(arr[0] + "\n"); //아래 for문에서 못껴주는 arr[0]의 상황
		
		for(int i = 0 ; i < N-1 ; i++) {
			if(arr[i].equals(arr[i+1])) { //같은거 한번만 적기
				continue;
			}
			else {
				bw.write(arr[i+1] + "\n");
			}
		}
		
		
		bw.flush();
		bw.close();
		
		
	}
	
}
