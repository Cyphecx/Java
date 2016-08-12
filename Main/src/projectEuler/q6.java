package projectEuler;

public class q6 {

//Sum square difference
//Problem 6
//The sum of the squares of the first ten natural numbers is,
//
//1^2 + 2^2 + ... + 10^2 = 385
//The square of the sum of the first ten natural numbers is,
//
//(1 + 2 + ... + 10)^2 = 55^2 = 3025
//Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
//
//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
	
	public static void main(String[] args) {
		System.out.println("Answer: " + (squareOfSums(100)-sumOfSquares(100)));
	}
	public static int sumOfSquares(int quantity){
		int total=0;
		for(int i = 1; i <= quantity; i++){
			total = total + (int)(Math.pow(i, 2));
		}
			
		return total;
		
	}
	public static int squareOfSums(int quantity){
		int total=0;
		for(int i = 1; i <= quantity; i++){
			total += i;
		}
		total = (int) Math.pow(total, 2);
		return total;
	}
}
