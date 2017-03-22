package projectEuler;

import java.math.BigInteger;

public class q16 {
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		String num = new BigInteger("2").pow(1000).toString();
		long ans = 0;
		char[] arry = num.toCharArray();
		System.out.println(arry.length);
		for(char i : arry){
			System.out.println(i);
			ans= ans + i;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("The answer is: " + ans + ". Found in " + ((double)(endTime - startTime)/1000) + " seconds");
	}
}
