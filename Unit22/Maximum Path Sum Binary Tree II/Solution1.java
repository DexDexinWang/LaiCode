import generator.TreeNode;

public class Solution1 {
	
	/*
	Given a binary tree in which each node contains an integer number. 
	Find the maximum possible sum from any node to any node (the start node and the end node can be the same). 
	 */
	
	  //lchild: it will get the maximum path from left subtree [any node to the root], if it is < 0, then return 0;
	  //rchild: it will get the maximum path from right subtree [any node to the roog], if it is < 0, then return 0;
	  //current: update the global max value with lchild + rchild + root.key
	  //return: max (left, right) + root.key;
		  public int maxPathSum(TreeNode root) {
		    int[] max = new int[]{Integer.MIN_VALUE};
		    maxPathSum(root, max);
		    return max[0];
		  }
		  
		  private int maxPathSum(TreeNode root, int[] max) {
		    if (root == null) {
		      return 0;
		    }
		    int lChild = Math.max(maxPathSum(root.left, max), 0);
		    int rChild = Math.max(maxPathSum(root.right, max), 0);
		    max[0] = Math.max(max[0], lChild + rChild + root.key);
		    return Math.max(lChild, rChild) + root.key;
		  }
		  //Time complexity: O(n);
		  //Space complexity: O(n);
}
