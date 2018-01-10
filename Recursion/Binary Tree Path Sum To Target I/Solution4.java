import generator.TreeNode;
public class Solution4 {

	public static void main(String[] args) {
		TreeNode input = new TreeNode(1);
		System.out.println(exist(input, 1));
	}
	
	public static boolean exist(TreeNode root, int target) {
		if (root == null) {
			return false;
		}
		return existHelper(root.left, target - root.key) || existHelper(root.right, target - root.key);
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

}
