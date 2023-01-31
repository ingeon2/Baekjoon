import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1 = br.readLine();
		
		int N = Integer.parseInt(s1.split(" ")[0]);
		int X = Integer.parseInt(s1.split(" ")[1]);
		
		
		String s2 = br.readLine();
		String[] s2Split = s2.split(" ");
		
		
		for(int i = 0 ; i < N ; i++) {
			int ss = Integer.parseInt(s2Split[i]);
			if(ss < X) {
				bw.write(ss + " ");
			}
			bw.flush();
		}
		
		
	}

}