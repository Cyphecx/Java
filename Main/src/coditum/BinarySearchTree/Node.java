package coditum.BinarySearchTree;

public class Node <T>{
	T data;
	Node<T> nextN0;
	Node<T> nextN1;
	int height;
	public Node(T data, Node<T> nextN0, Node<T> nextN1, int height){
		this.data = data;
		this.height = height;
		this.nextN0 = nextN0;
		this.nextN1 = nextN1;
	}
	public int getheight() {
		return height;
	}
	public void setheight(int height) {
		this.height = height;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNextN0() {
		return nextN0;
	}
	public void setNextN0(Node<T> nextN0) {
		this.nextN0 = nextN0;
	}
	public Node<T> getNextN1() {
		return nextN1;
	}
	public void setNextN1(Node<T> nextN1) {
		this.nextN1 = nextN1;
	}
}