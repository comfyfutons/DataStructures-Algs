
public class ArraysAndStrings {

	/*
	 * Start Question 1.1
	 * Algorithm that determines if a string has all unique characters
	 */
	public boolean isUniqueChars(String str){
		if(str.length() > 256){
			return false;
		}
		
		boolean[] charList = new boolean[256];
		
		for(int i = 0; i < str.length(); i++){
			int value = str.charAt(i);
			if(charList[value]){
				return false;
			} else{
				charList[value] = true;
			}
		}
		return true;
	}
	/*
	 * End Question 1.1
	 */
	
	/*
	 * Start Question 1.3
	 * An algorithms that compares two strings and tells if they are permutations
	 * of each other
	 */
	public Boolean permutation(String str, String str2){
		if(str.length() != str2.length()){
			return false;
		}
		
		int[] charCount = new int[256];
		
		for(int i = 0; i < str.length(); i++){
			int value = str.charAt(i);
			charCount[value]++;
		}
		for(int i = 0; i < str2.length(); i++){
			int value = str2.charAt(i);
			if(charCount[value] <= 0){
				return false;
			} else{
				charCount[value]--;
			}
		}
		
		
		return true;
	}
	/*
	 * End Question 1.3
	 */
	
	/*
	 * Start Question 1.4
	 * Replaces the space in a string with "%20"
	 */
	public void replaceSpaces(char[] str, int length){
		// Count number of spaces
		int spaceCount = 0;
		for(int i = 0; i < length; i++){
			if(str[i] == ' '){
				spaceCount++;
			}
		}
		
		// store the final position which we write to
		int finalPos = length - 1 + spaceCount * 2;
		
		// increment through array backwards and write from the end back
		for(int i = length - 1; i >= 0; i--){
			if(str[i] == ' '){
				str[finalPos] = '0';
				finalPos--;
				str[finalPos] = '2';
				finalPos--;
				str[finalPos] = '%';
				finalPos--;
			} else{
				str[finalPos] = str[i];
				finalPos--;
			}
		}
		
	}
	/*
	 * End Question 1.4
	 */
	
	/*
	 * Start Question 1.5
	 * Compresses a string in the following way Before: "aaabbbbcddd" into a3b4c1d3
	 */
	public String compress(String str){
		if(getCompressedLength(str) >= str.length()){
			return str;
		}
		
		StringBuffer compressed = new StringBuffer();
		
		int repeated = 1;
		char current = str.charAt(0);
		for(int i = 1; i < str.length(); i++){
			if(current != str.charAt(i)){
				compressed.append(current);
				compressed.append(repeated);
				current = str.charAt(i);
				repeated = 1;
			} else{
				repeated++;
			}
		}
		compressed.append(current);
		compressed.append(repeated);
		return compressed.toString();
	}
	
	private int getCompressedLength(String str){
		char current = str.charAt(0);
		int length = 0;
		
		for(int i = 1; i < str.length(); i++){
			if(current != str.charAt(i)){
				current = str.charAt(i);
				length = length + 2;
			}
		}
		
		length = length + 2;
		
		return length;
	}
	/*
	 * End Question 1.5
	 */
	
	/*
	 * Start Question 1.6 (INCOMPLETE)
	 * Image Rotation
	 */
	public void rotate(int[][] matrix){
		
		for(int layer = 0; layer < matrix.length / 2; layer++){
			
			for(int i = 0 + layer; i < matrix.length - layer; i++){
				int temp = matrix[layer][i];
				
				matrix[layer + i][i] = matrix[layer + i][matrix.length - 1 - layer];
				
				matrix[layer][matrix.length - 1 - layer] = matrix[matrix.length - 1 - layer][matrix.length - 1- layer];
				
				matrix[matrix.length - 1 - layer][matrix.length - 1 - layer] = matrix[matrix.length - 1 - layer][layer];
				
				matrix[matrix.length - 1 - layer][layer] = temp;
			}
		}
	}
	
	/*
	 * End Question 1.6
	 */
	
}
