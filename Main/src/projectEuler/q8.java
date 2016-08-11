package projectEuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Largest product in a series
//Problem 8
//The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
//
//
//Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?


public class q8 {

	public static void main(String[] args) throws IOException {
		long largest = 0;
		BufferedReader reader = new BufferedReader(new FileReader(new File("resources/euler/largestProductInASeries.txt")));
		String str = "";
		while(!((str = reader.readLine()) == null)){
			char[] ary = str.toCharArray();
			for(int i = 0; i < ary.length-12; i++){
				long prod=1;
				for(int z = 0; z < 13; z++){
					prod = prod * Integer.parseInt(Character.toString(ary[i+z]));
				}
			
				if(prod > largest){
					largest = prod;
				}
			}
		}
		System.out.println("Largest Product in a Series : " + largest);
	}

}
