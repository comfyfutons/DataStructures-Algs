package StacksAndQueues;

import LinkedLists.Node;

public class Queue {
	Node first, last;
	
	public int pop(){
		if(first == null){
			return -1;
		} else{
			int firstData = first.data;
			first = first.next;
			return firstData;
		}
	}
	
	public void push(int data){
		Node newLast = new Node(data);
		
		if(last == null){
			last = newLast;
			first = last;
		} else{
			last.next = newLast;
			last = last.next;
		}
	}
	
	public int peek(){
		return first.data;
	}
	
	public String toString(){
		StringBuffer result = new StringBuffer();
		Node tempFirst = first;
		while(tempFirst != null){
			result.append(tempFirst.data);
			tempFirst = tempFirst.next;
		}
		return result.toString();
	}

}
