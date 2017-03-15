package projectEuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class q12{
	public static void main(String[] args){
		int divs = 0;
		int n = 10;
		while(divs < 500){
			n++;
			divs = 1;
			ArrayList<Long> list = utils.primeFactor.factor((n * (n + 1))/2);
			System.out.println("here");
			HashMap<Long,Integer> map = new HashMap<Long, Integer>();
			for(int i = 0; i < list.size(); i++){
				if(map.get(list.get(i)) != null){
					map.put((Long) list.get(i), map.get(list.get(i))+1);
				}
				else{
					map.put((Long) list.get(i), 1);
				}
			}
			Set<Long> arr = map.keySet();
			System.out.print((n * (n+1)/2) + ": ");
			for(Long i : arr){
				System.out.print(i + "^" + map.get(i) + " ");
				divs *= (map.get(i)+1);
			}
			System.out.println(divs);
		}
		System.out.println((n * (n + 1))/2);
	}

}
