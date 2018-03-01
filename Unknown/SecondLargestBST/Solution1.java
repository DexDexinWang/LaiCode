import generator.TreeNode; 
public class Solution1 {

	public TreeNode getSecondLargest(TreeNode root) {
		if (root == null || root.left == null && root.right == null) {
			return null;
		}
		return getSecondLargest(root, 0, 2);
	}
	
	private TreeNode getSecondLargest(TreeNode root, int current, int counter) {
		if (current == counter) {
			return root;
		}
		if(root.right != null) {
			return getSecondLargest(root.right, current, counter);
		}
		current++;
		
		if (root.left != null) {
			return getSecondLargest(root.left, current, counter);
		}
		return root;
	}

}
