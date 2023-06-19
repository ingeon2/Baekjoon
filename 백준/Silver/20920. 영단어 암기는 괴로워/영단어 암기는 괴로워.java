import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //우선순위
        //1. 자주 나오는 단어일수록 앞에 배치한다. (횟수에 따라 정렬)
        //2. 해당 단어의 길이가 길수록 앞에 배치한다. (횟수같으면 length() 따라 정렬)
        //3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다 (length() 같으면 기존의 String compareTo에 따라 정렬)

        //첫줄 단어 개수와 제한 길이.
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken()); //단어 개수
        int M = Integer.parseInt(st1.nextToken()); //제한 길이

        PriorityQueue<wordBook> q = new PriorityQueue<>();
        HashMap<String, Integer> map = new HashMap<>();


        for(int i = 0 ; i < N ; i++) {
            String word = br.readLine();

            if(word.length() < M) { //길이 제한 안맞다면, 제끼고
                continue;
            }
            else { //길이 제한 충족할때는
                if(map.containsKey(word)) { //이미 존재하면 갯수 +1 해주고
                    map.replace(word, map.get(word)+1);
                }
                else { //존재하지 않으면 map에 넣어주기
                    map.put(word, 1);
                }
            }
        }

        // 여기까지 오면 map 에 단어와 그 단어의 횟수가 저장됨. 이제 순회하며 해당 내용을 우선순위 큐에 넣을 예정.

        for(Map.Entry<String, Integer> now : map.entrySet()) {
            q.add(new wordBook(now.getKey(), now.getValue()));
        }

        //우선순위 큐이기에, 아래에 작성한 매서드대로 정렬해주니까, Queue의 내용을 뽑아내며 출력하면 된다.

        while(!q.isEmpty()) {
            bw.write(q.poll().word + "\n");
        }
        bw.flush();
        bw.close();

    }

    static class wordBook implements Comparable<wordBook>{
        String word;
        int times;

        public wordBook (String word, int times) {
            this.word = word;
            this.times = times;
        }

        public int compareTo (wordBook e) {
            if(this.times == e.times) {
                if(this.word.length() == e.word.length()) {
                    return this.word.compareTo(e.word); //3번 우선순위
                }
                else {
                    return e.word.length() - this.word.length(); //2번 우선순위, 길수록 큐 우선순위
                }
            }
            return e.times - this.times; //1번 우선순위 자주나올수록 큐 우선순위 (times 클수록)
        }

    }
    

}