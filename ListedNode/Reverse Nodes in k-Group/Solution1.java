import generator.ListNode;
import generator.LinkedListRandom;
public class Solution1 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(7, 0, 100);
		input.print();
		input = reverseKGroup(input,3);
		System.out.println("");
		input.print();
	}
	
	//what: reverse each k Nodes in linkedNode. 
	public static ListNode reverseKGroup(ListNode head, int k) {
		//how: 1. define a counter to make sure there is enough node that I could do reverse
		int counter = 0;
		//2. make a dummy to keep newHead
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode current = dummy; 
		//3. make a check for reverse k element to show when to end.
		ListNode check = head;
		while(check != null && counter < k) {
			check = check.next;
			counter++;
			if (counter == k) {
				ListNode end = current.next;
				current.next = reverse(end, check);
				counter =0;
				current = end;
			}
		}
		return dummy.next;
	}

	private static ListNode reverse(ListNode head, ListNode end) {
		ListNode newHead = end;
		while (head != end) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead;
	}
	//Time complexity: O(n)
	//Space complexity: O(1)

}
