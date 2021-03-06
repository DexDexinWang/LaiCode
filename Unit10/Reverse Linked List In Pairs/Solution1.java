import generator.LinkedListRandom;
import generator.ListNode;


public class Solution1 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(5, 0, 10);
		input.print();
		System.out.println();
		ListNode output1  = reverseInPairs1(input);
		output1.print();
	}
	//what: make a stable header and swap each pair of nodes 
	 public static ListNode reverseInPairs(ListNode head) {
		//how: 1. corner case
		if(head == null || head.next == null) {
		     return head;
		}
		//2. make dummy head as a stable header. 
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode current = dummy;
		//3. make a loop to check next pair of nodes.
		while(current.next != null && current.next.next !=null) {
			ListNode temp = current.next.next;
		    current.next.next =temp.next;
		    temp.next =current.next;
		    current.next = temp;
		    current = temp.next;
		}
		return dummy.next;
	}
	// Time Complexity: O(n)
	// Space Complexity: O(1)
	 
	 public static ListNode reverseInPairs1(ListNode head) {
		 if (head == null || head.next == null) {
			 return head;
		 }
		 ListNode temp = head.next;
		 head.next = reverseInPairs1(temp.next);
		 temp.next =head;
		 return temp;
	 }
	// Time Complexity: O(n)
	// Space Complexity: O(n)
}
