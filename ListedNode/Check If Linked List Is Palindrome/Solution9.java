import generator.LinkedListRandom;
import generator.ListNode;

public class Solution9 {

	public static void main(String[] args) {
		ListNode input = new ListNode(2);
		input.next = new ListNode(2);
		input.next.next = new ListNode(2);
		input.next.next.next = new ListNode(3);
		input.next.next.next.next = new ListNode(2);
		input.next.next.next.next.next = new ListNode(2);
		input.next.next.next.next.next.next = new ListNode(2);
		input.print();
		System.out.println();
		System.out.println(isPalindrome(input));
	}
	
	  public static boolean isPalindrome(ListNode head) {
		    if (head == null || head.next == null) {
		      return true;
		    }
		    ListNode slow = head;
		    ListNode fast = head;
		    while (fast.next != null && fast.next.next != null) {
		      slow = slow.next;
		      fast = fast.next.next;
		    }
		    ListNode reverseRight = reverse(slow.next);
		    return compare(head, reverseRight);
		  }
		  
		  private static ListNode reverse(ListNode head) {
		    ListNode newHead = null;
		    while (head != null) {
		      ListNode temp = head.next;
		      head.next =newHead;
		      newHead = head;
		      head = temp;
		    }
		    return newHead;
		  }
		  
		  private static boolean compare(ListNode left, ListNode right) {
		    while (right != null) {
		      if (left.value != right.value) {
		        return false;
		      }
		      left = left.next;
		      right = right.next;
		    }
		    return true;
		  }
}
