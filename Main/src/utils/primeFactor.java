package utils;

import java.util.ArrayList;

public class primeFactor {
	static ArrayList<Long> ans = new ArrayList<Long>();
	public static ArrayList<Long> factor(long n){
		long num = 2;
		while(n % num != 0){
			num++;
		}
		if(checkPrime.isPrime2(num)){
			ans.add(num);
		}
		else{
			factor2(num);
		}
		if(checkPrime.isPrime2((n/num))){
			ans.add(n/num);
		}
		else{
			factor2(n/num); 
		}
		return ans;
	}
	public static void factor2(long n){
		long num = 2;
		while(n % num != 0){
			num++;
		}
		if(checkPrime.isPrime2(num)){
			ans.add(num);
		}
		else{
			factor2(num);
		}
		if(checkPrime.isPrime2(n/num)){
			ans.add(n/num);
		}
		else{
			factor2(n/num);
		}
	}
}
