import java.util.ArrayList;

import java.util.HashMap;
import java.util.Set;
public class test {

	public static void main(String[] args) {
		int largestChain = 0;
		int ans = 0;
		long b = 837799;
		int ctr = 0;
		while(b > 1){
			System.out.println(b);
			if(b % 2 == 0){
				b = b / 2;
				ctr++;
			}
			else if(b % 2 != 0){
				b = (b * 3)+1;
				ctr++;
			}
			//System.out.println(b);
		}
		System.out.println(ctr);
	}

}
