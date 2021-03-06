import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;
import generator.TreeRandom;

public class Solution1 {
	
	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGenRange(3, null, 0, 10);
		input.print();
		System.out.println(inOrder1(input));
	}

	//what: traversed order should be left sub-tree, root, right sub-tree for each level.
	public static List<Integer> inOrder(TreeNode root) {
		//How: 1. corner case.
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		inOrder(root,res);
		return res;
	}
	//2. traverse the whole tree.
	public static void inOrder(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		//2.1 traverse left sub-tree 
		inOrder(root.left, res);
		//2.2 add the key of the current node into the ArrayList.
		res.add(root.key);
		//2.3 traverse right sub-tree
		inOrder(root.right, res);
	}

	public static List<Integer> inOrder1(TreeNode root) {
		//How: 1. corner case.
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		//2.define a stack to do FILO
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode cur = root;
		//3.traverse each node
		while (cur != null || !stack.isEmpty()) {
			//3.1 go left
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				cur = stack.pollFirst();
				//3.2 add the key of the current node into the ArrayList
				res.add(cur.key);
				//3.3 traverse right sub-tree
				cur = cur.right;
			}
		}
		return res;
	}
	//Time Complexity: O(n)
	//Space Complexity: O(n) 
}
