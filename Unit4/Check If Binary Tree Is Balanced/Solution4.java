import generator.TreeNode;
import generator.TreeRandom;

public class Solution4 {

	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGenRange(3, null, 0, 10);
		input.print();
		System.out.println(isBalanced(input));
	}

	//what: for each level, compare the height of left sub-tree and height of right sub-tree whether the idfferent is one.
	public static boolean isBalanced(TreeNode root) {
		//how: 1. corner case
		if (root == null) {
			return true;
		}
		return height(root) != -1;
	}
	//2. check height in each level.
	private static int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = height(root.left);
		if (left == -1) {
			return -1;
		}
		int right = height(root.right); 
		if (right == -1) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1);

}
