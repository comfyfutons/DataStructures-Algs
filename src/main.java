
public class main {

	public static void main(String args[]){
		
		sorting sorter = new sorting();
		ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
		
		int[] list = {57, 70, 97, 38, 63, 21, 85, 68, 76, 9, 81, 36, 55, 79, 74, 85, 16, 61, 77, 49, 24};
		int[] list2 = {38, 27, 43, 3, 9, 82, 10};
		
		String temp = "Coding is wonderful and infuriating";
		char[] temp2 = temp.toCharArray();

		int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int[][] matrix2 = {{0,2,3,4,5}, {6,7,8,9,10}, {11,12,0,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		
		
		
		
		printMatrix(matrix2);
		
		arraysAndStrings.setZeros(matrix2);
		
		printMatrix(matrix2);

		
	}
	
	public static void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
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


