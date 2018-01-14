import generator.TreeNode;
public class Solution2 {

	public static void main(String[] args) {
		TreeNode input = new TreeNode(1);
		System.out.println(maxPathSum(input));
	}
	  //approach: Tree + DFS + Recursive
	  //Tree levels: n
	  //Tree branches: [0 2]
	  //child: get the maximum path from the child root to the leaf
	  //current level: find the maximum path from leaf to leaf
	  //return: 
	  //1. left, right are not null. the maximum path from root to leaf. 
	  //2. others, return root.key + left + right
	  public static int maxPathSum(TreeNode root) {
		  int[] max = new int[] {Integer.MIN_VALUE};
		  maxPathSumHelper(root, max);
		  return max[0] == Integer.MIN_VALUE ? 0 : max[0];
	  }
	  
	  public static int maxPathSumHelper(TreeNode root, int[] max) {
	    //corner case
	    if (root == null) {
	      return 0;
	    }
	    int left = maxPathSumHelper(root.left, max);
	    int right = maxPathSumHelper(root.right, max);
	    if (root.left != null && root.right != null) {
	      max[0] = Math.max(max[0], root.key + left + right);
	      return Math.max(left, right) + root.key;
	    } 
	    return root.left == null ? right + root.key: left + root.key;
	  }
}
