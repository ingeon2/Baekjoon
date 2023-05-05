import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //다음 줄에 나올 공 수
        int N = Integer.parseInt(br.readLine());
        //공 String
        String ball = br.readLine();

        //총 붉은공, 푸른공 수
        int totalRed = ball.replace("B", "").length();
        int totalBlue = ball.replace("R", "").length();

        //왼쪽에 붙어있는 R, B 수
        int leftRed;
        int leftBlue;

        if(ball.substring(0, 1).equals("R")) {
            leftRed = ball.indexOf("B");
            leftBlue = 0;
        }
        else {
            leftBlue = ball.indexOf("R");
            leftRed = 0;
        }


        //오른쪽에 붙어있는 R, B 수
        int rightRed;
        int rightBlue;

        if(ball.substring(N-1).equals("R")) {
            rightRed = N - ball.lastIndexOf("B") - 1;
            rightBlue = 0;
        }
        else {
            rightBlue = N - ball.lastIndexOf("R") - 1;
            rightRed = 0;
        }




        int red;
        int blue;
        if(leftRed >= rightRed) {
            red = totalRed - leftRed;
        }
        else {
            red = totalRed - rightRed;
        }

        if(leftBlue >= rightBlue) {
            blue = totalBlue - leftBlue;
        }
        else {
            blue = totalBlue - rightBlue;
        }


        if(red > blue) {
            bw.write(String.valueOf(blue));
        }
        else {
            bw.write(String.valueOf(red));
        }

        bw.flush();
        bw.close();

    }

}