package st;

import javax.swing.JOptionPane;

/**
 * This class allows campers who are first learning Java to easily prompt for input from the user. 
 * 
 * @author Roger Iyengar
 *
 */
public final class Prompt {
	
	//Prevents this class from being instantiated
	private Prompt() {}

	/**
	 * Prompt the user to enter a String using a generic message.
	 * @return user's input
	 */
	public static String getString() {
		return getString("Enter a String");
	}

	/**
	 * Prompt the user to enter a String.
	 * @param prompt message to display to the user
	 * @return user's input
	 */
	public static String getString(String prompt){
		String entered = JOptionPane.showInputDialog(prompt);
		
		//This will terminate the program if the user closes out of the prompt
		if(entered==null)
			System.exit(0);
		
		return entered;
	}

	/**
	 * Prompt user to enter an integer using a generic message. Will keep prompting user until a valid integer is entered.
	 * @return user's input
	 */
	public static int getInt() {
		return getInt("Enter an integer");
	}

	/**
	 * Prompt the user to enter an int. Will keep prompting user until a valid integer is entered.
	 * @param prompt message to display to the user
	 * @return user's input
	 */
	public static int getInt(String prompt){
		boolean valid = false;
		int number = 0;
		while(!valid) {
			String entered = getString(prompt);
			try {
				number = Integer.parseInt(entered);
				valid = true;
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "You must enter a valid integer!", "Input Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return number;
	}
	
	/**
	 * Prompt user to enter a number using a generic message. Will keep prompting user until a valid number is entered.
	 * @return user's input
	 */
	public static double getDouble(){
		return getDouble("Enter a number");
	}
	
	/**
	 * Prompt user to enter a double. Will keep prompting user until a valid number is entered. 
	 * @param prompt the message to display to the user
	 * @return the user's input
	 */
	public static double getDouble(String prompt){
		boolean valid = false;
		double number = 0;
		while(!valid) {
			String entered = getString(prompt);
			try {
				number = Double.parseDouble(entered);
				valid = true;
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "You must enter a valid number!", "Input Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return number;
	}
	
}
