package coditum.BinarySearchTree;

public class BalancedBinarySearchTree <T extends Comparable <? super T>>{
	Node<T> head;
	T[] data;

	public BalancedBinarySearchTree(){
		head = null;

	}

	public void insert(T dataP){
		Node<T> currNode = head;

		if(currNode != null){
			if(currNode.data.compareTo(dataP) < 0){
				if(currNode.nextN0 == null){
					currNode.nextN0 = new Node<T> (null, null, null, currNode.height+1);
				}
				insert(dataP, currNode.nextN0);
			}
			if(currNode.data.compareTo(dataP) > 0){
				if(currNode.nextN1 == null){
					currNode.nextN1 = new Node<T> (null, null, null,currNode.height+1);
				}
				insert(dataP, currNode.nextN1);	
			}
		}
		else{
			head = new Node<T>(dataP, null, null, 0);
			return;
		}
		int nextHeight = 0;
		if(currNode.nextN1 != null && currNode.nextN0 != null && currNode.nextN0.height >= currNode.nextN1.height){
			nextHeight = currNode.nextN0.height;
		}
		else if(currNode.nextN0 != null && currNode.nextN1 != null && currNode.nextN0.height < currNode.nextN1.height){
			nextHeight = currNode.nextN1.height;
		}
		currNode.height = nextHeight+1;
		if(currNode.height > 1){
			int node0H; 
			int node1H;
			if(currNode.nextN0 != null){
				node0H = currNode.nextN0.height;
			}
			else{
				node0H = 0;
			}
			if(currNode.nextN1 != null){
				node1H = currNode.nextN1.height;
			}
			else{
				node1H = 0;
			}
			int dif = node0H - node1H;
			if(dif > 1){
				if(currNode.nextN0.nextN1 != null){
					System.out.println("Left-Right");
				}
				else{
					System.out.println("Right");
				}
			}
			if(dif < -1){
				if(currNode.nextN1.nextN0 != null){
					System.out.println("Right-Left");
				}
				else{
					System.out.println("Left");
				}
			}
		}
	}

	private void insert(T dataP, Node<T> currNode){
		if(currNode.data != null){
			if(currNode.data.compareTo(dataP) < 0){
				if(currNode.nextN0 == null){
					currNode.nextN0 = new Node<T> (null, null, null, 1);
				}
				insert(dataP, currNode.nextN0);
			}
			if(currNode.data.compareTo(dataP) > 0){
				if(currNode.nextN1 == null){
					currNode.nextN1 = new Node<T> (null, null, null,currNode.height-1);
				}
				insert(dataP, currNode.nextN1);	
			}
		}
		else{
			currNode.data = dataP;
			currNode.height = 1;
			return;
		}
		int nextHeight = 0;
		if(currNode.nextN0 != null && currNode.nextN1 != null){
			if(currNode.nextN0.height >= currNode.nextN1.height){
				nextHeight = currNode.nextN0.height;
			}
			else if(currNode.nextN0.height < currNode.nextN1.height){
				nextHeight = currNode.nextN1.height;
			}
		}
		if(currNode.nextN0 != null && currNode.nextN1 == null){
			nextHeight = currNode.nextN0.height;
		}
		if(currNode.nextN0 == null && currNode.nextN1 != null){
			nextHeight = currNode.nextN1.height;
		}
		currNode.height = nextHeight+1;
		if(currNode.nextN1 != null){
			if(currNode.height > 1){
				int node0H; 
				int node1H;
				if(currNode.nextN1.nextN0 != null){
					node0H = currNode.nextN1.nextN0.height;
				}
				else{
					node0H = 0;
				}
				if(currNode.nextN1.nextN1 != null){
					node1H = currNode.nextN1.nextN1.height;
				}
				else{
					node1H = 0;
				}
				int dif = node0H - node1H;
				if(dif > 1){
					if(currNode.nextN1.nextN0.nextN1 != null){
						System.out.println("Right-Left");
					}
					else{
						leftRotation(currNode, 1);
						System.out.println("Left");
					}
				}
				if(dif < -1){
					if(currNode.nextN1.nextN1.nextN0 != null){
						System.out.println("Left-Right");
					}
					else{
						System.out.println("Right");
					}
				}
			}
		}
		if(currNode.nextN0 != null){
			if(currNode.height > 1){
				int node0H; 
				int node1H;
				if(currNode.nextN0.nextN0 != null){
					node0H = currNode.nextN0.nextN0.height;
				}
				else{
					node0H = 0;
				}
				if(currNode.nextN0.nextN1 != null){
					node1H = currNode.nextN0.nextN1.height;
				}
				else{
					node1H = 0;
				}
				int dif = node0H - node1H;
				if(dif > 1){
					if(currNode.nextN0.nextN0.nextN1 != null){
						System.out.println("Right-Left");
					}
					else{
						System.out.println("Left");
					}
				}
				if(dif < -1){
					if(currNode.nextN0.nextN1.nextN0 != null){
						System.out.println("Left-Right");
					}
					else{
						System.out.println("Right");
					}
				}
			}
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
			System.out.print("\t\t");
		}
		System.out.println(currentNode.data.toString() + " :Height: "+currentNode.height);
		treePrint(currentNode.nextN1,counter+1);
	}
	public void leftRotation(Node root, int i){
		Node currNode;
		if(i == 1){
			currNode = root.nextN1;
		}
		if(i == 0){
			currNode = root.nextN0;
		}
		
	}
	public T find(T target){
		if(head.data.compareTo(target) == 0){
			return head.data;
		}
		else{
			find(target, head.nextN0);
			find(target, head.nextN1);
		}
		return null;
		
	}
	private T find(T target, Node<T> currNode){
		if(currNode.data.compareTo(target) == 0){
			return currNode.data;
		}
		else{
			if(currNode.data.compareTo(target) == -1){
				find(target, currNode.nextN0);
			}
			if(currNode.data.compareTo(target) == 1){
				find(target, currNode.nextN1);
			}
		}
		return null;
		
	}
	public T remove(T target){
		if(head.data.compareTo(target) == 0){
			return head.data;
		}
		else{
			remove(target, head.nextN0);
			remove(target, head.nextN1);
		}
		return null;
		
	}
	private T remove(T target, Node<T> currNode){
		if(currNode.nextN0.data.compareTo(target) == 0){
			Node<T> temp = inorderSuccessor(currNode.nextN0);
			temp.nextN0 = currNode.nextN0.nextN0;
			temp.nextN1 = currNode.nextN1.nextN1;
			currNode.nextN0 = temp;
			return currNode.data;
		}
		if(currNode.nextN1.data.compareTo(target) == 0){
			Node<T> temp = inorderSuccessor(currNode.nextN0);
			temp.nextN0 = currNode.nextN0.nextN0;
			temp.nextN1 = currNode.nextN1.nextN1;
			currNode.nextN0 = temp;
			return currNode.data;
		}
		else{
			if(currNode.data.compareTo(target) == -1){
				find(target, currNode.nextN0);
			}
			if(currNode.data.compareTo(target) == 1){
				find(target, currNode.nextN1);
			}
		}
		return null;
		
	}
	public Node<T> inorderSuccessor(Node<T> start){
		Node<T> currNode = start;
		while(currNode.nextN0 != null){
			currNode = currNode.nextN0;
		}
		return currNode;
		
		
	}
	}