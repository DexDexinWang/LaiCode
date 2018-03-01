import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import generator.TreeNode;
import generator.TreeRandom;

public class Solution2 {

	public static void main(String[] args) {
		TreeNode root = TreeRandom.treeGenRange(3, null, 0, 50); 
		root.print();
		System.out.println(getNodesInColumns(root));
	}

	//left right: solve the sub problems. 
	//current level: check the current node in the column that has not been visited.
	//return: null;
	public static Deque<Integer> getNodesInColumns(TreeNode root) {
		Deque<Integer> res = new LinkedList<Integer>();
		Set<Integer> set =new HashSet<>();
		getNodesInColumns(root, res, set, 0, null);
		return res;
	}
	
	private static void getNodesInColumns(TreeNode root, Deque<Integer> res, Set<Integer> set, int level, TreeNode pre) {
		if (root == null) {
			return ;
		}
		if (pre == null || pre.left == root) {
			if (set.add(level)) {
				res.offerFirst(root.key);
			}
		} else if (set.add(level)){
			res.offerLast(root.key);
		}
		getNodesInColumns(root.left, res, set, level - 1, root);
		getNodesInColumns(root.right, res, set, level + 1, root);
	}
}
