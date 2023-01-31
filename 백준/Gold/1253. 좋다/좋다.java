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
       StringTokenizer st = new StringTokenizer(br.readLine()); //집어넣을거
       
       long[] arr = new long[N]; //0~N-1까지
       for(int i = 0 ; i < N ; i++) {
    	   arr[i] = Long.parseLong(st.nextToken());
       }
       
       Arrays.sort(arr); // 정렬해주기 (N <= 2000 이라서 시간복잡도 가능)
       
       
       int count = 0;
       
       for(int k = 0 ; k < N ; k++) {
    	   long sum = arr[k];
    	   int i = 0;
    	   int j = N-1;
    	   
    	   while(i < j) { //투포인트 알고리즘 else가 어려움
    		   if(arr[i] + arr[j] > sum) {
    			   j--;
    		   }
    		   else if(arr[i] + arr[j] < sum) {
    			   i++;
    		   }
    		   else { //같으면 그냥 count++; break;만 하면 되는거 아닌가? → 아님.(들어갈 수는 음수도 가능하기 때문.) 
    			   if(i!=k && j!=k) { //sum 으로 지정한 숫자가 나오더래도(else), 자기자신과 0을 더해서 나올수도있기에
    				   count++;		  // 그런 경우 안세주는 if문
    				   break;
    			   }
    			   else if(i == k) {
    				   i++;
    			   }
    			   else {
    				   j--;
    			   }
    		   }
    	   }
       }
       
       bw.write(String.valueOf(count));
       bw.flush();
       bw.close();
       
    }
    
}