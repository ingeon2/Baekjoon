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
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int day;
		if(V == A) {
			day = 1;
		}
		else {
			
			if((V - A)%(A - B) == 0) {
				day = (V - A)/(A - B) + 1;
			}
			else {
				day = (V - A)/(A - B) + 2;
			}
			
		}
		
		bw.write(String.valueOf(day));
		bw.flush();
		bw.close();
				
	}
	
}
