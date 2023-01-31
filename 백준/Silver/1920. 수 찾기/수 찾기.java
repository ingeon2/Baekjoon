import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] arr1;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int N = Integer.parseInt(br.readLine());
		
		arr1 = new int [N];
		StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
		
		int j = 0;
		while(st1.hasMoreTokens()) { // 해즈모토큰으로 넣기
			arr1[j] = Integer.parseInt(st1.nextToken());
			j++;
		}
		Arrays.sort(arr1); //크기순 정렬
		
		
		
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0 ; i < M ; i++) {
			if( binarysearch(Integer.parseInt(st2.nextToken())) >= 0 ) {
				bw.write(1 + "\n");
			}
			else {
				bw.write(0 + "\n");
			}
			
		}
		
		bw.flush();
		bw.close();
		
		
		
	}
	
	
	
	public static int binarysearch(int find) {
		
		int low = 0;
		int high = arr1.length - 1;
		
		
		while( high >= low ) {
			
			int mid = (low + high)/2;
			
			if(arr1[mid] > find) { //찾는값 find(arr2[i])가 중간값보다 크면
				high = mid - 1; // -1이랑
			}
			else if(arr1[mid] < find){ //찾는값 find(arr2[i])가 중간값보다 작으면
				low = mid + 1; // +1을 생각 못했어 왜지? (1 ~ 100까지 찾을때 50 했는데 업이래 그럼 51 ~ 100 찾는것과 같은이치)
			}
			else {
				return mid; //처음부터 같다면, 와일문 수행함으로서 같아진다면 → 미드 출력
			}
		
		}
		
		return -2;  //위의 else에 걸리지 않아 while문에서 리턴값 없으면, 음수로 리턴(로우가 커질때까지 값이 나오지 않았다 → 없다)
			
	}
	
}


