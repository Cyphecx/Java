package projectEuler;

public class q9 {

//Special Pythagorean triplet
//Problem 9
//A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//
//a^2 + b^2 = c^2
//For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
//
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.
	
	public static void main(String[] args) {
		for(int a = 0; a < 1000; a++){
			for(int b = a+1; b < 1000; b++){
				for(int c = b+1; c < 1000; c++){
					if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && a + b + c == 1000){
						System.out.println("A: " + a + " B: " + b + " C: " + c + "| |" + (a+b+c));
						System.out.println("A * B * C = " + (a*b*c));
					}
				}
			}
		}
	}
}
