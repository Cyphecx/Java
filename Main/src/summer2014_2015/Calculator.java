package summer2014_2015;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Answer = 0;
		System.out.println (" Enter 1st number");
		int Wyatt1 = scan.nextInt();
		System.out.println ("Enter 2nd number");
		int Wyatt2 = scan.nextInt();
		System.out.println ("Enter number for operation 1: addidtion 2: subtraction 3: multiplication 4: division");
		int Wyatt3 = scan.nextInt();

		if (Wyatt3 == 1){
Answer = Wyatt1 + Wyatt2;

		} 
		if (Wyatt3 == 2){
	Answer = Wyatt1 - Wyatt2;
		}
		if (Wyatt3 == 3){
	Answer = Wyatt1 * Wyatt2;
		}
		if (Wyatt3 == 4){
	Answer = Wyatt1 / Wyatt2;
		}
		
		System.out.println(Answer);


	}

}
