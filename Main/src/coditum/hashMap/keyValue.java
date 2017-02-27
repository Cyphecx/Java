package coditum.hashMap;

public class keyValue<T extends Comparable<T>, K> implements Comparable<keyValue<T,K>> {
	K data;
	T key;
	public keyValue(T key, K data){
		this.data = data;
		this.key = key;
	}
	public K getData() {
		return data;
	}
	public void setData(K data) {
		this.data = data;
	}
	public T getKey() {
		return key;
	}
	public void setKey(T key) {
		this.key = key;
	}
	public int compareTo(keyValue<T, K> o) {
		return this.key.compareTo(o.key);
	}
	public String toString(){
		return ""+this.data+" ("+this.key+")";
	}
}
