import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] check1 = new int[] {1, 2, 3, 4, 5}; //5
        int[] check2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5}; //8
        int[] check3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //10
        
        int answer1 = 0;
        int answer2 = 0;
        int answer3 = 0;
        
        for(int i = 0 ; i < answers.length ; i++) {
            if(check1[i%5] == answers[i]) answer1++;
            if(check2[i%8] == answers[i]) answer2++;
            if(check3[i%10] == answers[i]) answer3++;
        }
        
        int max = Math.max(Math.max(answer1, answer2), answer3);
        
        ArrayList<Integer> arr = new ArrayList<>();
        if(max == answer1) arr.add(1);
        if(max == answer2) arr.add(2);
        if(max == answer3) arr.add(3);
        
        int[] answer = new int[arr.size()];
        for(int i = 0 ; i < arr.size() ; i++) {
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}