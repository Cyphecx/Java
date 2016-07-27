package st;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class allows campers who are first learning Java to easily retrieve input from System.in. 
 * 
 * Use of Prompt.java instead of this class is recommended. 
 * 
 * @author Roger Iyengar
 *
 */
public final class Input {

	//Prevents this class from being instantiated
	private Input() { }

	private static Scanner scan = new Scanner(System.in);

	/**
	 * Receives an integer input from the user. Will keep prompting until a valid integer is received. 
	 * @return user's input
	 */
	public static int readInt() {
		boolean valid = false;
		int in = 0;
		while(!valid){
			try {
				in = scan.nextInt();
				valid = true;
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter a valid integer!");
			}
			scan.nextLine();
		}
		return in;
	}

	/**
	 * Receives a number input from the user. Will keep prompting until a valid number is received. 
	 * @return user's imput
	 */
	public static double readDouble() {
		boolean valid = false;
		double in = 0;
		while(!valid){
			try {
				in = scan.nextDouble();
				valid = true;
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter a valid number!");
			}
			scan.nextLine();
		}
		return in;
	}

	/**
	 * Receives a text input from the user
	 * @return user's input
	 */
	public static String readString() {
		return scan.nextLine();
	}
}
