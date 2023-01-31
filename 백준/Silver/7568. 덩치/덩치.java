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
		
		int N = Integer.parseInt(br.readLine());
		
		String [][] strarray = new String[N][2];
		
		for(int i = 0 ; i < N ; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			strarray[i][0] = st.nextToken();
			strarray[i][1] = st.nextToken();
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			int count = 0;
			for(int j = 0 ; j < N ; j++) {
				if(Integer.parseInt(strarray[i][0]) < Integer.parseInt(strarray[j][0]) && Integer.parseInt(strarray[i][1]) < Integer.parseInt(strarray[j][1])) {
					count++;
				}
				
			}
			bw.write(String.valueOf((count + 1) + " "));
		}
		
		bw.flush();
		bw.close();
		
				
	}
	
}
