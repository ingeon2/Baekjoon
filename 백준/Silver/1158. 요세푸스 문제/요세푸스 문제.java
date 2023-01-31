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
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		bw.write("<");
		
		Queue<Integer> q = new LinkedList<Integer>(); //큐 생성
		for(int i = 1 ; i <= N ; i++) { //큐에 N까지 넣어주기
			q.offer(i);
		}
		
		while(!q.isEmpty()) {
			for(int i = 1 ; i <= K-1 ; i++) {
				q.offer(q.poll()); //K-1번 뺀걸(팔) 다시 넣어라(오퍼)
			}
			//그리고 K번째에는 빼서 넣어줘야하니 팔 한걸 그대로 bw에 적어주기
			if(q.size() == 1) {
				bw.write(String.valueOf(q.poll()) + ">"); //마지막놈은 컴마 띄어쓰기 대신 > 필요
			}
			else {
				bw.write(String.valueOf(q.poll()) + ", "); //달라는대로 bw에 적어주기
			}
		}
		bw.flush();
		bw.close();
		
	}
	
}