import generator.TreeNode;
import generator.TreeRandom;

public class Solution4 {

	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGenRange(3, null, 0, 10);
		input.print();
		System.out.println(isBalanced(input));
	}
	  //approach: use a recursion to solve problem.
	  //base case: getHeight(null) = 0;
	  //Recursion rule: getHeight(root) = Math.max(getHeight(root.left),getHeight(root.right)) || -1;
	  //left, right = get the max height for subtrees.
	  //current level = compare whehter the diff of height is smaller and equals than 1
	  //return = -1 diff is more than 2; max height from left or right + 1;
	  public static boolean isBalanced(TreeNode root) {
	    //corner case;
	    if (root == null) 
	    {
	      return true;
	    }
	    return getHeight(root) == -1 ? false : true;
	  }
	  //recursion get height.
	  private static int getHeight(TreeNode root) {
	    if (root == null) {
	      return 0;
	    }
	    int left =  getHeight(root.left);
	    if (left == -1) {
	      return -1;
	    }
	    int right = getHeight(root.right);
	    if (right == -1) {
	      return -1;
	    }
	    return Math.abs(left - right) >= 2 ? -1 : Math.max(left, right) + 1;
	  }
	//Time Complexity: O(n)
	//Space Complexity: O(height) height could be n;

}
