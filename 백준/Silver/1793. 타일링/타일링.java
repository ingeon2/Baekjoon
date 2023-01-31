import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;


public class Main {
	
	public static BigInteger[] d;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		d = new BigInteger[251];
		String s;
		while((s = br.readLine()) != null) {
			bw.write(tile(Integer.parseInt(s)).toString() +"\n");
			bw.flush();
		}
		bw.close();

	}
	
	public static BigInteger tile(int n) {
		d[0] = new BigInteger("1"); //빅인티저 사용법 숙지하기
		d[1] = new BigInteger("1");
		d[2] = new BigInteger("3");
		for(int i = 3 ; i < 251 ; i++) {
			d[i] = d[i-1].add(d[i-2].multiply(new BigInteger("2")));//d[i] = d[i-1] + d[i-2] * 2 를 빅인티저로 표현한것 이 문제의 점화식
		}
		
		return d[n];
		
	}

}

