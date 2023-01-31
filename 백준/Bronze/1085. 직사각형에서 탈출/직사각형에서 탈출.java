import java.io.IOException;
import java.util.Scanner;

public class Main { 

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		int w = scanner.nextInt();
		int h = scanner.nextInt();
		
		int min1 = Integer.min((w - x), (h - y));
		int min2 = Integer.min(x, y);
		int min = Integer.min(min1, min2);
		
		System.out.println(min);
		
			
	}
	
}
