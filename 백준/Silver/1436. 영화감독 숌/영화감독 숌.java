import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int num = 666;
		int count = 1;
		
		while(N != count) {
			num++;
			
			if(String.valueOf(num).contains("666")) { //브루트포스, contain매소드
				count++;
			}
		}
		
        bw.write(String.valueOf(num));
		bw.flush();
		bw.close();


	}

}
