import generator.TreeNode;
public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			return new TreeNode(key);
		}
		if (root.key < key) {
			root.right = insert(root.right, key);
		} else if (root.key > key) {
			root.left = insert(root.left, key);
		}
		return root;
	}
	
	public TreeNode insert1(TreeNode root, int key) {
		TreeNode newNode = new TreeNode(key);
		if (root == null) {
			return newNode;
		}
		TreeNode cur = root;
		while(cur.key != key) {
			if (cur.key > key) {
				if (cur.left == null) {
					cur.left = newNode;
					break;
				} else {
					cur = cur.left;
				}
			} else if (cur.key < key) {
				if (cur.right == null) {
					cur.right = newNode;
					break;
				} else {
					cur = cur.right;
				}
			}
		}
		return root;
	}

}
