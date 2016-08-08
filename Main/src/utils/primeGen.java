package utils;

import java.util.ArrayList;

public class primeGen {
	public static ArrayList<Integer> primes(int max){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		boolean[] primality = new boolean[max];
		for(int i = 2; i < primality.length; i++){
			primality[i] = true;
		}
		for(int i = 2; i < max; i++){
			if(primality[i] == true){

				for(int z = 2; z*i < max; z++){
					primality[z*i] = false;
				}
			}
		}
		for(int i = 0; i < primality.length; i++){
			if(primality[i] == true){
				primes.add(i);
			}
		}
		return primes;
	}
}
