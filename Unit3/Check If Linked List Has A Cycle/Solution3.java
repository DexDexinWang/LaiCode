import generator.LinkedListRandom;
import generator.ListNode;

public class Solution3 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(5, 0, 10);
		input.print();
		System.out.println();
		System.out.println(hasCycle(input));
	}
	//what: find a cycle with fast and slow pointers.
	public static boolean hasCycle(ListNode head) {
		//how: 1. corner case
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		//2. make a loop to find a whehter fast will meet slow again.
		while (fast.next !=null && fast.next.next !=null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

}
