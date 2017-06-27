package summer2017;

public class test {

	public static void main(String[] args) {
		HashMap test = new HashMap(4);
		for(int i = 0; i < 20; i++){
			test.put(""+i, i);
		}
		test.remove("9");
		System.out.println(test.get("9")+ ", size: "+test.size());
		System.out.println(test.get("19")+ ", size: "+test.size());
		test.remove("19");
		System.out.println(test.get("9")+ ", size: "+test.size());
	}

}
