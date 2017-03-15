package projectEuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class q12{
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		int divs = 0;
		int n = 8;
		HashMap<Long,Integer> map = new HashMap<Long, Integer>();
		ArrayList<Long> list = null;
		while(divs < 500){
			n++;
			divs = 1;
			map.clear();
			list = utils.primeFactor.factor((n * (n + 1))/2);
			for(int i = 0; i < list.size(); i++){
				if(map.get(list.get(i)) != null){
					map.put((Long) list.get(i), map.get(list.get(i))+1);
				}
				else{
					map.put((Long) list.get(i), 1);
				}
			}
			Set<Long> arr = map.keySet();
			for(Long i : arr){
				divs *= (map.get(i)+1);
			}
			list.clear();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("It took " + ((double)(endTime - startTime)/1000) + " seconds to find the answer: " + ((n * (n + 1))/2));
	}

}
