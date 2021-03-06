import generator.LinkedListRandom;
import generator.ListNode;

public class Solution7 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(3, 0, 10);
		input.print();
		input = rotateKplace(input,1);
		System.out.println("");
		input.print();
	}
	
	public static ListNode rotateKplace(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}
	    int counter = 1;
	    ListNode fast = head;
	    while (counter < k) {
	      fast = fast.next;
	      if (fast == null) {
	        fast = head;
	      }
	      counter++;
	    }
	    ListNode dummy = new ListNode(-1);
	    dummy.next = head;
	    ListNode slow = dummy;
	    while (fast.next != null) {
	      fast = fast.next;
	      slow = slow.next;
	    }
	    if (slow == dummy) {
	    	return dummy.next;
	    }
	    dummy = slow.next;
	    slow.next = null;
	    fast.next = head;
	    return dummy;
	}
}
