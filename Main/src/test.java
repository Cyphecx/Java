import java.util.ArrayList;

import java.util.HashMap;
import java.util.Set;
public class test{

	public static void main(String[] args) {
		ArrayList<Long> list = utils.primeFactor.factor(600851475143L);
		for(Long i : list){
			System.out.println("Factor: " + i);
		}
	}

}
