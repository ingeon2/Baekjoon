import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	
	int a = scanner.nextInt();
	int b = scanner.nextInt();
	int c = scanner.nextInt();
	
	
	int d = 0;
	int [] array = {a, b, c};
	for(int i : array) d = Math.max(i, d);
	
	if(a == b) {
		if(a == c) {
			System.out.println( 10000 + (a * 1000) );
		}
		else {
			System.out.println(1000 + (a * 100));
		}
	}
	else {
		if( b == c ) {
			System.out.println(1000 + (c * 100));
		}
		else if( a == c ){
			System.out.println(1000 + (c * 100));
		}
		else {
			System.out.println(d * 100);
		}
	}

	}

}