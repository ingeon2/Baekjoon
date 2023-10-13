import java.util.*;

class Solution {
    public int solution(int N, int number) {
        ArrayList<HashSet<Integer>> arr = new ArrayList<>();
        
        for(int i = 0 ; i <= 8 ; i++) {
            arr.add(new HashSet<Integer>());
        }
        
        arr.get(1).add(N);
        arr.get(2).add(N+N);
        //arr.get(2).add(N-N);
        arr.get(2).add(N/N);
        arr.get(2).add(N*N);
        arr.get(2).add(10*N + N);
        
        for(int i = 3 ; i <= 8 ; i++) {
            for(int j = 1 ; j <= i-1 ; j++) {
                
                for(int a : arr.get(j)) {
                    for(int b : arr.get(i-j)) {
                        
                        arr.get(i).add(a + b);
                        arr.get(i).add(a - b);
                        arr.get(i).add(a * b);
                        if(a != 0 && b != 0) {
                            arr.get(i).add(a / b);
                        }
                    }
                }
            }
            
            arr.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
        }
        
        
        int answer = -1;
        for(int i = 1 ; i <= 8 ; i++) {
            if(arr.get(i).contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}