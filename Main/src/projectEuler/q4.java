package projectEuler;

//Largest palindrome product
//Problem 4
//Published on Friday, 16th November 2001, 06:00 pm; Solved by 308694; Difficulty rating: 5%
//A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
//
//Find the largest palindrome made from the product of two 3-digit numbers.

public class q4 {
	public static void main(String[] args){
		int largest=0;
		for(int i = 1; i < 1000; i++){
			for(int z = 1; z < 1000; z++){
				if(isPalindrome(z*i)){
					System.out.println(z*i);
					if(z*i>largest){
						largest=z*i;
					}
				}
			}
		}
		System.out.println("\n Largest Palindrome: "+largest);
		
	}
	public static boolean isPalindrome(int num){
		String str = Integer.toString(num);
		char[] ary = str.toCharArray();
		for(int i = 0; i < ary.length/2; i++){
			if(ary[i] != ary[(ary.length-1)-i]){
				return false;
			}
		}
		return true;
	}
}
