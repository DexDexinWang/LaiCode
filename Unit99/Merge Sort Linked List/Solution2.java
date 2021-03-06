import generator.LinkedListRandom;
import generator.ListNode;

public class Solution2 {
	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(2, 0, 11);
		input.print();
		System.out.println();
		mergeSort(input).print();
	}
	
	public static ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		return divide(head);
	}
	
	private static ListNode divide(ListNode head) {
		if (head.next == null) {
			return head;
		}
		//find mid
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode left = head;
		ListNode right = slow.next;
		slow.next = null;
		ListNode newLeft = divide(left);
		ListNode newRight = divide(right);
		return merge(newLeft, newRight);
	}
	
	private static ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		while (left!=null && right!=null) {
			if(left.value < right.value) {
				head.next = left;
				left = left.next;
			} else {
				head.next = right;
				right = right.next;
			}
			head = head.next;
		}
		if (left != null) {
			head.next = left;
		} else if (right != null) {
			head.next = right;
		}
		return dummy.next;
	}
	//Time complexity: O(nlogn)
	//Space complexity: O(logn);
}
