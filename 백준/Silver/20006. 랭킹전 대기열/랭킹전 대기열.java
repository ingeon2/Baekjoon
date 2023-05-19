import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        ArrayList<Room> rooms = new ArrayList<>();

        for(int i = 0 ; i < p ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int nowLevel = Integer.parseInt(st2.nextToken());
            String nowName = st2.nextToken();
            boolean contained = false;

            for(Room nowRoom : rooms) {
                if(nowRoom.users.size() < m && nowRoom.users.get(0).level-10 <= nowLevel && nowRoom.users.get(0).level+10 >= nowLevel) {
                    nowRoom.users.add(new User(nowName, nowLevel));
                    contained = true;
                    break;
                }
            }
            if(!contained) {
                rooms.add(new Room());
                rooms.get(rooms.size()-1).users.add(new User(nowName, nowLevel));
            }

        }

        for(Room nowRoom : rooms) {
            Collections.sort(nowRoom.users);
            if(nowRoom.users.size() == m) {
                bw.write("Started!" + "\n");
                for(User u : nowRoom.users) {
                    bw.write(String.valueOf(u.level) + " " + u.name + "\n");
                }
            }
            else {
                bw.write("Waiting!" + "\n");
                for(User u : nowRoom.users) {
                    bw.write(String.valueOf(u.level) + " " + u.name + "\n");
                }
            }
        }

        bw.flush();
        bw.close();

    }

    static class User implements Comparable<User>{
        String name;
        int level;

        public int compareTo(User e) {
            return this.name.compareTo(e.name);
        }

        public User(String name, int level) {
            this.name = name;
            this.level = level;
        }
    }

    static class Room {
        List<User> users = new ArrayList<>();
    }

}