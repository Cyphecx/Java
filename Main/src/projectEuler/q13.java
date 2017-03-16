package projectEuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class q13 {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(new File("resources/euler/150digitnum_q13")));
		ArrayList<BigInteger> nums = new ArrayList<BigInteger>();
		String x = "";
		while(!((x = reader.readLine()) == null)){
			nums.add(new BigInteger(x));
		}
		BigInteger ans = new BigInteger("0");
		for(BigInteger i : nums){
			ans = ans.add(i);
		}
		System.out.println(ans);
		
	}
}
