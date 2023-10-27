class Solution {
    public int solution(int[] sides) {
        int m_idx = 0;
        int max = 0;
        for(int i = 0 ; i < 3 ; i++) {
            if(max < sides[i]) {
                max = sides[i];
                m_idx = i;
            }
        }
        
        int sum_2 = 0;
        for(int i = 0 ; i < 3 ; i++) {
            if(i == m_idx) continue;
            sum_2 += sides[i];
        }
        if(sum_2 > max) return 1;
        
        return 2;
    }
}