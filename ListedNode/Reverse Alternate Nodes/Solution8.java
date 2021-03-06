import generator.LinkedListRandom;
import generator.ListNode;

public class Solution8 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(3, 0, 10);
		input.print();
		input = reverseAlternate(input);
		System.out.println("");
		input.print();
	}

	  public static ListNode reverseAlternate(ListNode head) {
		    if (head == null || head.next == null) {
		      return head;
		    }
		    ListNode left = new ListNode(-1);
		    ListNode curLeft = left;
		    ListNode right = new ListNode(-1);
		    ListNode curRight = right;
		    while(head != null && head.next != null) {
		      curLeft.next = head;
		      curLeft = curLeft.next;
		      head = head.next;
		      curRight. next = head;
		      curRight = curRight.next;
		      head = head.next;
		    }
		    if (head != null) {
		      curLeft.next = head;
		      curLeft = curLeft.next;
		    }
		    curLeft.next = null;
		    curRight.next = null;
		    
		    curLeft.next = reverse(right.next);
		    return left.next;
		  }
		  
		  private static ListNode reverse(ListNode head) {
		    ListNode newHead = null;
		    while (head != null) {
		      ListNode temp = head.next;;
		      head.next = newHead;
		      newHead = head;
		      head = temp;
		    }
		    return newHead;
		  }

}
