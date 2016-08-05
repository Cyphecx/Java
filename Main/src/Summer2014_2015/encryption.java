package Summer2014_2015;
import java.util.Scanner;
public class encryption {
	static Scanner scan = new Scanner(System.in);
	static String input;
	static int input2;
	public static void main(String[] args) {
		input2=st.Prompt.getInt();
		while(input2>=27||input2<=0){
			System.out.println("That is a bad number choose a different one");
			input2=st.Prompt.getInt();
		}
		input = scan.nextLine();
		String shifted = "";
		for(int i=0;i<input.length();i++){
			char newChar = input.charAt(i);
			if(input.charAt(i)>=122||input.charAt(i)>=122-input2){
				newChar=(char) (((input2-1)-((int)('z')-input.charAt(i)))+97);
			}
			else if(input.charAt(i)!=' '&&input.charAt(i)!='?') {
				newChar+=input2;
			}
			shifted=shifted+newChar;
		}
		System.out.println(shifted);
	}
}

