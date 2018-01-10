import generator.LinkedListRandom;
import generator.ListNode;

public class Solution6 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(7, 0, 2);
		input.print();
		input = removeDup(input);
		System.out.println("");
		input.print();
	}

	public static ListNode removeDup(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode previous = head;
		ListNode current = head.next;
		previous.next = null;
		while (current != null) {
			if (current.value == previous.value) {
				current = current.next;
	        } else {
	        	previous.next =current;
	        	previous = previous.next;
	        	current = current.next;
	        	previous.next = null;
	        }
	      }
		return head;
	}

}
