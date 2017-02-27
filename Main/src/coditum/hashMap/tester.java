package coditum.hashMap;

public class tester {

	public static void main(String[] args){
		badMap<String, Integer> map = new badMap<String, Integer>();
		map.insert("kys", 10);
		map.insert("10", 131);
		map.insert("10", 2);
		map.insert("asd", 2);
		map.remove("asd");
		System.out.println(map.find("kys"));
		map.print();
	}
}
