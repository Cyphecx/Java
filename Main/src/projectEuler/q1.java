package projectEuler;

import java.util.ArrayList;
// Question
// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
// Find the sum of all the multiples of 3 or 5 below 1000.
public class q1 {

	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 1; i < 1000; i++){
			System.out.println(i);
			if(i%5==0){
				l.add(i);
			}
			else if(i%3==0){
				l.add(i);
			}
		}
		int tot=0;
		for(int i = 0; i < l.size(); i++){
			tot=tot+l.get(i);
		}
		System.out.println(tot);
	}

}
