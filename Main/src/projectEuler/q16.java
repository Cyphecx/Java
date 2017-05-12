package projectEuler;

import java.math.BigInteger;

public class q16 {
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		BigInteger num = new BigInteger("2").pow(1000);
		BigInteger ans = BigInteger.ZERO;
		for(int i = 0; i < num.toString().length(); i++){
			ans= ans.add(num.mod(new BigInteger("10")));
			num.divide(BigInteger.TEN);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("The answer is: " + ans + ". Found in " + ((double)(endTime - startTime)/1000) + " seconds");
	}
}
