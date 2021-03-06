import java.util.LinkedList;
import java.util.Queue;

import generator.TreeNode;
import generator.TreeRandom;
public class Solution28 {

	public static void main(String[] args) {
		TreeNode input1 = TreeRandom.treeGenLeftRange(3, null, 0, 10);
		TreeNode input2 = TreeRandom.treeGenLeftRange(3, null, 0, 10);
		System.out.println(isIdentical(input1, input2));
	}
	
	//what: recursively check each root until the bottoms of the trees.
	public static boolean isIdentical(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.key != two.key) {
			return false;
		}
		return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
	}
	//Time Complexity: O(min(n,m));
	//Space Complexity: O(log(min(n,m));

	//What: iteratively check each root until the bottoms of the trees.
	public static boolean isIdentical1(TreeNode one, TreeNode two) {
		Queue<TreeNode> que1 = new LinkedList<TreeNode>();
		Queue<TreeNode> que2 = new LinkedList<TreeNode>();
		que1.offer(one);
		que2.offer(two);
		while (!que1.isEmpty() && !que2.isEmpty()) {
			TreeNode cur1 = que1.poll();
			TreeNode cur2 = que2.poll();
			if (cur1 == null && cur2 == null) {
				continue;
			} else if (cur1 == null || cur2 == null) {
				return false;
			} else if (cur1.key != cur2.key) {
				return false;
			}
			que1.offer(cur1.left);
			que1.offer(cur1.right);
			que2.offer(cur2.left);
			que2.offer(cur2.right);
		}
		if (!que1.isEmpty()) {
			return false;
		} else if (!que2.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	//Time complexity: O(n)
	//Space complexity: O(2*(n+1)/2) = O(n);
}
