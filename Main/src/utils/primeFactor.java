package utils;

import java.util.ArrayList;

public class primeFactor {
	static ArrayList ans = new ArrayList();
	public static ArrayList factor(long n){
		for(long i = 2; i < Math.sqrt(n); n++){
			if(n % i == 0){
				if(checkPrime.isPrime2(i)){
					ans.add(i);
				}
				else{
					factor2(i);
				}
				if(checkPrime.isPrime2(n / (n/i))){
					ans.add(n/i);
				}
				else{
					factor2(n/i);
				}
			}
		}
		return null;
	}
	public static void factor2(long n){
		
	}
}
