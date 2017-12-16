import generator.ListNode;

public class Solution4 {
	private ListNode head;
	public Solution4() {
		head = null;
	}
	
	public Integer pop() {
		if (head == null) {
			return null;
		} else {
			ListNode res = head;
			head = head.next;
			res.next =null;
			return res.value;
		}
	}
	public void posh(Integer ele) {
		ListNode node = new ListNode();
		node.value = ele;
		node.next = head;
		head = node;
	}
	public Integer peek() {
		if (head == null) {
			return null;
		}
		return head.value;
	}
}

