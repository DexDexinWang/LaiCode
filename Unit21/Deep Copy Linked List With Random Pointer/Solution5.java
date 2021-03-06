import java.util.HashMap;
import java.util.Map;

public class Solution5 {

	public static void main(String[] args) {
		RandomListNode input = new RandomListNode(-1);
	}
	  //approach: to create a hash map to store the mapping of original nodes and copied nodes. Then, and relaitons to each copied node.
	  public RandomListNode copy(RandomListNode head) {
	    //corner case;
	    if (head == null) {
	      return null;
	    }
	    //define a hashMapt to store the mapping relations
	    Map<RandomListNode, RandomListNode> map = new HashMap<>();
	    RandomListNode resHead = new RandomListNode(head.value);
	    map.put(head, resHead);
	    RandomListNode newHead = resHead;
	    //Iteratively check all nodes.
	    while (head != null) {
	      //connect next;
	      if (head.next != null) {
	        if (!map.containsKey(head.next)) {
	          map.put(head.next, new RandomListNode(head.next.value));
	        }
	        newHead.next = map.get(head.next);
	      }
	      //connect random;
	      if (head.random != null) {
	        if (!map.containsKey(head.random)) {
	          map.put(head.random, new RandomListNode(head.random.value));
	        }
	        newHead.random = map.get(head.random);
	      }
	      //move on
	      head = head.next;
	      newHead = newHead.next;
	    }
	    return resHead;
	  }
	  
	  public RandomListNode copy1(RandomListNode head) {
		    //corner case;
		    if (head == null) {
		      return null;
		    }
		    Map<RandomListNode, RandomListNode> map = new HashMap<>();
		    RandomListNode cur = head;
		    //crate all copies
		    while (cur != null) {
		    	map.put(cur, new RandomListNode(cur.value));
		    	cur = cur.next;
		    }
		    //make relations all copied nodes.
		    cur = head;
		    while (cur != null) {
		    	map.get(cur).next = map.get(cur.next);
		    	map.get(cur).random = map.get(cur.random);
		    	cur = cur.next;
		    }
		    return map.get(head);
		  }
	//Time Complexity: O(n);
	//Space Complexity: O(n); for HashMap.
	  
	 static class RandomListNode {
		  public int value;
		  public RandomListNode next;
		  public RandomListNode random;
		  public RandomListNode(int value) {
			  this.value = value;
		  }
	  }
}
