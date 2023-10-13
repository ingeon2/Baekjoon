import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        ArrayList<HashSet<Integer>> arr = new ArrayList<>();
        //arr.get(i) -> N을 i개 사용해서 얻어낼 수 있는 모든 수들
        //이것을 이해하는게 가장 중요하다.
        //보통의 D[i]와는 결을 달리하는 느낌이다.
        
        for(int i = 0 ; i <= 8 ; i++) {
            arr.add(new HashSet<Integer>());
        }
        //배열 초기화
        
        arr.get(1).add(N);
        //N 하나로는 N밖에 만들지 못한다.
        
        arr.get(2).add(N+N);
        //arr.get(2).add(N-N); 0 값은 나누기에도 부적합하고, number>=1 이기에 필요없다.
        arr.get(2).add(N/N);
        arr.get(2).add(N*N);
        arr.get(2).add(10*N + N);
        //N 두개로 만들 수 있는 친구들
        
        for(int i = 3 ; i <= 8 ; i++) {
            for(int j = 1 ; j <= i-1 ; j++) {
                //이 방식에서 i=3일때, 바로 아래의 j와 i-j값은 12, 21이 되는데,
                //arr.get(1), arr.get(2)의 원소들을 사칙연산으로 계산하고
                //arr.get(2), arr.get(1)의 원소들도 해주는 이유가 뭘까?
                //더하기와 빼기, 곱하기는 괜찮지만, 나누기는 순서가 필요하므로 나누기를 위해 그런것이다.
                
                for(int a : arr.get(j)) {
                    for(int b : arr.get(i-j)) {
        
                        arr.get(i).add(a + b);
                        arr.get(i).add(a - b);
                        arr.get(i).add(a * b);
                        if(a != 0 && b != 0) {
                            //분자 0이면 필요없는값이므로 하지 않고, 분모 0은 에러값이 나와 하지 않는다.
                            arr.get(i).add(a / b);
                        }
                    }
                }
            }
            
            //arr.get(i)에는 NN... (N이 i개) 이 필요하므로 해당 로직을 추가해준다
            arr.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
        }
        
        
        //-1값으로 지정해놓고, 순회하며 해당 값을 찾지 못하면 그대로 리턴해주고,
        //찾는다면 해당 값을 기록하고 빠져나와 리턴해준다.
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
