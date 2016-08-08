package summer2014_2015;

import java.util.Scanner;

public class Equilateral_Triangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int d = 1;
		int w = scan.nextInt();
		int f = w;
		for (int x = 0; x < w; x ++){
			System.out.println("");
			for (int e = 0; e < f; e ++){
				System.out.print("  " );

			} 
			f --;
			for (int e = 0; e < d; e ++){
				System.out.print("* " );
			}
			d++;

		} 
		for (int x = 0; x < w; x ++){
			System.out.println("");
	
			for (int e = 0; e < f; e ++){
				System.out.print("* " );
			} 
			f ++;
		}
	} 
}


