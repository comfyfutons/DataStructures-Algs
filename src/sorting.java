
public class sorting {
	
	/*
	 * Start Merge Sort Algorithm
	 * Merge sort recursively breaks an unsorted array down into lists with 1 
	 * element. A single element array by definition is sorted so at that point
	 * a merge function takes the now sorted lists and merges them into larger
	 * sorted lists till a full sorted list has been reached.
	 */
	public void mergeSort(int[] list){
		int[] tempList = new int[list.length];
		mergeSort(list, tempList, 0, list.length - 1);
	}
	
	private void mergeSort(int[] list, int[] tempList, int start, int end){
		if(start < end){
			int middle = (start + end) / 2;
			
			// recursive calls splitting up list into single integer lists
			mergeSort(list, tempList, start, middle);
			mergeSort(list, tempList, middle + 1, end);
			
			// merges now sorted lists into larger sorted lists
			merge(list, tempList, start, middle, end);
		}
	}
	
	private void merge(int[] list, int[] tempList, int start, int middle, int end){
		// populate tempList with current working values
		for(int i = start; i <= end; i++){
			tempList[i] = list[i];
		}
		
		// variables to keep track of positions in the first and second lists to be merged
		int firstPos = start;
		int secondPos = middle + 1;
		int resultPos = start;
		
		// copies values from temp list over into sorted positions in main list
		while(firstPos <= middle && secondPos <= end){
			if(tempList[firstPos] < tempList[secondPos]){
				list[resultPos] = tempList[firstPos];
				firstPos++;
			} else{
				list[resultPos] = tempList[secondPos];
				secondPos++;
			}
			resultPos++;
		}
		
		// copies remaining values after end of first or second merge list has been reached
		int remaining = middle - firstPos;
		for(int i = 0; i <= remaining; i++){
			list[resultPos + i] = tempList[firstPos + i];
		}
		
	}
	/*
	 * End Merge Sort Algorithm
	 */
	
	/*
	 * Start Quick Sort Algorithm
	 * Quick sort chooses a pivot point from the center of the list and moves all the 
	 * larger values to the right and all the lower values to the left. it does this 
	 * by incrementing up from the left and down from the right till it finds values 
	 * less and greater than the pivot. It then swaps these values and continues 
	 * searching till it reaches the center. Once the pivot is in the correct position 
	 * with all values less than it on the left and all values greater on the right it 
	 * recursively searches the left and right side with the same function.
	 */
	public void quickSort(int[] list){
		int left = 0;
		int right = list.length - 1;
		quickSort(list, left, right);
	}
	
	private void quickSort(int[] list, int left, int right){
		int index = partition(list, left, right);
		if(left < index - 1){
			quickSort(list, left, index - 1);
		}
		if(index < right){
			quickSort(list, index, right);
		}
	}
	
	private int partition(int[] list, int left, int right){
		int pivot = list[(left + right) / 2];
		
		while(left <= right){
			while(list[left] < pivot){
				left++;
			}
			while(list[right] > pivot){
				right--;
			}
			
			if(left <= right){
				swap(list, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	private void swap(int[] list, int left, int right){
		int temp = list[left];
		list[left] = list[right];
		list[right] = temp;
	}
	/*
	 * End Quick Sort Algorithm
	 */
	
	// printList Method: prints an integer array
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
