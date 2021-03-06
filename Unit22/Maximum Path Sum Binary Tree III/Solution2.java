import generator.TreeNode;
public class Solution2 {
	
	public static void main(String[] args) { 
		
	}
	
	
	/*
	Given a binary tree in which each node contains an integer number. 
	Find the maximum possible subpath sum(both the starting and ending node of the 
	subpath should be on the same path from root to one of the leaf nodes, 
	and the subpath is allowed to contain only one node).
	 */
	
	  //dp[0] = root.key;
	  //dp[i] represents the maximum path form root to current node.
	  //dp[i] = root.key                  dp[i - 1] < 0;
	  //dp[i] = dp[i-1] + root.key        otherwise;
	  public int maxPathSum2(TreeNode root) {
	    int[] max = new int[]{Integer.MIN_VALUE};
	    maxPathSum2(root, max, 0);
	    return max[0];
	  }
	  
	  public void maxPathSum2(TreeNode root, int[] max, int prevSum) {
	    if (root == null) {
	      return;
	    }
	    prevSum = prevSum < 0 ? root.key : prevSum + root.key;
	    max[0] = Math.max(max[0], prevSum);
	    maxPathSum2(root.left, max, prevSum);
	    maxPathSum2(root.right, max, prevSum);
	  }
	  //Time Complexity: O(n);
	  //Space Complexity: O(n);
	  
	  
	  
	  //left child: the maximum path in the left subtree < 0 , return 0.
	  //right child : the maximum path in the right subtree <0, return 0.
	  //current: update the global max with max(leftchild, rightchild) + root.key;
	  //return: return max(leftChild, rightChild) + root.key;
	  public int maxPathSum1(TreeNode root) {
	    int[] max = new int[]{Integer.MIN_VALUE};
	    maxPathSum1(root, max);
	    return max[0];
	  }
	  
	  public int maxPathSum1(TreeNode root, int[] max) {
	    if (root == null) {
	      return 0;
	    }
	    int leftChild = Math.max(0, maxPathSum1(root.left, max));
	    int rightChild = Math.max(0, maxPathSum1(root.right, max));
	    max[0] = Math.max(max[0], Math.max(leftChild, rightChild) + root.key);
	    return Math.max(leftChild, rightChild) + root.key;
	  }

	  
}
