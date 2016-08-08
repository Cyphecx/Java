package projectEuler;

import java.util.ArrayList;

public class q7 {
// Question
//	By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
//	What is the 10 001st prime number?
	public static void main(String[] args) {
		ArrayList list = utils.primeGen.primes(30000000);
		System.out.println(list.get(10000));
	}
}
