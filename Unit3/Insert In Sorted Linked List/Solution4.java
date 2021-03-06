import generator.LinkedListRandom;
import generator.ListNode;

public class Solution4 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(5, 0, 10);
		input.print();
		System.out.println();
		ListNode output  = insert(input, 5);
		output.print();
	}
	//what: check node by node and find its next is equal or bigger than the value.
	public static ListNode insert(ListNode head, int value) {
		ListNode newNode = new ListNode(value);
		//how: 1. corner case
		if (head == null || head.value > value) {
			newNode.next = head;
			return newNode;
		}
		
		// 2. define a new head to find the correct  position.
		ListNode current = head;
		while (current.next !=null && current.next.value < value) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
		return head;
	} 


}
