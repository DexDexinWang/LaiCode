import generator.LinkedListRandom;
import generator.ListNode;

public class LinkedListOperations {
	
	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(10, 0, 1);
		System.out.println(length(input));
		System.out.println(get(input,5));
		System.out.println(appendHead(input,new ListNode(11)));
		System.out.println(appendTail(input,new ListNode(11)));
		System.out.println(remove(input,new ListNode(5)));
	}
	
	private static int length(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
	//assumption, index is not bigger than the length of the listnode
	private static int get(ListNode head, int index) {
		while (head != null && index > 0) {
			head =head.next;
			index --;
		}
		return head.value;
	}
	
	private static ListNode appendHead(ListNode head, ListNode node) {
		node.next = head;
		return node;
	}
	
	private static ListNode appendTail(ListNode head, ListNode node) {
		if (head == null) {
			return node;
		}
		ListNode current = head;
		while(current.next != null) {
			current= current.next;
		}
		current.next = node;
		return head;
	}
	//assumption, head is not empty
	private static ListNode remove(ListNode head, ListNode node) {
		if (head == node) {
			return head.next;
		}
		ListNode current = head;
		while (current.next != null && current.next != node) {
			current = current.next;
		}
		if (current.next != null) {
			current.next = current.next.next;
		}
		return head;
	}
	
}
