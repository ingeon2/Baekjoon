import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> arr = new LinkedList<Integer>(); 
		
		for(int i = 1 ; i < N+1 ; i++) {
			arr.add(i);
		}
		
		bw.write("<");
		int delete = 0;
		for(int i = 0 ; i < N ; i++) {                //큐 아닌 알고리즘으로 푼것
			delete = (delete + (K - 1)) % arr.size(); //이거 이해가 핵심.7 3 예로들면 배열에서 삭제할 자리가(delete가) 2,5,1(8 % 7), 이런식으로간다
			
			if(i == N-1) {
				bw.write(arr.get(delete) + ">");
			}
			else {
				bw.write(arr.get(delete) + ", ");
			}
			arr.remove(delete);
		}
		
		bw.flush();
		bw.close();

		
	}
	
}
