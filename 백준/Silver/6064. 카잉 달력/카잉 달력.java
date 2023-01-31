import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		while(N -- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int lcm = a * b / gcd(a, b); //최소공배수 식
			
			int ans = -1; //다 안맞으면 -1입력해야해서
			for(int i = x ; i <= lcm ; i+=a) { //왜 lcm까지인지 문제 보고 생각(이건쉬움)
											   //for문 왜 x부터 i += a 일까? 생각하기 생각! (i%a가 x인것만 도는 for문)
				int mod1 = i%a; //이 변수 설정하는 이유는 아래아래줄에 나옴.
				int mod2 = i%b;
				if(mod1 == 0) mod1 = a;//이 과정이 뭔지 생각해보기 (ex) i 20 a 10일때 모드는 0이지만 x값은 10으로나옴 → 모드를 10으로 바꿔줘야함
				if(mod2 == 0) mod2 = b;
				
				if(mod1 == x && mod2 == y) { //i 하나씩 키워가면서 년도에 맞게 나온다면 ans를 i로 바꿔줌
					ans = i;
					break;
				}
				
			}
			bw.write(String.valueOf(ans) + "\n"); //어쨌든 바뀌든(i값) 안바뀌든 ans 입력.
		}
		
		bw.flush();
		bw.close();

	}
	
	public static int gcd(int a, int b) { //최대공약수 만드는 매서드
		int r = a%b;
		while(r != 0) {
			a = b;
			b = r;
			r = a%b;
		}
		
		return b;
	}
	
}