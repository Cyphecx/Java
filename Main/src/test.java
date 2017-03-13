import java.util.ArrayList;
import java.util.HashMap;
public class test {

	public static void main(String[] args) {
		ArrayList<Long> list = utils.primeFactor.factor(8);
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		HashMap<Long,Integer> map = new HashMap<Long, Integer>();
		for(int i = 0; i < list.size(); i++){
			if(map.get(list.get(i)) != null){
				map.put((Long) list.get(i), map.get(i)+1);
			}
			else{
				map.put((Long) list.get(i), 1);
			}
		}
		System.out.println(map.keySet());
		
	}

}
