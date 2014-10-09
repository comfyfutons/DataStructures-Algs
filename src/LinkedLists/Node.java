package LinkedLists;

public class Node {
	// Class Variables
	int data;
	Node next;
	
	// Constructor
	public Node(int data){
		this.data = data;
	}
	
	/*
	 * appendToTail Method: appends a node containing int data
	 * to the end of the linked list starting from current node
	 */
	public void appendtoTail(int data){
		Node current = this;
		while(current.next != null){
			current = current.next;
		}
		current.next = new Node(data);
	}
	
	/*
	 * deleteNode Method: deletes the first occurences of a node in the
	 * linked list starting from current node
	 */
	public Node deleteNode(int data){
		Node current = this;
		if(current.data == data){
			return current.next;
		}
		while(current.next != null){
			if(current.next.data == data){
				current.next = current.next.next;
				return current;
			}
			current = current.next;
		}
		return current;
	}
	
	
	/*
	 * length Method: returns the length of the linked list
	 */
	public int length(){
		int counter = 1;
		Node current = this;
		while(current.next != null){
			current = current.next;
			counter++;
		}
		return counter;
	}
	
	/*
	 * Question 2.2
	 * kthToLast Method: finds the kth to the last node in a linked list
	 * Returns -1 if k is greater than the linked list length
	 */
	public int kthToLast(int k){
		Node current = this;
		int length = this.length();
		
		if(k > length || k < 0){
			return -1;
		}
		
		for(int i = 0; i < length - 1 - k; i++){
			current = current.next;
		}
		return current.data;
	}
	
	public int kthToLast2(int k){
		Node current = this;
		Node kCurrent = this;
		int kCounter = k + 1;
		if(k < 0){
			return -1;
		}
		while(current.next != null){
			current = current.next;
			if(kCounter > 0){
				kCounter--;
			}
			if(kCounter == 0){
				kCurrent = kCurrent.next;
			}
		}
		if(kCounter == 0){
			return kCurrent.data;
		} else{
			return -1;
		}
	}
	
	
	/*
	 * toString Method: Returns a string representation of the
	 * linked list from current node to end
	 */
	public String toString(){
		StringBuffer toString = new StringBuffer();
		Node current = this;
		while(current.next != null){
			toString.append(current.data);
			toString.append(", ");
			current = current.next;
		}
		toString.append(current.data);
		return toString.toString();
	}
	
}
