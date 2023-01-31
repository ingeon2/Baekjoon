import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	
	int h = scanner.nextInt();
	int m = scanner.nextInt();
	
	
	if(m >= 45) {
		System.out.print(h);
		System.out.print(" ");
		System.out.print(m - 45);
	}
	else if (m < 45) {
		if( h != 0) {
			System.out.print(h-1);
			System.out.print(" ");
			System.out.print(60 - (45 - m));
		}
		else {
			System.out.print("23");
			System.out.print(" ");
			System.out.print(60 - (45 - m));
		}
	}
	
	}

}