import generator.TreeNode;
public class Solution1 {

	public static void main(String[] args) {
		
	}

	//approach: use BST property to find the target
	  //height: O(n);
	  //branches: [0 2];
	  public int closest(TreeNode root, int target) {
	    if (root == null) {
	      return 0;
	    }
	    int result = root.key;
	    while (root != null) {
	      //find the result;
	      if (root.key == target) {
	        return root.key;
	      }
	      //compare the previous min diff and current diff
	      if (Math.abs(target - root.key) < Math.abs(target - result)) {
	        result = root.key;
	      }
	      //use BST to choose go left or right;
	      if (target < root.key) {
	        root = root.left;
	      } else {
	        root = root.right;
	      }
	    }
	    return result;
	  }
	  //Time Complexity: O(height)
	  //Space Complexity: O(1)
}
