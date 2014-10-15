package TreesAndGraphs;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int data){
		this.data = data;
	}
	
	
	/*
	 * Question 4.1
	 * isBalanced Method: recursively checks if a tree is balanced 
	 * and returns true or false
	 */
	public boolean isBalanced(){
		if(checkHeight(this) == -1){
			return false;
		} else{
			return true;
		}
	}
	
	private int checkHeight(TreeNode root){
		//if reached children of a leaf
		if(root == null){
			return 0;
		}
		
		//check the left subtree's height
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1){
			return -1;
		}
		
		//check the right subtree's height
		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1){
			return -1;
		}
		
		//check the height difference to see if subtree is balanced
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1){
			return -1;
		} else{
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	/*
	 * toString Method: Returns an in-order string representation
	 * of the current root node's tree
	 */
	public String toString(){
		StringBuffer string = new StringBuffer();
		toStringHelper(this, string);
		return string.toString();
	}
	
	private void toStringHelper(TreeNode root, StringBuffer string){
		if(root != null){
			toStringHelper(root.left, string);
			string.append(root.data + " ");
			toStringHelper(root.right, string);
		}
	}
}
