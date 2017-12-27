
public class Solution999 {

	public static void main(String[] args) {
		DequeByStacks test = new DequeByStacks();
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
	
	public static void testMinStack(Integer x) {
		Solution2 test = new Solution2();
		test.push(2);
		test.push(2);
		test.push(4);
		test.push(6);
		test.push(1);
		test.print();
		test.sort();
		test.print();
	}
}