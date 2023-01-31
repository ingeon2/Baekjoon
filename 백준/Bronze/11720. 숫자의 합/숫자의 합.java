import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args)  throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       int N = Integer.parseInt(br.readLine());
       String S = br.readLine();
       int sum = 0;
       for(char c : S.toCharArray()) {
    	   sum += c - '0';
       }
       bw.write(String.valueOf(sum));
       bw.flush();
       bw.close();

    }
    
}