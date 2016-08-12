package projectEuler;
import java.util.ArrayList;
import utils.primeGen;
public class q10 {

//Summation of primes
//Problem 10
//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//
//Find the sum of all the primes below two million.
	
	public static void main(String[] args) {
		ArrayList<Integer> primes = primeGen.primes(2000000);
		long sum = 0;
		for(int i = 0; i < primes.size(); i++){	
			sum += (primes.get(i));
		}
		System.out.println(sum);
	}

}