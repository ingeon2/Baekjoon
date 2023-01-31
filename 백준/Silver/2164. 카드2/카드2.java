import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		Queue<Integer> q = new LinkedList<>(); //큐 생성
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1 ; i <= N ; i++) { //큐에 집어넣기
			q.offer(i);
		}
		
		while(q.size() != 1) { //크기 1될때까지
			q.poll(); //빼고
			q.offer(q.poll()); //빼고 넣어라 즉, 두번빼고 두번째로 뺀건 다시 아래에 넣어라
		}
		
		System.out.print(q.peek());
		/*bw.write(q.peek());
		bw.flush();
		bw.close();*/
	}
	
	
	

}


