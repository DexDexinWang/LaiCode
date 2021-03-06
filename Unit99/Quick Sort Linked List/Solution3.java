import generator.LinkedListRandom;
import generator.ListNode;

public class Solution3 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(20, 0, 11);
		input.print();
		System.out.println();
		quickSort(input).print();
	}
	
	public static ListNode quickSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		return divide(head);
	}
	
	private static ListNode divide(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode pivot = head;
		ListNode left = new ListNode(-1);
		ListNode curLift = left;
		ListNode right = new ListNode(-2);
		ListNode curRight = right;
		head = head.next;
		pivot.next = null;
		
		while(head != null) {
			if (head.value < pivot.value) {
				curLift.next = head;
				curLift = curLift.next;
			} else {
				curRight.next = head;
				curRight = curRight.next;
			}
			head = head.next;
		}
		curLift.next = null;
		curRight.next = null;
		left.next = divide(left.next);
		right.next = divide(right.next);
		ListNode cur = left;
		while(cur.next != null) {
			cur = cur.next;
		}
		cur.next = pivot;
		pivot.next = right.next;
		return left.next;
	}
	//Time complexity: O(n^2)
	//Space complexity: O(n);
	

}
