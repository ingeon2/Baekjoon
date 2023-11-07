
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 1 ; i <= n ; i++) {
        	st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            
            bw.write("#" + String.valueOf(i) + " " + String.valueOf(find(a, b, c)) + "\n");
        }
        
        bw.flush();
        bw.close();
        
        
	}
    
    static double find(double a, double b, double c) {
    	//abc 등차수열 만들건데, 만들어주기 위해 하나의 수에 0 이상의 double을 더하거나 빼줄건데, 해당 값의 최솟값 return
        //abc가 등차수열 -> b-a = c-b -> 2b = a + c
        // 1번은 2b에 2x 더해줘서 같게 해주기, 2번은 a+c에 x 더해줘서 같게 해주기.
        //0 1 2 -> 0 
		//0 2 1 -> 1.5
		//4 4 8 -> 2.0
        //2b - (a+c) / 2
        
        return Math.abs(2.0 * b - (a+c)) / 2.0;
        
    }
}