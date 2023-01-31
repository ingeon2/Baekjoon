import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		int King = scanner.nextInt(); //1
		int Queen = scanner.nextInt(); //1
		int Look = scanner.nextInt(); //2
		int Bishop = scanner.nextInt(); //2
		int Knight = scanner.nextInt(); //2
		int Pawn = scanner.nextInt(); //8
		
		System.out.println(1 - King );
		System.out.println(1 - Queen );
		System.out.println(2 - Look );
		System.out.println(2 - Bishop );
		System.out.println(2 - Knight );
		System.out.println(8 - Pawn );			

	}

}
