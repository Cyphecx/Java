package utils;

import java.util.ArrayList;

public class fibonacci {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int num1 = 0;
		int num2 = 1;
		while(num2 < 4000000){
			int temp = num2;
			num2 += num1;
			num1 = temp;
			if(num2 % 2 == 0){
				nums.add(num2);
			}
		}
		System.out.println(nums);

	}

}
