import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        //첫줄 N, K 는 컨베이어벨트 길이와 내구도0개수 제한
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        int[] duration = new int[2*N];
        boolean[] robot = new boolean[2*N];
        int stage = 1; //단계
        int num_zero = 0; //내구성 0인 칸 수

        //둘째줄은 내구성
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 2*N ; i++) {
            duration[i] = Integer.parseInt(st2.nextToken());
        }

        //이제 while문
        while(true) {
            //1번 1칸회전 (로봇도)
            int tmp = duration[2*N - 1];
            boolean tmp2 = robot[2*N -1];
            for(int i = 2*N-1 ; i >= 0 ; i--) {
                if(i == 0) {
                    duration[0] = tmp;
                    robot[0] = tmp2;
                }
                else {
                    duration[i] = duration[i-1];
                    robot[i] = robot[i-1];
                    if(i == N-1) robot[N-1] = false;
                }

            }
            
            
            //2번 이동 가능하면 로봇 단 한칸!! 이동시키고 내구성 깎기 (뒤에서부터 해야함)
            //지금칸에 로봇 없고 내구성 있으며, 저번 칸에 로봇 있으면 땡겨오기
            boolean tmpBoolean = robot[2*N - 1];

            for(int i = 2*N-1 ; i >= 0 ; i--) {
                if(i == 0) {
                    if(!robot[i] && tmpBoolean && duration[i] > 0) {
                        robot[i] = true;
                        robot[2*N-1] = false;
                        duration[i]--;
                        if(duration[i] == 0) num_zero++;
                        if(num_zero == K) break;
                    }
                }
                else {
                    if(!robot[i] && robot[i-1] && duration[i] > 0) {
                        robot[i] = true;
                        robot[i-1] = false;
                        duration[i]--;
                        if(duration[i] == 0) num_zero++;
                        if(num_zero == K) break;
                        
                        if(i == N-1) robot[N-1] = false; //로봇 내려주기
                    }
                }
            }
            
            if(num_zero == K) break;


            //3단계 로봇 올리기
            if(duration[0] > 0) {
                robot[0] = true;
                duration[0]--;
                if(duration[0] == 0) num_zero++;
                if(num_zero == K) break;
            }

            stage++;
            
        }

        bw.write(String.valueOf(stage));
        bw.flush();
        bw.close();
    }

}