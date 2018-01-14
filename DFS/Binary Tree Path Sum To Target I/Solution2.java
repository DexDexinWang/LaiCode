import generator.TreeNode;
import generator.TreeRandom;
public class Solution2 {

	public static void main(String[] args) {
		String[] input = {"3","-8","9","4","10","2","-5","1","-2","#","#","-3"};
		TreeNode input1 = TreeRandom.treeGen(input);
		System.out.println(exist(input1,5));
	}
	
	  //approach: use recursion to traverse the whole tree in DFS way.
	  //Left, Right: call the recursion function as the subproblem to solve the problem.
	  //current level: calculate the remaining target and pass it to the next level until the leaf level to check the result.
	  //return true or false;
	  public static boolean exist(TreeNode root, int target) {
	    if (root == null ) {
	      return false;
	    }
	    return existHelper(root, target);
	  }
	  
	  public static boolean existHelper(TreeNode root, int target) {
	    if (root == null) {
	      if (target == 0) {
	        return true;
	      } else {
	        return false;
	      }
	    } 
	    return existHelper(root.left, target - root.key) || existHelper(root.right, target - root.key);
	  }
	  //Time complexity: O(n)
	  //Space compleixty: O(height);

}
