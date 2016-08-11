package projectEuler;

import java.util.ArrayList;

//Largest prime factor
//Problem 3
//The prime factors of 13195 are 5, 7, 13 and 29.
//
//What is the largest prime factor of the number 600851475143 ?

public class q3 {
	public static void main(String[] args){
		ArrayList<Long> answer = primeFactorFinder(600851475143L);
		System.out.println(answer);
	}
	public static ArrayList<Long> primeFactorFinder(long num){
		ArrayList<Long> primeFactors = new ArrayList<Long>();
		for(long i = 1; i < num; i++){
			if(num % i == 0 && primeCheck(i) && i % 7 != 0){
				primeFactors.add(i);
			}
			if(i % 100000000 == 0)
				System.out.println(i);
		}
		return primeFactors;
		
	}
	public static boolean primeCheck(long num){
		for(long i = 2; i<num; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
}
