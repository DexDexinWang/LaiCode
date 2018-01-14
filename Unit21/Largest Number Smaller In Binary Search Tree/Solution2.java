import generator.TreeNode;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 //approach: sue binary search tree property to find target
	  //height: O(n)
	  //branches: [0 2];
	  public int largestSmaller(TreeNode root, int target) {
	    int max = Integer.MIN_VALUE;
	    if (root == null) {
	      return max;
	    }
	    while (root != null) {
	      if (root.key >= target) {
	        root = root.left;
	      } else {
	        max = root.key;
	        root = root.right;
	      }
	    }
	    return max;
	  }
	  //Time Complexity: O(height);
	  //Space complexity: O(1);
}
