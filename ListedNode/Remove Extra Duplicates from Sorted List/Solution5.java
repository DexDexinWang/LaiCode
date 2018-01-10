import java.util.Deque;
import java.util.LinkedList;

import generator.LinkedListRandom;
import generator.ListNode;

public class Solution5 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(7, 0, 2);
		input.print();
		input = removeDup(input);
		System.out.println("");
		input.print();
	}
	
	/*
	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

	Input:  1->2->3->3->4->4->5
	
	Output: 1->2->5    
	
	Input:  1->1->1
	
	Output: NULL
	 */
	//what: to make stack to save pointers in order to get previous node to check whether they are different.
	public static ListNode removeDup(ListNode head){
		//how. 1. corner case
		if (head == null || head.next == null) {
			return head;
		}
		//2.define a stack.
		Deque<ListNode> stack = new LinkedList<ListNode>();
		stack.offerFirst(head);
		ListNode cur = head.next;
		while (cur != null) {
			if (cur == cur.next) {
				//for the last element that is duplicate with previous. 
				if (cur.next == null && cur.next.value == stack.peekFirst().value) {
					stack.pollFirst();
				}
				cur = cur.next;
				continue;
			}
			if (!stack.isEmpty() && cur.value == stack.peekFirst().value) {
				stack.pollFirst();
				cur = cur.next;
			} else {
				if (stack.isEmpty()) {
					head = cur;
				} else {
					stack.peekFirst().next = cur;
				}
				stack.offerFirst(cur);
				cur = cur.next;
			}
		}
		if (stack.isEmpty()) {
			return null;
		}
		return head;
	}

}
