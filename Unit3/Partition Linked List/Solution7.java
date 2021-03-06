import generator.LinkedListRandom;
import generator.ListNode;

/*
		ListNode input = LinkedListRandom.LLGen(5, 0, 10);
		input.print();
		System.out.println();
		ListNode output  = reverse(input);
		output.print();
 */

public class Solution7 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(5, 0, 10);
		input.print();
		System.out.println();
		ListNode output  = partition(input, 5);
		output.print();
	}
	
	//what: separate ListNode as two part and connect them togeter 
	public static ListNode partition(ListNode head, int target) {
		//how: 1. corner case
		if (head == null || head.next == null) {
			return head;
		}
		//2. separate ListNode into two parts
		ListNode left = new ListNode(-1);
		ListNode right = new ListNode(-1);
		ListNode leftCur = left;
		ListNode rightCur = right;
		while (head != null) {
			if (head.value < target) {
				leftCur.next = head;
				leftCur = leftCur.next;
			} else {
				rightCur.next = head;
				rightCur = rightCur.next;
			}
			head = head.next;
		}
		//3. connect two parts.
		rightCur.next = null;
		leftCur.next = right.next;
		return left.next;
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1)

}
