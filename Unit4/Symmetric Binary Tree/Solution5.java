import generator.TreeNode;
public class Solution5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		System.out.println(isSymmetric(root.left, root.right));
	}
	//approach: use a recursion to solve the problem.
	  //levels: n levels.
	  //branches: [0 2]
	  //left, right: get whether the subtrees are symmetric 
	  //current: check left node and right node are equal
	  //return: return whether the left equals right;
	
	public static boolean isSymmetric(TreeNode root) {
		//how: 1. corner case
		if (root == null) {
			return true;
		}
		//2. compare left subtree with the right subtree.
		return isSymmetric(root.left, root.right);
	}
	
	public static boolean isSymmetric(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.key != two.key) {
			return false;
		} 
		return isSymmetric(one.left, two.right) &&
				isSymmetric(one.right, two.left); 
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1)
}
