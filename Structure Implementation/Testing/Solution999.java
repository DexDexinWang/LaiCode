import java.util.Arrays;

public class Solution999 {

	public static void main(String[] args) {
		String test = "abcd";
		System.out.print(test.substring(1, 3));
	}
	
	
	public static void printBinary(int value) {
		Integer i = 127;
		Integer j = 127;
		System.out.println(i == j);
	}
	
	public static void testMinHeap() {
		MinHeap test = new MinHeap();
		for(int i = 20; i >= 0; i--) {
			test.offer(i);
		}
		test.print();
		test.poll();
		test.print();
	}
	
	public static void testBoundedQueueByArray() {
		BoundedQueueByArray test = new BoundedQueueByArray();
		test.offer(1);
		test.offer(2);
		test.offer(3);
		test.print();
		test.poll();
		test.print();
	}
	
	public static void testDeque() {
		DequeByStacks1 test = new DequeByStacks1();
		System.out.println(test.pollFirst());
		System.out.println(test.pollLast());
		test.offerFirst(6);
		test.offerFirst(5);
		test.offerLast(7);
		test.offerLast(8);
		test.print();
		test.pollLast();
		test.pollLast();
		test.print();
		test.pollLast();
		test.print();
		test.pollFirst();
		test.print();
	}
	
	public static void testMinStack() {
		MinStack test = new MinStack();
		test.push(2);
		test.push(2);
		test.push(4);
		test.push(6);
		test.push(1);
		test.print();
		test.sort();
		test.print();
		
		MinStack test1 = new MinStack();
		test1.push(5);
		test1.push(5);
		test1.push(4);
		test1.push(5);
		test1.push(6);
		System.out.println(test1.min());
		test1.pop();
		System.out.println(test1.min());
		test1.pop();
		System.out.println(test1.min());
		test1.pop();
		System.out.println(test1.min());
		test1.pop();
		System.out.println(test1.min());
		test1.pop();
		System.out.println(test1.min());
	}
	
	public static void testStackByLinkedNode() {
		StackByLinkedNode test = new StackByLinkedNode();
		test.push(5);
		test.push(4);
		test.push(3);
		test.print();
	}
	
	public static void testQueueByListNodes() {
		QueueByListNodes test = new QueueByListNodes();
		test.offer(5);
		test.offer(4);
		test.offer(3);
		test.offer(2);
		test.print();
	}

}