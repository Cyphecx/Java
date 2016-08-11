package projectEuler;

//Smallest multiple
//Problem 5
//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	
public class q5 {

	public static void main(String[] args) {
		for(long i = 1; i < 1000000000000L; i++){
			if(i % 10000 == 0){
				System.out.println(i);
			}
			if(isDivisable(i)){
				System.out.println("\n Number: "+i);
				break;
			}
		}
	}
	public static boolean isDivisable(long num){

		for(int i = 1; i < 21; i++){
			if(num%i > 0){
				return false;
			}
		}
		return true;
	}
}
