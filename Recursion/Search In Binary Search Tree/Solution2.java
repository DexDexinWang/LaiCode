import generator.TreeNode;
public class Solution2 {

	public static void main(String[] args) {
		
	}
	
	public static TreeNode search(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.key == key) {
			return root;
		} else if (root.key > key) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}
	}
	
	public static TreeNode search1(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		TreeNode cur = root;
		while (cur != null) {
			if (cur.key == key) {
				return cur;
			} else if (cur.key > key) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		return null;
	}
}
