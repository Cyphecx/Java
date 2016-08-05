package Summer2014_2015;

public class Equilateral_Different {
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
			d = d + 1;

		} 
		for (int e = 0; e < d; e ++){
			System.out.print("* " );
		}
		d = d + 1;

	}
}