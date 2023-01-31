import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int N = Integer.parseInt(br.readLine());
		
	    int arr[][] = new int[N][2];
	    
	    for(int i = 0 ; i < N ; i++) {
	    	StringTokenizer st= new StringTokenizer(br.readLine(), " ");
	    	arr[i][0] = Integer.parseInt(st.nextToken());
	    	arr[i][1] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) { //문제에서 주어진대로 y좌표 먼저 , y좌표 같으면
					return o1[0] - o2[0]; //x좌표 오름차순
				}
				else { //y좌표 다르면
					return o1[1] - o2[1]; //y좌표 오름차순
				}
			}
	    	
	    });

		for(int i = 0 ; i < N ; i++) {
			bw.write(arr[i][0] + " " + arr[i][1] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
}