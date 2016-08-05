package Summer2014_2015;


import javax.swing.JOptionPane;

public class Prompt {
	
	public static int getInt(String message){
		String x=JOptionPane.showInputDialog(message);
		try{
		return Integer.parseInt(x);
		}
		catch(NumberFormatException e){
			System.err.println("That is not a number!");
		}
		return 0;
		
	}
	public static int getInt(){
		return getInt("Enter a number:");
	}
	public static String getString(String message){
		String x=JOptionPane.showInputDialog(message);

		return x;
	}
	public static String getString(){
		return getString("Enter a String:");
	}
	public static boolean getBoolean(String message){
		String x=JOptionPane.showInputDialog(message);
		return Boolean.parseBoolean(x);
		//return false;
	}
	public static boolean getBoolean(){
		return getBoolean("Enter a boolean:");
	}
	public static double getDouble(String message){
		String x=JOptionPane.showInputDialog(message);
		try{
			return Double.parseDouble(x);
		}
		catch(NumberFormatException e){
			System.err.println("That is not a number!");
			return 0;
		}
		
	}
	public static double getDouble(){
		return getDouble("Enter a double:");
	}
}
