import java.util.HashMap;
import java.util.Map;

public class Solution4 {

	public static void main(String[] args) {

	}
	
	//what: Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. Make a deep copy of the original list.
	public static RandomListNode copy(RandomListNode head) {
		//how: 1. corner case
		if (head == null) {
			return null;
		}
		//2. make a hashMap to stores a pair ListNode, and new ListedNode
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
		RandomListNode current = head;
		while (current != null) {
			map.put(current, new RandomListNode(current.value));
			current = current.next;
		}
		//3. define the next and random for each new node;
		current = head;
		while(current != null) {
			map.get(current).next = map.get(current.next);
			map.get(current).random = map.get(current.random);
			current = current.next;
		}
		return map.get(head);
	}
	
	
	
	static class RandomListNode {
		 public int value;
		 public RandomListNode next;
		 public RandomListNode random;
		 public RandomListNode(int value) {
			 this.value = value;
		 }
	}
}
