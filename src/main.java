import java.util.Hashtable;
import java.util.Stack;

import LinkedLists.Node;
import Sorting.Sorter;
import StacksAndQueues.Queue;
import ArraysAndStrings.ArraysAndStrings;

public class main {

	public static void main(String args[]){
		
		Sorter sorter = new Sorter();
		ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
		
		// Integer Array Examples
		int[] list = {57, 70, 97, 38, 63, 21, 85, 68, 76, 9, 81, 36, 55, 79, 74, 85, 16, 61, 77, 49, 24};
		int[] list2 = {3,3,5,6,2,2,9,10};
		
		// String and Char array examples
		String string = "Coding is wonderful and infuriating";
		char[] chars = string.toCharArray();

		// Matrix examples
		int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int[][] matrix2 = {{0,2,3,4,5}, {6,7,8,9,10}, {11,12,0,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		
		

		// Linked List examples
		Node linkedList = new Node(3);
		
		linkedList.appendToTail(1);
		linkedList.appendToTail(2);
		
		Node linkedList2 = new Node(1);
		
		linkedList2.appendToTail(2);
		linkedList2.appendToTail(3);
		linkedList2.appendToTail(4);
		linkedList2.appendToTail(5);
		
		linkedList2.next.next.next.next.next = linkedList2.next.next;
		
		
		// Stacks and Queues
		Stack stack1 = new Stack();
		stack1.push(5);
		stack1.push(9);
		stack1.push(15);
		stack1.push(3);
		
		Queue queue1 = new Queue();
		queue1.push(7);
		queue1.push(4);
		queue1.push(10);
		

		
		/*
		 * PLACE RUNNING CODE HERE
		 */
		
		
		/*
		 * PLACE RUNNING CODE HERE
		 */
	}
	
	
	
	
	
	/*
	 * printMatrix Method: prints to System.out a string 
	 * representation of a two-dimensional integer array
	 */
	public static void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	/*
	 * printList Method: prints to System.out a string 
	 * representation of an integer array
	 */
	public static void printList(int[] list){
		for(int i = 0; i < list.length; i++){
			if(i == 0){
				System.out.print("{" + list[i]);
			}
			if(i > 0 && i < list.length){
				System.out.print(", " + list[i]);
			}
		}
		System.out.println('}');
	}
	
}


