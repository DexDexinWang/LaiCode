import generator.LinkedListRandom;
import generator.ListNode;

public class Solution2 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(7, 0, 100);
		input.print();
		input = removeNthFromEnd(input,7);
		System.out.println("");
		input.print();
	}
	
	//what: remove the Nth element from the end.  
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast = head;
		int counter = 0;
		//define a fast to move n steps. 1. to check there are enough node. 
		while(fast != null && counter < n) {
			fast = fast.next;
			counter++;
		}
		if (counter < n) {
			return head;
		}
		//define a slow to move Len - n steps; then revmoe the next.
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode slow = dummy;
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
	//Time complexity: O(n) 
	//Space complexity: O(1)

}
