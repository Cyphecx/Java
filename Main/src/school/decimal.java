package school;
import java.util.Scanner;

public class decimal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 100; i++){
			System.out.println("Enter a decimal");
			int input = Integer.parseInt(scan.nextLine());
			int denominator = 1;
			int numerator = input;
			while(denominator < input){
				denominator = denominator * 10;
			}
			int gcf = gfc(numerator, denominator);
			denominator /= gcf;
			numerator /= gcf;
			System.out.println("0." + input + " = " + numerator + " / " + denominator);

		}
	}

	private static int gfc(int numerator, int denominator) {
		int gcf = 0;
		for(int i = 1; i <= numerator; i++){
			if(numerator%i == 0 && denominator%i == 0 && i > gcf){
				gcf = i;
			}
		}

		return gcf;

	}


}
