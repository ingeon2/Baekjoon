class Solution {
    static int[] select = new int[3];
    static int answer;
    static int[] nums;
    
    public int solution(int[] number) {
        nums = number;
        answer = 0;
        bt(0, 0);
        return answer;
    }
    
    static void bt(int d, int s) {
        if(d == 3) {
            if(check()) {
                System.out.println(select[0] + " " + select[1] + " " + select[2]);
                answer++;
            }
            return;
        }
        
        for(int i = s ; i < nums.length ; i++) {
            select[d] = nums[i];
            bt(d+1, i+1); //여기 i+1이지 s+1아니다! 이것때문에 30분 쓴듯..
        }
    }
    
    static boolean check() {
        if(select[0] + select[1] + select[2] == 0) return true;
        return false;
    }
}
