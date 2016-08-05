package Summer2014_2015;
import java.util.Random;
import st.Prompt;


public class fancyrandomizor {
	static Random rand = new Random();
	static int x = rand.nextInt(99);
	static int input = Prompt.getInt("What % would you like?");
	static String option1 = Prompt.getString("What should happen if the minority wins?");
	static String option2 = Prompt.getString("What happens otherwise?");
	public static void main(String[] args) {
		if(input<=50){
			if(x<=input){
				System.out.print("This will happen:"+option1);
			}
			else{
				System.out.print("This will happen:"+option2);
			}
		}
		if(input>50){
			if(x>=input){
				System.out.print("This will happen:"+option1);
			}
			else{
				System.out.print("This will happen:"+option2);
			}
		}

	}

}
