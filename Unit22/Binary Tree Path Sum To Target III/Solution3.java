import java.util.HashSet;
import java.util.Set;
import generator.TreeNode;

public class Solution3 {
	  //approach: when it traverse each node in any path, and save presum value into a set.
	  public boolean exist(TreeNode root, int target) {
	    Set<Integer> set = new HashSet<Integer>();
	    set.add(0);
	    return exist(root, target, set, 0);
	  }
	  
	  private boolean exist(TreeNode root, int target, Set<Integer> set, int preSum) {
	    if (root == null) {
	      return false;
	    }
	    preSum += root.key;
	    if (set.contains(preSum - target)) {
	      return true;
	    }
	    boolean needRemove = set.add(preSum); 
	    boolean left = exist(root.left, target, set, preSum);
	    boolean right = exist(root.right, target, set, preSum);
	    if (needRemove) {
	      set.remove(preSum);
	    }
	    return left || right;
	  }
	  //Time complexity:O(n)
	  //Space complexity:O(n)
	  
	  
	  public boolean exist2(TreeNode root, int target) {
		    // Write your solution here.
		      if (root == null) {
		          return false;
		      }
		      return exist2(root.left, target) || exist2(root.right, target) || helper(root, target);
		  }
		  private boolean helper(TreeNode root, int sum) {
		      if (root == null) {
		          return false;
		      }
		      if (root.key == sum) {
		          return true;
		      }
		      return helper(root.left, sum - root.key) || helper(root.right, sum - root.key);
		  }
		  
	//Time complexity: O(n^2)
    //Time complexity: O(n);

}
