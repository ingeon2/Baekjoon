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
       int N = Integer.parseInt(st1.nextToken()); //숫자개수
       int M = Integer.parseInt(st1.nextToken()); //나누어떨어지는지 확인할 수
       
       
       long s[] = new long[N+1]; // 입력값 합 (s[4] = 첫번째부터 네번째까지의 입력값의 합을을 M으로 나눈 나머지)
       long c[] = new long[M]; //s 만들면, s 를 구성하는 원소의 개수가 몇개일지 생각 (0, 1, .. , M-1까지)
       
       StringTokenizer st =  new StringTokenizer(br.readLine());
       for(int i = 1 ; i < N+1 ; i++) {
    	   s[i] = (s[i-1] + Integer.parseInt(st.nextToken())) % M;
       }
       //위에서 %m했으니까 어차피 s[i] <= M-1
       //s[i] == 0 일때와 s[i] != 0 일때를 나누어서 계산할것 (0인놈들은 처음부터 0까지 가도 되고, 0에서 0까지 가도 된다)
       
       long result = 0;
       for(int i = 1 ; i < N+1 ; i++) {  //s[] 가 가지고있는 원소개수들을 c[]로 나타내려는 for문
    	   c[(int) s[i]]++;				 //s에 0이 두개라면, c[0] = 2 이다.
    	   
    	  
    	   
       }
       
       result = c[0];
       
       for(int i = 0 ; i < M ; i++) { //같은것 c[i] 개면, 만들수있는 조합은 c[i] 컴비네이션 2 니까.
    	   if(c[i] > 1) {
    		   result += (c[i] * (c[i]-1))/2;
    	   }
       }
       
       
       
       bw.write(String.valueOf(result));
       bw.flush();
       bw.close();

    }
    
}