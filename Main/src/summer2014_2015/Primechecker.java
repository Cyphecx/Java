package summer2014_2015;

public class Primechecker {
	public static boolean isPrime2(long h){
		if(h!=2&&h%2==0)
			return false;
		for(int i=3;i<=Math.sqrt(h);i+=2){
			if(h%i==0)
				return false;
		}
		return true;
	}
}
