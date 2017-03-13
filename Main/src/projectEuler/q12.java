package projectEuler;

import java.util.ArrayList;

public class q12{
	public static void main(String[] args){
		int div = 0;
		long ctr = 2;
		while(div < 500){
			div = 0;
			ArrayList list = utils.primeFactor.factor((ctr * (ctr + 1)) / 2);
			for(int i = 0; i < list.size(); i++){
				System.out.println(list.get(i));
			}
			ctr++;
		}
	}
	
}
