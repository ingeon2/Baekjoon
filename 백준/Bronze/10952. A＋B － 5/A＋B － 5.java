import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		while(true) {
			String s1 = br.readLine();
			String[] s1Split = s1.split(" ");
			
			int x = Integer.parseInt(s1Split[0]);
			int y = Integer.parseInt(s1Split[1]);
			
			if(x==0 && y==0) break;
			bw.write(x + y + "\n");
			
			
			
		}
		bw.flush();
	}

}