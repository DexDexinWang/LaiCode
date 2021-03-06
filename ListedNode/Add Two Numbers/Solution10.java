import generator.LinkedListRandom;
import generator.ListNode;

public class Solution10 {

	public static void main(String[] args) {
		ListNode input1 = LinkedListRandom.LLGen(3, 0, 9);
		input1.print();
		System.out.println("");
		ListNode input2 = LinkedListRandom.LLGen(3, 0, 9);
		input2.print();
		System.out.println("");
		addTwoNumbers(input1,input2).print();
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		ListNode res = new ListNode(-1);
		ListNode cur = res;
		int sum = 0;
		while(l1!= null || l2!= null || sum != 0) {
			int leftValue = l1 == null ? 0 : l1.value;
			int rightValue = l2 == null ? 0 : l2.value;
			sum = sum + leftValue + rightValue;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			sum = sum / 10;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
		}
		return res.next;
	}

}
