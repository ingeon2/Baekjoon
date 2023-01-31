import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main { 


		public static void main(String[] args) throws IOException {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
				int X = Integer.parseInt(br.readLine());
				int[] array = new int[X];
				
				for(int s = 0 ; s < X ; s++) {
					array[s] = Integer.parseInt(br.readLine());
				}
				
				Arrays.sort(array);
				
				for(int i = 0 ; i < X ; i++) { //버퍼드라이터사용
					bw.write(array[i] + "\n");
				}
				
				bw.flush();
				bw.close();

				
			}

		}