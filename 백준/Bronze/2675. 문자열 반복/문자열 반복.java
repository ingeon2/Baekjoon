import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer; /*2
									3 ABC  AAABBBCCC
									5 /HTP /////HHHHHTTTTTPPPPP        */


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int X = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < X ; i++) {
			
			String str[] = br.readLine().split(" ");
			int Y = Integer.parseInt(str[0]);
			String S = str[1];
			
			for(int j = 0 ; j < S.length() ; j++) {
				for(int k = 0 ; k < Y ; k++) {
					System.out.print(S.charAt(j));
				}
			}
			System.out.println();
		}
		
	}
	
}
