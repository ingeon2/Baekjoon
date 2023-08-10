import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Node [] arr = new Node[N];


        for(int i = 0 ; i < N ; i++) {
            int v = Integer.parseInt(br.readLine());
            arr[i] = new Node(i, v);
        }

        //버블정렬 하면서, swap이 멈출때, 즉 정렬이 멈췄을때의 arr[i] 뽑아내기

        Arrays.sort(arr);

        int maxMinus = -1;

        for(int i = 0 ; i < N ; i++) {
            Node n = arr[i];
            if(n.i - i > maxMinus) {
                maxMinus = n.i - i;
            }

        }


        bw.write(String.valueOf(maxMinus + 1));
        bw.flush();
        bw.close();

    }
    
    static class Node implements Comparable<Node> {
        int i, v;
        
        public Node(int i, int v) {
            this.i = i;
            this.v = v;
        }
        
        public int compareTo (Node n) { //값 오름차순
            return this.v - n.v;    
        }
    }


}