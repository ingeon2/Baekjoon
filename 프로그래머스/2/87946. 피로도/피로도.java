class Solution {
    static int[][] dg; //던전 넣을것
    static int[] s; //백트래킹으로 선택할것
    static int answer = 0;
    static int k1;
    static boolean[] v;
    
    public int solution(int k, int[][] dungeons) {
        dg = dungeons;
        s = new int[dg.length];
        k1 = k;
        v = new boolean[dg.length];
        
        bt(0);
        
        return answer;
    }
    static void bt(int d) { //n개 던전중 n개 뽑아서 돌려보고 통과할수있는던전 수 체크,
        if(answer == dg.length) return; //다통과해버렸으면 더이상할필요없어
        
        if(d == dg.length) { //돌아다닐 던전 지정했으면 돌아보고 최댓값 갱신해주자
            answer = Math.max(answer, check(k1));
            return;
        }
        
        for(int i = 0 ; i < dg.length ; i++) {
            if(v[i]) continue;
            v[i] = true;
            s[d] = i;
            bt(d+1);
            v[i] = false;
        }
        
    }
    
    static int check(int k) {
        int n = 0;
        
        for(int i = 0 ; i < dg.length ; i++) {
            int[] nd = dg[s[i]];
            
            if(k >= nd[0]) {
                k -= nd[1];
                n++;
            }
            else break;
        }
        
        return n;
    }
}