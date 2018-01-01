import generator.ListNode;
import generator.LinkedListRandom;
public class Solution1 {

	public static void main(String[] args) {
		ListNode input = LinkedListRandom.LLGen(5, 0, 11);
//		ListNode input = new ListNode(8);
//		input.next = new ListNode(11);
//		input.next.next = new ListNode(6);
		input.print();
		System.out.println();
		selectionSort(input).print();
	}
	
	public static ListNode selectionSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		//handle the head pointer
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		//handle the current pointer
		ListNode outPointer= dummy;
		while(outPointer.next != null) {
			ListNode minPrevious = outPointer;
			ListNode inPointer = minPrevious.next;
			while(inPointer.next != null) {
				if (inPointer.next.value < minPrevious.next.value) {
					minPrevious = inPointer;
				}
				inPointer = inPointer.next;
			}
			swap(outPointer, minPrevious);
			outPointer = outPointer.next;
		}
		return dummy.next;
		
	}
	
	private static void swap(ListNode loopPrevious, ListNode minPrevious) {
		if (loopPrevious == minPrevious) {
			return ;
		} else if (loopPrevious.next == minPrevious) {
		      loopPrevious.next = minPrevious.next;
		      minPrevious.next = loopPrevious.next.next;
		      loopPrevious.next.next = minPrevious;
		} else {
			ListNode temp1 = loopPrevious.next;
			ListNode temp2 = minPrevious.next;
			loopPrevious.next = temp2;
			minPrevious.next = temp1;
			temp1 = temp1.next;
			temp2 = temp2.next;
			loopPrevious.next.next = temp1;
			minPrevious.next.next = temp2;
		}
	}

}
