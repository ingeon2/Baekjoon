import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int l = numbers.length;
        Arrays.sort(numbers);
        return numbers[l-1] * numbers[l-2];
    }
}