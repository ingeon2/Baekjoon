import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		bw.write(String.valueOf(plasticbag(Integer.parseInt(br.readLine()))));
		bw.flush();
		bw.close();
		
		
	}
	
	public static int plasticbag(int n) {
		if(n == 3) { //3일때
			return 1;
		}
		else if(n == 4) { //4일때
			return -1;
		}
		else {
			int num5 = n/5; //n을 5로 나눈 몫 num5를, n이 5와 3의 배수의 합으로 나누어 떨어질때까지 num5를 줄여줄거임. 그래야 봉지개수 최솟값(5키로 봉지, 3키로 봉지)
			while( (n-(5*num5))%3 != 0 ) {
				num5--;
			}
			int num3 = (n-(5*num5))/3;
			if(num5 < 0) { //num5가 음수까지 내려갔다는것은, 5와 3의 배수의 합으로 만들 수 없는 수라는 것
				return -1;
			}
			else {
				return (num5+num3);
			}
			
			
			
		}
		
	}
	

}