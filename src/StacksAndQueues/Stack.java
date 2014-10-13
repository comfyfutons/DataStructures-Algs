package StacksAndQueues;

import LinkedLists.Node;

/*
 * Stack Class: Basic stack implemented using a singly linked list.
 * This class contains a push, pop, peek, and a toString method. 
 */
public class Stack {
	private Node top;
	
	public int pop(){
		if(top == null){
			return -1;
		} else{
			int topData = top.data;
			top = top.next;
			return topData;
		}
	}
	
	public void push(int data){
		Node newTop = new Node(data);
		newTop.next = top;
		top = newTop;
	}
	
	public int peek(){
		return top.data;
	}
	
	public String toString(){
		StringBuffer result = new StringBuffer();
		Node tempTop = top;
		while(tempTop != null){
			result.append(tempTop.data);
			tempTop = tempTop.next;
		}
		return result.toString();
	}
}
