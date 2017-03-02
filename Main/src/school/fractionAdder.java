package school;
import java.util.Scanner;

public class fractionAdder {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter numerator 1");
		int num1 = Integer.parseInt(scan.nextLine());
		System.out.println("Please enter denominator 1");
		int den1 = Integer.parseInt(scan.nextLine());
		System.out.println("Please enter numerator 2");
		int num2 = Integer.parseInt(scan.nextLine());
		System.out.println("Please enter denominator 2");
		int den2 = Integer.parseInt(scan.nextLine());
		int factor = 1;
		int factor2 = 1;
		while((den1 * factor)%den2 != 0){
			factor++;
		}
		System.out.println(factor);
		while((den2 * factor2)%den1 != 0){
			factor2++;
		}
		int aDen = den1 * factor;
		int aNum = num1 * factor + num2 * factor2;
		aDen /= gcf(aNum, aDen);
		aNum /= gcf(aNum, aDen);
		System.out.println(num1 + "/" + den1 + " + " + num2 + "/" + den2 + " = " + aNum + "/" + aDen);
	}
	public static int gcf(int n1, int n2){
		int gcf = 1;
		int ctr = 1;
		int smaller = n1;
		if(n2 < n1){
			smaller = n2;
		}
		while(ctr < smaller){
			if(n1 % ctr == 0 && n2 % ctr == 0 && ctr > gcf){
				gcf = ctr;
			}
			ctr++;
		}
		return gcf;
	}
}
