import java.util.*;
import java.io.*;


public class Main {
    static ArrayList<Egg> arr = new ArrayList<>();
    static int answer = 0;
    static boolean[] broken;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        broken = new boolean[N+1];

        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr.add(new Egg(i, w, p));
        }

        backTracking(0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();


    }

    static void backTracking(int idx, int b) {
        if(idx == arr.size() || b == arr.size()-1) {
            answer = Math.max(answer, b);
            return;
        }

        if(broken[idx]) {
            backTracking(idx+1, b);
            return;
        }
        Egg ce = arr.get(idx);

        for(int i = 0 ; i < arr.size() ; i++) {
            if(i == idx) continue;
            if(broken[i]) continue;
            Egg ne = arr.get(i);

            int a = canBroken(ce, ne);

            if(a == 2) {
                backTracking(idx+1, b+2);
            }
            else if(a == 1){
                backTracking(idx+1, b+1);
            }
            else {
                backTracking(idx+1, b);
            }

            back(ce, ne);

        }
    }
    
    static class Egg {
        int idx, w, p; //무게내구도

        public Egg(int idx, int w, int p) {
            this.idx = idx;
            this.w = w;
            this.p = p;
        }


        
    }

    static int canBroken (Egg l, Egg r) {
        r.p -= l.w;
        l.p -= r.w;

        int c = 0;
        if(l.p <= 0) {
            broken[l.idx] = true;
            c++;
        }

        if(r.p <= 0) {
            broken[r.idx] = true;
            c++;
        }


        return c;
    }

    static void back(Egg l, Egg r) {
        r.p += l.w;
        l.p += r.w;

        if(l.p > 0) {
            broken[l.idx] = false;
        }

        if(r.p > 0) {
            broken[r.idx] = false;
        }
    }


}