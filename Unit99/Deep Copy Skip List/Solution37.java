import java.util.HashMap;
import java.util.Map;

public class Solution37 {

	public static void main(String[] args) {
		
	}
	public static SkipListNode copy(SkipListNode head) {
		//How: 1. corner case
		Map<SkipListNode,SkipListNode> map = new HashMap<>();
		SkipListNode current = head;
		//2. create a new SkipListNode for each node;
		while(current != null) {
			map.put(current, new SkipListNode(current.value));
			current = current.next;
		}
		//3. set next and forward for each node;
		current = head;
		while(current != null) {
			map.get(current).next = map.get(current.next);
			map.get(current).forward = map.get(current.forward);
			current = current.next;
		}
		//return the root;
		return map.get(head);
	}

	static class SkipListNode {
		public int value;
		public SkipListNode next;
		public SkipListNode forward;
		public SkipListNode(int value) {
			this.value = value;
		}
	}
	//Time complexity O(n)
	//Space complexity O(n)
}
