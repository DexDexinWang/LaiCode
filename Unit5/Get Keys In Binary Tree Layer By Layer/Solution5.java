import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import generator.TreeNode;
import generator.TreeRandom;
public class Solution5 {

	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGenRange(3, null, 5, 10);
		input.print();
		System.out.println(layerByLayer(input));
	}
	
	//what: traverse each node and store them into list of list layer by layer 
	public static List<List<Integer>> layerByLayer(TreeNode root) {
		//how: 1. corner case
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) {
			return res;
		}
		//2. define que to do BFS
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		//3. traverse each node layer by layer
		while (!que.isEmpty()) {
			//3.1 get the number of nodes in current layer
			int size = que.size();
			List<Integer> temp = new LinkedList<Integer>();
			//3.2 get node and store their keys into a list and a que 
			for (int i = 0 ; i < size ; i++) {
				TreeNode cur = que.poll();
				temp.add(cur.key);
				if (cur.left != null) {
					que.offer(cur.left);
				}
				if (cur.right != null) {
					que.offer(cur.right);
				}
			}
			//3.3 add the list to list of list.
			res.add(temp);
		}
		return res;
	}
	//Time Complexity: O(n);
	//Space Complexity: O(n);
}
