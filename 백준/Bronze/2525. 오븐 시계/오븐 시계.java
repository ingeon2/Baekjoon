import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	
	int h = scanner.nextInt();
	int m = scanner.nextInt();
	int time = scanner.nextInt();
	
	int h2 =(m + time)/60;
	
	
	
	if((m + time) < 60) {
		System.out.println(h + " " + (m + time));
	}
	else if((m + time) >= 60) {
		if((h + h2) >= 24) {
			System.out.println((h + h2) - 24 + " " + ((m + time)-(60*h2)));
		}
		else System.out.println(h + h2 + " " + ((m + time)-(60*h2)));
	}

	
	}

}