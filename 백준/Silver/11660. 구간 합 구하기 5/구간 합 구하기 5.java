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
       int N = Integer.parseInt(st1.nextToken()); //행렬크기
       int M = Integer.parseInt(st1.nextToken()); //부분합 몇번구할건지
       
       int a[][] = new int[N+1][N+1]; //입력값 넣을거
       int s[][] = new int[N+1][N+1]; // 실제로 합 구할거야. 근데 중복되는 얘들은 너가 풀가동해서 생각해봐.
       
       for(int i = 1 ; i < N+1 ; i++) {
    	   StringTokenizer st2 = new StringTokenizer(br.readLine());
    	   for(int j = 1 ; j < N+1 ; j++) {
    		   a[i][j] = Integer.parseInt(st2.nextToken()); //a[i][j]는 입력값 대입
    		   
    	   }   
       }
     //여기까지 입력값 넣은것
       
       for(int i = 1 ; i < N+1 ; i++) {
    	   for(int j = 1 ; j < N+1 ; j++) {
    		   s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] +a[i][j]; //이거 핵심1
    	   }
       }
       
       for(int i = 0 ; i < M ; i++) {
		   StringTokenizer st3 = new StringTokenizer(br.readLine());
		   int x1 = Integer.parseInt(st3.nextToken());
		   int y1 = Integer.parseInt(st3.nextToken());
		   int x2 = Integer.parseInt(st3.nextToken());
		   int y2 = Integer.parseInt(st3.nextToken());
		   int result = s[x2][y2] - s[x2][y1-1] -s[x1-1][y2] +s[x1-1][y1-1]; //이거 핵심2
		   bw.write(String.valueOf(result) + "\n");
	   }
       
       bw.flush();
       bw.close();
    }
    
}