import generator.TreeNode;
public class Solution5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		System.out.println(isSymmetric(root.left, root.right));
	}
	//what: in each layer, to compare the left-subtree and right-subtree symmetrically
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
