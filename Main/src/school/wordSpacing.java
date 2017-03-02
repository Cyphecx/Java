package school;
import java.util.Scanner;

public class wordSpacing {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a word");
		String in = scan.nextLine();
		char[] array = in.toCharArray();
		int temp = 1;
		System.out.print(array[0]);
		for(int i  = 1;  i < array.length; i++){
			
			for(int x = 0; x < (100/(array.length-1)-1); x++){
				temp++;
				System.out.print(" ");
			}
			System.out.print(array[i]);
			temp++;
		}

	}

}
