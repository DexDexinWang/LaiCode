import generator.TreeNode;
import generator.TreeRandom;

public class Solution7 {

	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGenRange(3, null, 0, 10);
		input.print();
		System.out.println(isBST(input));
	}

	  //apprach: DFS check all nodes with min and max value for each node.
	  //heights: n
	  //branches: [0 2]
	  //left, right: get the subtrees are BST or not.
	  //current: check the tree since the current level is BST
	  //return: return whether the tree since the current level is BST
	
	public static boolean isBST(TreeNode root) {
		//how: 1. corner case
		if(root == null) {
			return true;
		}
		//2. check the root and reduce the range.
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if(root.key < min || root.key > max) {
			return false;
		}
		return isBST(root.left, min, root.key -1) && isBST(root.right, root.key - 1, max);
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1)
}
