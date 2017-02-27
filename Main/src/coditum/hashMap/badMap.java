package coditum.hashMap;

import coditum.BinarySearchTree.BalancedBinarySearchTree;

public class badMap<T extends Comparable<T>, K> {
	
	
	BalancedBinarySearchTree<keyValue<T, K>> tree = new BalancedBinarySearchTree<keyValue<T, K>>();
	public badMap(){
		
	}
	public void insert(T key, K data){
		keyValue<T, K> temp = new keyValue<T, K>(key,data);
		tree.insert(temp);
	}
	public void print(){
		tree.treePrint();
	}
	public keyValue find(T target){
		return tree.find(new keyValue(target, null));
	}
	public void remove(T target){
		tree.remove(new keyValue(target, null));
	}
}
