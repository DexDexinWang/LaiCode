import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;
import generator.TreeRandom;
public class PrintAllPathes {

	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGenRange(3, null, 0, 10);
		input.print();
		printAllPathes(input);
	}
	//solve the problem by post order traversal with previous node and current node. 
	//1. prev = null, root, go down.
	//2. prev = parent, go down.
	//3. prev = left or right, go up.
	private static void printAllPathes(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode prev = null;
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offer(root);
		List<Integer> sb = new ArrayList<Integer>();
		sb.add(root.key);
		while(!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null) {
					stack.push(cur.left);
					sb.add(cur.left.key);
				} else if (cur.right != null) {
					stack.push(cur.right);
					sb.add(cur.right.key);
				} else {
					System.out.println(sb.toString());
					stack.poll();
					sb.remove(sb.size() - 1);
				}	
			} else if (cur.left == prev) {
				if (cur.right != null) {
					stack.push(cur.right);
					sb.add(cur.right.key);
				} else {
					stack.poll();
					sb.remove(sb.size() - 1);
				}
			} else {
				stack.poll();
				sb.remove(sb.size() - 1);
			}
			prev = cur;
		}
	}
	
}
