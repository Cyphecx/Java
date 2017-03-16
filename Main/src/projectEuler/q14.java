package projectEuler;

public class q14 {

//	The following iterative sequence is defined for the set of positive integers:
//
//		n → n/2 (n is even)
//		n → 3n + 1 (n is odd)
//
//		Using the rule above and starting with 13, we generate the following sequence:
//
//		13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
//		It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
//
//		Which starting number, under one million, produces the longest chain?
//
//		NOTE: Once the chain starts the terms are allowed to go above one million.
	
	public static void main(String[] args) {
		int largestChain = 0;
		int ans = 0;
		long startTime = System.currentTimeMillis();
		for(int i = 1; i < 1000000; i++){
			long b = i;
			int ctr = 0;
			while(b > 1){
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
			if(ctr > largestChain){
				largestChain = ctr;
				ans = i;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("The chain that produces the largest number is: " + ans + " with a chain of " + largestChain + " operations in " + ((double)(endTime - startTime)/1000) + " seconds");
	}

}
