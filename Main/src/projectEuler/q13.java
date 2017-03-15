package projectEuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

//Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.

public class q13 {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader(new File("resources/euler/150digitnum_q13")));
		String largeNum = "";
		String x;
		while((x = read.readLine())!= null){
			largeNum = largeNum + x; 
		}
		System.out.print(largeNum);
		BigInteger sum = BigInteger.ZERO;


	}

}
