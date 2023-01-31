import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int [] want_ACGT;
	static int [] ACGT;
	static int check;

    public static void main(String[] args)  throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
       StringTokenizer st1 = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st1.nextToken()); //배열크기
       int M = Integer.parseInt(st1.nextToken()); //탐색할 윈도우 크기
       
       char[] DNA = new char[N];
       DNA = br.readLine().toCharArray();
       want_ACGT = new int[4];
       ACGT = new int[4];
       check = 0;
       int result = 0;
       
       StringTokenizer st2 = new StringTokenizer(br.readLine()); //원하는 ACGT 개수
       
       for(int i = 0 ; i < 4 ; i++) {
    	   want_ACGT[i] = Integer.parseInt(st2.nextToken());
    	   if(want_ACGT[i] == 0) { //여기 왜있을지 생각
    		   check++;
    	   }
       }
       
       for(int i = 0 ; i < M ; i++) {
    	   Add(DNA[i]);
       }
       if(check == 4) {
    	   result++;
       }
       
       for(int i = 0 ; i < N-M ; i++) { //여기가 슬라이딩 윈도우
    	   Remove(DNA[i]);
    	   Add(DNA[i+M]);
    	   if(check == 4) {
    		   result++;
    	   }
       }
       
       bw.write(String.valueOf(result));
       bw.flush();
       bw.close();
       

    }
    
    public static void Add(char c) {
    	switch (c) {
    	case 'A':
    		ACGT[0]++;
    		if(want_ACGT[0] == ACGT[0]) {
    			check++;
    		}
    		break;
    	case 'C':
    		ACGT[1]++;
    		if(want_ACGT[1] == ACGT[1]) {
    			check++;
    		}
    		break;
    	case 'G':
    		ACGT[2]++;
    		if(want_ACGT[2] == ACGT[2]) {
    			check++;
    		}
    		break;
    	case 'T':
    		ACGT[3]++;
    		if(want_ACGT[3] == ACGT[3]) {
    			check++;
    		}
    		break;
    	}
    	
    }
    
    
    public static void Remove(char c) {
    	switch (c) {
    	case 'A':
    		if(want_ACGT[0] == ACGT[0]) {
    			check--;
    		}
    		ACGT[0]--;
    		break;
    	case 'C':
    		if(want_ACGT[1] == ACGT[1]) {
    			check--;
    		}
    		ACGT[1]--;
    		break;
    	case 'G':
    		if(want_ACGT[2] == ACGT[2]) {
    			check--;
    		}
    		ACGT[2]--;
    		break;
    	case 'T':
    		if(want_ACGT[3] == ACGT[3]) {
    			check--;
    		}
    		ACGT[3]--;
    		break;
    	}
    	
    }
    
    
    
}