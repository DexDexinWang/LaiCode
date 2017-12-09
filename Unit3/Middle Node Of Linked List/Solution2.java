import generator.LinkedListRandom;
import generator.ListNode;

public class Solution2 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(5, 0, 10);
		input.print();
		System.out.println();
		ListNode output  = middleNode(input);
		output.print();
	}

	//what: find the mid ListNode with fast and slow pointers
	public static ListNode middleNode(ListNode head) {
		//how: 1. corner case
		if (head == null || head.next == null) {
			return head;
		}
		//2. use tow pointers to find the mid one. 
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next !=null && fast.next.next !=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	//Time complexity: O(n)
	//Space complexity: O(1)
}
