package Assorted2016;
public class Exponents {

	public static void main(String[] args){
		System.out.print(exp(3,2,1));
	}
	
	public static int exp(int base, int exponent, int curr){
		if(exponent>0){
			int b=curr*base;
			if(exponent==1){
				return b;
			}
			return exp(base,exponent-1,b);
		}
		if(exponent<0){
		return 0;
		}
		return curr;
	
	}
}
