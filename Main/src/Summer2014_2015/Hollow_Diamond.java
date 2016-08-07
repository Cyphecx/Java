package Summer2014_2015;

import javax.swing.JOptionPane;

public class Hollow_Diamond {
	public static void main(String[] args) {
		int d = 1;
		int w = Integer.parseInt(JOptionPane.showInputDialog("Scale Factor"));
		int f = w;
		int v = 0;

		for (int x = 0; x < w; x ++){
			System.out.println("");
			for (int e = 0; e < f; e ++){
				System.out.print("  " );				
			} 
			f --;
			for (int e = 0; e < d; e ++){
				System.out.print("* " );
				for (e = 1; e < v; e ++){
					System.out.print("  " );
				} 
				v=v+2;
			}
			for(int g = 0; g < 1; g++){
				if(x !=0)
					System.out.print("* ");
			}
		} 
		f = w;
		for (int x = -1; x < w; x ++){
			System.out.println("");
			for (int e = w; e < f; e ++){
				System.out.print("  " );

			} 
			f ++;

			for (int e = 0; e < d; e ++){
				System.out.print("* " );
				for (e = 1; e < v; e ++){
					System.out.print("  " );
				} 

				v=v-2;
				for(int g = 0; g < 1; g++){
					if(x != w-1)
						System.out.print("* ");
				}
			}
		}
	}
}