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
       
       StringTokenizer st1 = new StringTokenizer(br.readLine());
       int M = Integer.parseInt(st1.nextToken()); //수의 개수
       int N = Integer.parseInt(st1.nextToken()); //i j를 몇번구할건지
       
       StringTokenizer st2 = new StringTokenizer(br.readLine());
       int[] a = new int[M+1]; //입력값 그대로 넣어줄 숫자들
       int[] s = new int[M+1]; //여기가장핵심 부분합 구하기 위한 배열 (s[i] = a[0] + ..... + a[i])
       for(int i = 1 ; i < M+1 ; i++) {
    	   a[i] = Integer.parseInt(st2.nextToken());
    	   if(i == 0) {
    		   s[i] = a[i];
    	   }
    	   else {
    		  s[i] = s[i-1] + a[i];
    	   }
       }
       
       for(int i = 0 ; i < N ; i++) {
    	   StringTokenizer st3 = new StringTokenizer(br.readLine());
    	   int A = Integer.parseInt(st3.nextToken());
    	   int B = Integer.parseInt(st3.nextToken());
    	   bw.write(String.valueOf(s[B] - s[A-1] + "\n"));
       }
       
       bw.flush();
       bw.close();

    }
    
}