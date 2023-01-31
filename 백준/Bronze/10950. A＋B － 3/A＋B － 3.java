import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	
	int a = scanner.nextInt();
	
	int [] array = new int[a];
	
	int i = 0;
	
	while( i < a ) {
		
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		array[i] = (b + c);
		
		i++;
	}
	
	for(int e : array) {System.out.println(e);}
	
	}

}