import java.util.LinkedList;
import java.util.Queue;

import generator.TreeNode;
import generator.TreeRandom;
public class Solution3 {

	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGenLeftRange(1, null, 0, 10);
		TreeNode input1 = TreeRandom.treeGenRange(3, null, 0, 10);
		System.out.println(isCompleted(input));
		System.out.println(isCompleted(input1));
	}
	//what: Try to traverse the whole tree with BFS and check whether there is at least two bubbles. Yes, False; No, False;
	public static boolean isCompleted(TreeNode root) {
		//how: 1. corner case
		if (root == null) {
			return true;
		}
		//2. create a queue in order to check in BFS way and a flag to check bubbles.
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		boolean flag  = false;
		//3. traverse the tree.
		while (!que.isEmpty()) {
			TreeNode cur = que.poll();
			//3.1 check left node;
			if (cur.left == null) {
				//do not need to care the next level.
				flag = true;
			} else if (flag) {
				return false;
			} else {
				que.offer(cur.left);
			}
			//3.2 check right node; 
			if (cur.right == null) {
				flag = true;
			} else if (flag) {
				return false;
			} else {
				que.offer(cur.right);
			}
		}
		return true;
	}
	//Time Complexity: O(n);
	//Space Complexity: O(1);
}
