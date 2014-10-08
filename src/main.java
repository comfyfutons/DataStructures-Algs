
public class main {

	public static void main(String args[]){
		
		sorting sorter = new sorting();
		ArraysAndStrings arraysAndStrings = new ArraysAndStrings();
		
		int[] list = {57, 70, 97, 38, 63, 21, 85, 68, 76, 9, 81, 36, 55, 79, 74, 85, 16, 61, 77, 49, 24};
		int[] list2 = {38, 27, 43, 3, 9, 82, 10};
		

		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		arraysAndStrings.rotate(matrix);
		
		System.out.println(matrix[0][2]);
		
		printMatrix(matrix);

		
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


