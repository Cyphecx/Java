package coditum.BinarySearchTree;

public class BinarySearchTree <T extends Comparable <? super T>>{
	Node<T> head;
	T[] data;

	public BinarySearchTree(){
		head = null;

	}

	public void insert(T dataP){
		Node<T> currNode = head;

		if(currNode != null){
			if(currNode.data.compareTo(dataP) < 0){
				if(currNode.nextN0 == null){
					if(currNode.height >= 2){
						currNode.height += 1;
					}
					currNode.nextN0 = new Node<T> (null, null, null, 1);
				}
				insert(dataP, currNode.nextN0);
			}
			if(currNode.data.compareTo(dataP) > 0){
				if(currNode.nextN1 == null){
					if(currNode.height >= 2){
						currNode.height += 1;
					}
					currNode.nextN1 = new Node<T> (null, null, null, 1);
				}
				insert(dataP, currNode.nextN1);	
			}
		}
		else{
			head = new Node<T>(dataP, null, null, 0);
			return;
		}
		int nextHeight = 0;
		if((currNode.nextN0 != null)&&(currNode.nextN0.height >= currNode.nextN1.height)){
			nextHeight = currNode.nextN0.height;
		}
		else if((currNode.nextN0.height < currNode.nextN1.height)&&(currNode.nextN1 != null)){
			nextHeight = currNode.nextN1.height;
		}
		currNode.height = nextHeight+1;
	}

	private void insert(T dataP, Node<T> currNode){
		if(currNode.data != null){
			if(currNode.data.compareTo(dataP) < 0){
				if(currNode.nextN0 == null){
					if(currNode.height >= 2){
						currNode.height += 1;
					}
					currNode.nextN0 = new Node<T> (null, null, null, 1);
				}
				insert(dataP, currNode.nextN0);
			}
			if(currNode.data.compareTo(dataP) > 0){
				if(currNode.nextN1 == null){
					if(currNode.height >= 2){
						currNode.height += 1;
					}
					currNode.nextN1 = new Node<T> (null, null, null, 1);
				}
				insert(dataP, currNode.nextN1);	
			}
		}
		else{
			currNode.data = dataP;
			return;
		}
	}
	
	public void print(){
		Node<T> currNode = head;
		System.out.println(currNode.data);
		if(currNode.nextN0 != null){
			print(currNode.nextN0);
		}
		if(currNode.nextN1 != null){
			print(currNode.nextN1);
		}
		return;
	}

	private void print(Node<T> currNode){
		System.out.println(currNode.data);
		if(currNode.nextN0 != null){
			print(currNode.nextN0);
		}
		if(currNode.nextN1 != null){
			print(currNode.nextN1);
		}
		return;
	}
	
	public void treePrint(){
		treePrint(head,0);
	}
	private void treePrint(Node<T> currentNode, int counter){
		if(currentNode == null){
		return;
		}
		
		treePrint(currentNode.nextN0, counter+1);
		for(int i = 0; i < counter; i++){
			System.out.print("\t");
		}
		System.out.println(currentNode.data + " :Depth: "+currentNode.height);
		treePrint(currentNode.nextN1,counter+1);
	}
}