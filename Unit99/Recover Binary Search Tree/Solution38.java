import generator.TreeNode;
public class Solution38 {
	private static TreeNode first = null;
	private static TreeNode second = null;
	private static TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	public static void main(String[] args) {
		TreeNode input = new TreeNode(3);
		input.left = new TreeNode(2);
		input.left.right = new TreeNode(1);
		recover(input).print();
	}
	public static TreeNode recover(TreeNode root) {
		inorderTraverse(root);
		if (second == first) {
			second = second.right;
		}
		int temp = first.key;
		first.key = second.key;
		second.key = temp;
		return root;
	}
		  
	public static void inorderTraverse(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraverse(root.left);
		if(first == null && prev.key >= root.key) {
			first = prev;
		}
		if(first != null && prev.key >= root.key) {
			second = prev;
		}
		prev = root;
		inorderTraverse(root.right);
	} 
}
