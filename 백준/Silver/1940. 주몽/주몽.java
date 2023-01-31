import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)  throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       int N = Integer.parseInt(br.readLine()); //행렬크기
       int M = Integer.parseInt(br.readLine()); //두개의 합으로 만들 크기
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       int[] arr = new int[N]; //0~N-1까지
       for(int i = 0 ; i < N ; i++) {
    	   arr[i] = Integer.parseInt(st.nextToken());
       }
       
       Arrays.sort(arr); // N <= 15000 이라서 시간복잡도 가능
       
       int start = 0;
       int end = N-1;
       int count = 0;
       int sum = arr[0] + arr[N-1];
       
       while(start != end) {
    	   if(sum == M) {
    		   count++;
    		   end--;
    		   sum = arr[start] + arr[end];
    	   }
    	   else if(sum > M) {
    		   end--;
    		   sum = arr[start] + arr[end];
    	   }
    	   else {
    		   start++;
    		   sum = arr[start] + arr[end];
    	   }
       }
       
       bw.write(String.valueOf(count));
       bw.flush();
       bw.close();
       
       

    }
    
}