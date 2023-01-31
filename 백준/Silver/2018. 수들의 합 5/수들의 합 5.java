import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)  throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       int N = Integer.parseInt(br.readLine());
       int start_num = 1;
       int end_num = 1;
       int sum = 1;
       int count = 1;
       
       while(end_num != N) { //투포인트 알고리즘. 1~15에서 시작과 끝숫자는 1부터 시작. 
    	   if(sum < N) {	 // 스타트++ 과 엔드++ 는 각각 자신의 if문 안에서 순서가 다른 이유는 뭘까?
    		   end_num++;
    		   sum += end_num;
    	   }
    	   else if(sum > N) {
    		   sum -= start_num;
    		   start_num++;
    	   }
    	   else {
    		   count++;
    		   end_num++;
    		   sum += end_num;
    	   }
       }
       
       bw.write(String.valueOf(count));
       bw.flush();
       bw.close();

    }
    
}