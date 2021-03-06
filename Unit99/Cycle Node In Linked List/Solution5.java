import generator.LinkedListRandom;
import generator.ListNode;

public class Solution5 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(10, 0, 1);
		System.out.println(cycleNode(input));
	}
	
	public static ListNode cycleNode(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode slow1 = head;
				while(slow1 != slow) {
					slow1=slow.next;
					slow=slow.next;
				}
				return slow;
			}
		}
		return null;
	}

}
