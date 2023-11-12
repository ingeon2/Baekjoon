class Solution {
    public long solution(int price, int money, int count) {
        
        long c = 0;
        for(int i = 1 ; i <= count ; i++) {
            c += i;
        }
        long p = price * c;
        if(p-money < 0) return 0;
        return p-money;
    }
}