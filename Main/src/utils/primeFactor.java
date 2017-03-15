package utils;

import java.util.ArrayList;

public class primeFactor {
	static ArrayList ans = new ArrayList();
	public static ArrayList factor(long n){
		long i = 2;
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
		long i = 2;
		long num = 2;
		while(n % num != 0){
			if(n % i == 0){
				num = i;
			}
			i++;
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
