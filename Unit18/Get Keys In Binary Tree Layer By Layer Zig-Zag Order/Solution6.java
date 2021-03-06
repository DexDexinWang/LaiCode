import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import generator.TreeNode;

public class Solution6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  //zigZag will iteratively traverse each node with BFS1.
	  public List<Integer> zigZag(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	    //corner case
	    if (root == null) {
	      return res;
	    }
	    //deque, could implement zigzag order.
	    Deque<TreeNode> deque = new LinkedList<TreeNode>();
	    //leftToRight is to define whether the read order will from left to right ro not.
	    boolean leftToRight = false;
	    deque.offerFirst(root);
	    while(!deque.isEmpty()) {
	      //traverse each level.
	      int size = deque.size();
	      for(int i = 0; i < size; i++) {
	        //left to right: left get, left child save to last, right child save to last.
	        //right to left: right get, right childe save to first, left child save to first.
	        TreeNode cur;
	        if (leftToRight) {
	          cur = deque.pollFirst();
	        } else {
	          cur = deque.pollLast();
	        }
	        res.add(cur.key);
	        if (leftToRight) {
	          if (cur.left != null) {
	            deque.offerLast(cur.left);
	          }
	          if (cur.right != null) {
	            deque.offerLast(cur.right);
	          }
	        } else {
	          if (cur.right != null) {
	            deque.offerFirst(cur.right);
	          }
	          if (cur.left != null) {
	            deque.offerFirst(cur.left);
	          }
	        }
	        //change the order flag
	      }
	      leftToRight = !leftToRight;
	    }
	    return res;
	  }
	  //Time Complexity: O(n)
	  //Space Complexity: O(n/2) = O(n);
}
