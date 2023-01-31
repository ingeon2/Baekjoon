import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int totalprice = scan.nextInt();
		
		int items = scan.nextInt();
		int i = 0;
		int sum = 0;
		
		while(i < items) {
			int item = scan.nextInt();
			int howMany = scan.nextInt();
			
			sum += (item * howMany);
			
			i++;
		}
		
		if(sum == totalprice) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	
	}
	

}