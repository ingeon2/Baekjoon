import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int year = 1;
		int e;
		int s;
		int m;
		
		for(;;) {
			if(year % 15 == 0) {e = 15;}
			else {e = year%15;}
			if(year % 28 == 0) {s = 28;}
			else {s = year%28;}
			if(year % 19 == 0) {m = 19;}
			else {m = year%19;}
			
			if(e == E && s == S && m == M) {
				bw.write(String.valueOf(year));
				break;
			}
			else year++;
		}
		
		bw.flush();
		bw.close();

	}
	
}