package Old_Code;

public class Hollow_hexegon {
	public static void main(String[] arg0){
		int d = 1;
		int o = 5;
		int gra = o;
		int v = 0;
		int bd=1;
		for(int x = 0; x<o; x++){
			System.out.println(" ");
			for(int j = 0; j < gra; j++){
				System.out.print("  ");
				/*for(int b = 0; b<bd; b++){
					System.out.println("  ");
				}
				bd++;*/
			}System.out.print("* " );
			gra--;
		}
		for (int x = 0; x <o; x ++){
			System.out.println("");
			for (int e = 0; e < gra; e ++){
				System.out.print("* " );

			} 
			gra --;
			for (int e = 0; e < d; e ++){
				System.out.print("  " );

			}System.out.print("* " );
			d++;

		}
	}
}
