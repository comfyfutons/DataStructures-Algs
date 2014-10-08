
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
	 * Matrix Rotation right and left
	 */
	public void rotateRight(int[][] matrix){
		int n = matrix.length;
		
		for(int layer = 0; layer < n / 2; layer++){
			int first = layer;
			int last = n - 1 - layer;
			
			for(int i = first; i < last; i++){
				int offset = i - first;
				
				int temp = matrix[first][i];
				
				matrix[first][i] = matrix[last - offset][first];
				
				matrix[last - offset][first] = matrix[last][last - offset];
				
				matrix[last][last - offset] = matrix[i][last];
				
				matrix[i][last] = temp;
			}
		}
	}
	
	public void rotateLeft(int[][] matrix){
		int n = matrix.length;
		
		for(int layer = 0; layer < n / 2; layer++){
			int first = layer;
			int last = n - 1 - layer;
			
			for(int i = first; i < last; i++){
				int offset = i - first;
				
				int temp = matrix[first][i];
				
				matrix[first][i] = matrix[first + offset][last];
				
				matrix[first + offset][last] = matrix[last][last - offset];
				
				matrix[last][last - offset] = matrix[last - offset][first];
				
				matrix[last - offset][first] = temp;
			}
		}
	}
	
	/*
	 * End Question 1.6
	 */
	
	/*
	 * Start Question 1.7
	 * Sets entire row and column of matrix to zero if one element in row or column is zero
	 */
	public void setZeros(int[][] matrix){
		Boolean[] rows = new Boolean[matrix.length];
		Boolean[] cols = new Boolean[matrix[0].length];
		
		for(int i = 0; i < rows.length; i++){
			rows[i] = false;
		}
		
		for(int i = 0; i < cols.length; i++){
			cols[i] = false;
		}
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[i][j] == 0){
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(rows[i] || cols[j]){
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	/*
	 * removeDuplicated algorithm: Removes duplicate entries from a char array
	 */
	public char[] removeDuplicates(char[] array){
		Boolean[] chars = new Boolean[256];
		char[] result = new char[265];
		
		for(int i = 0; i < chars.length; i++){
			chars[i] = false;
		}
		
		int current = 0;
		for(int i = 0; i < array.length; i++){
			int value = array[i];
			if(chars[value] == false){
				chars[value] = true;
				result[current] = array[i];
				current++;
			}
		}
		return result;
	}
	
	/*
	 * averageLetters algorithm: counts the words and letters and returns the average letters per word
	 * (small bugs with weirdly written sentences)
	 */
	public int averageLetters(String str){
		int words = 0;
		int letters = 0;
		
		for(int i = 0; i < str.length(); i++){
			int value = str.charAt(i);
			
			if(value <= 122 && value >= 65){
				letters++;
			}
			if(value == 32 && i + 1 < str.length()){
				if(str.charAt(i + 1) <= 122 && str.charAt(i + 1) >= 65){
					words++;
				}
			}
		}
		words ++;
		
		return (int) Math.round((double)letters/(double)words);
	}
	
	/*
	 * reverseString algorithms: reverses a string
	 */
	public String reverseString(String str){
		StringBuffer result = new StringBuffer();
		
		for(int i = str.length() - 1; i >= 0; i--){
			result.append(str.charAt(i));
		}
		
		return result.toString();
	}
	
	
}
