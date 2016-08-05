package Summer2014_2015;
import st.Prompt;


public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Answer = 0;
		System.out.println (" Enter 1st number");
		int Wyatt1 = Prompt.getInt();
		System.out.println ("Enter 2nd number");
		int Wyatt2 = Prompt.getInt();
		System.out.println ("Enter number for operation 1: addidtion 2: subtraction 3: multiplication 4: division");
		int Wyatt3 = Prompt.getInt();

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
