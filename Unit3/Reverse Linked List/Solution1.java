import generator.LinkedListRandom;
import generator.ListNode;
public class Solution1 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(5, 0, 10);
		input.print();
		System.out.println();
		ListNode output  = reverse(input);
		output.print();
	}

	//what: find each node and change its pointer to previous node from head to tail
	public static ListNode reverse(ListNode head) {
		//how: 1. corner case
		if (head == null || head.next == null) {
			return head;
		}
		//2. define a new head to be head for each iteration
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next =newHead;
			newHead = head;
			head = temp;
		}
		return newHead;
	}
	//Time Complexity: O(n);
	//Space Complexity: O(1);
	
	//what: convert each node`s positon from tail to head;
	public static ListNode reverse1(ListNode head) {
		//how: 1. corner case
		if (head == null || head.next == null) {
			return head;
		}
		//2. head.next is the tail of the reversed head, make its next to head;
		ListNode newHead = reverse1(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	//Time complexity: O(n)
	//Space complexity: O(1) iteration ; O(n) for recursion
 
}
