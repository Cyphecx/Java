import java.util.ArrayList;

public class ArrayListTests {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i = 0; i<1000; i++){
			list.add((int) Math.ceil(Math.random()*10));
			System.out.println(list);
			list.clear();
			System.out.println(list);
		}
	}
}
