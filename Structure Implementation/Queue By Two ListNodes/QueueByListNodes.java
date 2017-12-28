import generator.ListNode;

public class QueueByListNodes {
	ListNode head;
	ListNode tail;
	int size;
	
	public QueueByListNodes() {
		head = null;
		tail = null;
		size = 0;
	}

	public void offer(Integer ele) {
		ListNode newNode = new ListNode(ele);
		if (size == 0) {
			head = newNode;
			tail = head;
		}
		tail.next = newNode;
		tail = tail.next;
		size++;
	}
	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return head.value;
	}
	
	public Integer poll() {
		if (size == 0) {
			return null;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		if (head == null) {
			tail = null;
		}
		size--;
		return temp.value;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void print() {
		System.out.print("[");
		ListNode cur = head;
		while (cur != null) {
			if (cur.next == null) {
				System.out.print(cur.value);
			} else {
				System.out.print(cur.value + ", ");
			}
			cur = cur.next;
		}
		System.out.println("]");
	}
}
