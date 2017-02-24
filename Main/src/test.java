import java.util.Scanner;

import javax.swing.JOptionPane;

public class test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(JOptionPane.showInputDialog("What do you want the hieght to be!"));
		for(int i = 0; i < input; i++){
			for(int z = 0; z < input ; z++){
				if(z < input-i-1){
					System.out.print("  ");
				}
				else{
					System.out.print("* ");
				}
			}
			for(int z = 0; z < i; z++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
