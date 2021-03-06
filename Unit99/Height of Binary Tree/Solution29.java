import generator.TreeRandom;

import java.util.LinkedList;
import java.util.Queue;

import generator.TreeNode;
public class Solution29 {

	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGenLeftRange(3, null, 0, 10);
		System.out.println(findHeight1(input));
	}
	
	//recursively check the height;
	public static int findHeight(TreeNode root) {
		if (root == null) {
			return 0;
		} 
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
	//Time Complexity:O(n);
	//Space complexity:O(logn);
	//recursively check the height;
	public static int findHeight1(TreeNode root) {
		if (root == null) {
			return 0; 
		}
		int height = 0;
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		while(!que.isEmpty()) {
			int size = que.size();
			if (size != 0) {
				height++;
			}
			while (size > 0) {
				TreeNode cur = que.poll();
				if (cur.left != null) {
					que.offer(cur.left);
				} 
				if (cur.right != null) {
					que.offer(cur.right);
				}
				size--;
			}
		}
		return height;
	}
}
