package Summer2014_2015;

public class Solid_Diamond {
	public static void main(String[] args) {
		int d = 1;
		int w = st.Prompt.getInt();
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
			d = d + 2;

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
			}
			d = d - 2;

		}
	}
}
