package projectEuler;

import java.math.BigInteger;

public class q15 {
//	Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
//
//
//	How many such routes are there through a 20×20 grid?
	public static void main(String[] args) {
		BigInteger n = factorial(new BigInteger("40"));
		BigInteger k = factorial(new BigInteger("20"));
		System.out.println("There are: "+n.divide((k.multiply( k))) + " combinations");
	}
	public static BigInteger factorial(BigInteger in){
		if(in.longValue() > 1){
			return in.multiply(factorial( in.subtract( new BigInteger("1"))));	
		}
		else{
			return in;
		}
	}
}
