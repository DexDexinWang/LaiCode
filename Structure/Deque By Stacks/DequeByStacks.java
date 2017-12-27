import java.util.Stack;
public class DequeByStacks {
	Stack<Integer> left;
	Stack<Integer> right;
	int size;
	public DequeByStacks() {
		left = new Stack<Integer>();
		right = new Stack<Integer>();
	}
	
	public void offerFirst(Integer ele) {
		move(right, left);
		left.push(ele);
		size++;
	}
	
	public void offerLast(Integer ele) {
		move(left, right);
		right.push(ele);
		size++;
	}
	
	public Integer pollFirst() {
		if (size == 0) {
			return null;
		}
		if (left.size() == 0) {
			moveHalf(right, left);
		}
		size--;
		return left.pop();
	}
	
	public Integer pollLast() {
		if (size == 0) {
			return null;
		}
		if (right.size() == 0) {
			moveHalf(left, right);
		}
		size--;
		return right.pop();
	}
	
	public Integer peekFirst() {
		if (size == 0) {
			return null;
		}
		if (left.size() == 0) {
			moveHalf(right, left);
		}
		return left.peek();
	}
	
	public Integer peekLast() {
		if (size == 0) {
			return null;
		}
		if (right.size() == 0) {
			moveHalf(left, right);
		}
		return right.peek();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	private void move(Stack<Integer> s1 ,Stack<Integer> s2) {
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
	}

	private void moveHalf(Stack<Integer> s1 ,Stack<Integer> s2) {
		if (size == 0) {
			return;
		}
		int nRight = (s1.size()) / 2;
		Stack<Integer> temp = new Stack<Integer>();
		while (nRight > 0) {
			temp.push(s1.pop());
			nRight--;
		}
		int nLeft = s1.size() - nRight;
		while (nLeft > 0) {
			s2.push(s1.pop());
			nLeft--;
		}
		while (!temp.isEmpty()) {
			s1.push(temp.pop());
		}
	}
	
	public void print() {
		System.out.print("[");
		move(right,left);
		while (!left.isEmpty()) {
			int num = left.pop();
			if (left.size() == 0) {
				System.out.print(num);
			} else {
				System.out.print(num + ", ");
			}
			right.push(num);
		}
		System.out.println("]");
	}
}
