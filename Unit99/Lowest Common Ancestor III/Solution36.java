import generator.TreeNode;

public class Solution36 {

	public static void main(String[] args) {
		TreeNode input1 = new TreeNode(1);
		input1.left = new TreeNode(2);
		input1.right = new TreeNode(3);
		input1.left.left = new TreeNode(4);
		input1.left.right = new TreeNode(5);
		input1.right.left = new TreeNode(6);
		input1.right.right = new TreeNode(7);
		lowestCommonAncestor(input1, input1.left.left, new TreeNode(8)).print();
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		    if(root == null || one == null || two == null) {
		      return null;
		    }
		    TreeNode left = lowestHelper(root.left, one, two);
		    TreeNode right = lowestHelper(root.right, one, two);
		    if (left == null && right == null) {
		      return null;
		    } else if (left != null && right !=null) {
		    	return root;
		    } else {
		    	TreeNode temp = left == null ? right : left;
		    	if (temp != one && temp != two) {
		    		return temp;
		    	}else {
		    		return null;
		    	}
		    }
	
	}
		  
	public static TreeNode lowestHelper(TreeNode root, TreeNode one, TreeNode two) {
		    if (root == null) {
		      return null;
		    }
		    if (root == one || root == two) {
		      return root;
		    }
		    TreeNode left = lowestHelper(root.left, one, two);
		    TreeNode right = lowestHelper(root.right, one, two);
		    if (left != null && right != null) {
		      return root;
		    }
		    return left == null ? right : left;
		  }
}
