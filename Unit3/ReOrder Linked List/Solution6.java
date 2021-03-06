import generator.LinkedListRandom;
import generator.ListNode;

public class Solution6 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(5, 0, 10);
		input.print();
		System.out.println();
		ListNode output  = reorder(input);
		output.print();
	}
	
	//what: to separate the ListNode in two part and merge them into one ListNode. 
	public static ListNode reorder(ListNode head) {
		//how: 1. corner case 
		if (head == null || head.next == null) {
			return head;
		}
		//2. separate one ListNode into two parts.
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode reverse = slow.next;
		slow.next = null;
		//3. reverse the right part
		ListNode newHead = null; 
		while (reverse != null) {
			ListNode temp = reverse.next;
			reverse.next = newHead;
			newHead = reverse;
			reverse = temp;
		}
		//4. merge them together.
		ListNode res = new ListNode(-1);
		ListNode current = res;
		while (head != null && newHead != null) {
			current.next = head;
			head = head.next;
			current.next.next = newHead;
			newHead = newHead.next;
			current = current.next.next;
		}
		if(head != null) {
			current.next = head;
		}
		return res.next;
	}
	//Time complexity: O(n)
	//Space complexity: O(1)
}
