import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int dist = Integer.parseInt(st1.nextToken());
        int[] D = new int[dist+1];
        boolean[] hasShortcut = new boolean[dist+1];

        HashMap<Integer, ArrayList<int[]>> shortcut = new HashMap<>(); //25행에 설명
        for(int i = 1 ; i <= N ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int distance = Integer.parseInt(st2.nextToken());

            if(end <= dist && !shortcut.containsKey(end)) {
                shortcut.put(end, new ArrayList<>());
                shortcut.get(end).add(new int[] {start, distance}); //지름길의 정보를 (끝점, {시작점, 거리} 어레이리스트) 로 저장하는 해쉬맵
                hasShortcut[end] = true; //나중에 해시맵 사용여부 체크 위해
            }
            else if(end <= dist && shortcut.containsKey(end)) {
                shortcut.get(end).add(new int[] {start, distance}); //지름길의 정보를 (끝점, {시작점, 거리} 어레이리스트) 로 저장하는 해쉬맵
                hasShortcut[end] = true; //나중에 해시맵 사용여부 체크 위해
            }
        }
        D[0] = 0;
        for(int i = 1 ; i <= dist ; i++) {
            D[i] = D[i-1] + 1;
            if(hasShortcut[i]) { // i가 끝점인 지름길이 있다면
                for(int[] arr : shortcut.get(i)) { //i를 끝점으로 하는 지름길들 순회하며
                    if(D[arr[0]] + arr[1] < D[i]) {
                        D[i] = D[arr[0]] + arr[1]; // D[i]가 작아지는 값으로 계속해서 바뀌며 최솟값을 갱신해준다
                    }
                    
                }
            }
        }


        bw.write(String.valueOf(D[dist]));
        bw.flush();
        bw.close();

    }


}