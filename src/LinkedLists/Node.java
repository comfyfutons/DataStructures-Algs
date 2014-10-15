package LinkedLists;

import java.util.Hashtable;

public class Node {
	// Class Variables
	public int data;
	public Node next;
	
	// Constructor
	public Node(int data){
		this.data = data;
	}
	
	/*
	 * appendToTail Method: appends a node containing int data
	 * to the end of the linked list starting from current node
	 */
	public void appendToTail(int data){
		Node current = this;
		while(current.next != null){
			current = current.next;
		}
		current.next = new Node(data);
	}
	
	/*
	 * deleteNode Method: deletes the first occurrences of a node in the
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
				return this;
			}
			current = current.next;
		}
		return this;
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
	 * Question 2.1
	 * deleteDups Method: deletes duplicate entries in an unsorted
	 * linked list
	 */
	
	public Node deleteDups(){
		Hashtable repeats = new Hashtable();
		Node current = this;
		Node previous = null;
		
		while(current != null){
			if(repeats.containsKey(current.data)){
				previous.next = current.next;
			} else{
				repeats.put(current.data, true);
				previous = current;
			}
			current = current.next;
		}
		return this;
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
	 * Question 2.4
	 * partition Method: separates a linked list into values
	 * greater than and less than a given integer pivot value 
	 * then combines the lists together
	 */
	public Node partition(int pivot){
		Node left = null;
		Node leftRoot = null;
		Node right = null;
		Node rightRoot = null;
		Node main = this;
		
		while(main != null){
			if(main.data < pivot){
				if(left != null){
					left.next = main;
					left = left.next;
				} else{
					left = main;
					leftRoot = left;
				}
			} else{
				if(right != null){
					right.next = main;
					right = right.next;
				} else{
					right = main;
					rightRoot = right;
				}
			}
			main = main.next;
		}
		if(leftRoot == null){
			return rightRoot;
		} else{
			if(right != null){
				right.next = null;
				left.next = rightRoot;
			}
			return leftRoot;
		}
	}
	
	/*
	 * Question 2.6
	 * findBegining Method: Find where a linked list loop starts
	 */
	public Node findBegining(Node list){
		Node slow = list;
		Node fast = list;
		
		while(fast!= null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				break;
			}
		}
		
		if(fast == null || fast.next == null){
			return null;
		}
		
		slow = list;
		while(slow!= fast){
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}
	
	/*
	 * isLooped Method: checks if a linked list has a loop
	 */
	public boolean isLooped(Node list){
		Node slow = list;
		Node fast = list;
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		}
		
		return false;
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

	//testing toString for looping
	public void toString2(){
		int counter = 0;
		Node current = this;
		while(current.next != null && counter <= 100){
			System.out.println(current.data);
			current = current.next;
			counter++;
		}
	}
	
}
