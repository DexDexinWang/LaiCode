import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;
import generator.TreeRandom;

public class Solution8 {

	public static void main(String[] args) {
		TreeNode input = TreeRandom.treeGenRange(3, null, 0, 10);
		input.print();
		System.out.println(getRange(input, 0 , 10));
	}
	
	  //Approach: use a DFS and inorder recursion to find the node 
	  //height: n;
	  //branches: [0 2];
	  //left right: find in next level
	  //current: check the current node is vaild and save valid node into reslt.
	  //return: no return;
	
	public static List<Integer> getRange(TreeNode root, int min, int max) {
		//how: 1. corner case
		List<Integer> res = new LinkedList<Integer>();
		if (root == null) {
			return res;
		}
		//2. in-order traverse the tree and add keys into List. 
		getRange(root, min, max, res);
		return res;
	}
	
	private static void getRange(TreeNode root, int min, int max, List<Integer> res) {
		if (root == null) {
			return;
		}
		
		if (root.key > min) {
			getRange(root.left, min, max, res);
		}
		if(root.key >= min && root.key <=max) {
			res.add(root.key);
		}
		if (root.key < max) {
			getRange(root.right, min, max, res);
		}
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1)
	
}
