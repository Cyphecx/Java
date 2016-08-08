package summer2014_2015;
import java.util.Scanner;


public class decryption {
	static Scanner scan = new Scanner(System.in);
	static String input;
	static int input2;
	public static void main(String[] args) {
		input2=scan.nextInt();
		while(input2>=27||input2<=0){
			System.out.println("That is a bad number choose a different one");
		}
		input = scan.nextLine();
		String shifted = "";
		for(int i=0;i<input.length();i++){
			char newChar = input.charAt(i);
			if((input.charAt(i)<=97||input.charAt(i)<=97+(input2-1))&&Character.isLetter(input.charAt(i))&&Character.isLowerCase(input.charAt(i))){
				int temp=(int)input.charAt(i);
				newChar= (char)(123-(input2-(temp-97)));
			}
			else if(input.charAt(i)!=' '&&input.charAt(i)!='?') {
				newChar-=input2;
			}
			shifted=shifted+newChar;
		}
		System.out.println(shifted);
	}
}
