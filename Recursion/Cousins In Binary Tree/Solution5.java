import java.util.LinkedList;
import java.util.Queue;

import generator.TreeNode;
import generator.TreeRandom;
public class Solution5 {

	public static void main(String[] args) {
		String[] tree = {"1","3","6","2","4","5","0"};
		TreeNode input = TreeRandom.treeGen(tree);
		System.out.println(isCousin1(input, 5, 2));
	}
	//Approach: TreeNode
	public static boolean isCousin(TreeNode root, int a, int b) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> queC = new LinkedList<TreeNode>();
	    Queue<TreeNode> queP = new LinkedList<TreeNode>();
	    queC.offer(root);
	    queP.offer(root);
	    while(!queC.isEmpty()) {
	    	int size = queC.size();
		    TreeNode curC = null;
		    TreeNode curP = null;
		    boolean findOne = false;
		    TreeNode findParent = null;
		    for(int i = 0 ; i < size ; i++) {
		    	curC = queC.poll();
		        curP = queP.poll();
		        if (curC.key == a || curC.key == b) {
		            if(!findOne) {
		            	findOne = true;
		            	findParent = curP;
		            } else {
		            	if (findParent == curP) {
		            		return false;
		            	} 
		            	return true;
		           }
		       }
		       if (curC.left != null) {
		    	   queC.offer(curC.left);
		           queP.offer(curC);
		       }
		       if (curC.right != null) {
		    	   queC.offer(curC.right);
		    	   queP.offer(curC);
		       }
		   }
	    }
	    return false;
	}

	  //approach: find nodes` levels and compare whether they are in the same level. if yes, check they are sibiling
	  public static boolean isCousin1(TreeNode root, int a, int b) {
	    if (root == null) {
	      return false;
	    }
	    int aLevel = findNode(root, a, 1);
	    int bLevel = findNode(root, b, 1);
	    if (aLevel!= 0 && aLevel == bLevel) {
	      return !isSibling(root,a,b);
	    } else {
	      return false;
	    }
	  }
	  
	  private static boolean isSibling(TreeNode root, int a, int b) {
	    if (root == null || root.left == null && root.right == null) {
	      return false;
	    }  
	    if (root.left != null && root.right != null) {
	       return ((root.left.key == a && root.right.key == b) ||
	                (root.left.key == b && root.right.key == a) ||
	                isSibling(root.left, a, b) ||
	                isSibling(root.right, a, b));
	    } else if (root.left != null) {
	      return isSibling(root.left, a, b);
	    } else {
	      return isSibling(root.left, a, b);
	    }
	  }
	  
	  private static int findNode(TreeNode root, int key, int level) {
	    if (root == null) {
	      return 0;
	    }
	    if (root.key == key) {
	      return level;
	    }
	    int left = findNode(root.left, key, level + 1);
	    if (left != 0) {
	      return left;
	    }
	    return findNode(root.right, key, level + 1);
	  } 
	//Time Complexity: O(3n);
	//Space Complexity: O(n);
}
