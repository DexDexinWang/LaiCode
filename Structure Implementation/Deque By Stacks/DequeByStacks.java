import java.util.Deque;
import java.util.LinkedList;

public class DequeByStacks {
	Deque<Integer> left;
	Deque<Integer> right;
	public DequeByStacks() {
		left = new LinkedList<Integer>();
		right = new LinkedList<Integer>();
	}

	public void offerFirst(Integer ele) {
		left.offerFirst(ele);
	}

	public void offerLast(Integer ele) {
		right.offerFirst(ele);
	}

	public Integer peekFirst() {
		if(left.size() + right.size() == 0) {
			return null;
		}
		if (left.size() == 0) {
		moveHalf(right,left);
		}
		return left.peekFirst();
	}
	
	public Integer peekLast() {
			if(left.size() + right.size() == 0) {
				return null;
			}
			if (right.size() == 0) {
			moveHalf(left,right);
	}
		return right.peekFirst();
	}
	
	public Integer pollFirst() {
		if(left.size() + right.size() == 0) {
			return null;
		}
		if (left.size() == 0) {
			moveHalf(right,left);
		}
		return left.pollFirst();
	}
	
	public Integer pollLast() {
		if(left.size() + right.size() == 0) {
			return null;
		}
		if (right.size() == 0) {
			moveHalf(right,left);
		}
		return right.pollFirst();
	}
	
	private void moveHalf(Deque<Integer> s1, Deque<Integer> s2) {
		Deque<Integer> temp = new LinkedList<Integer>();
		int moveSize = (s1.size() +1) / 2;
		int backSize = s1.size() - moveSize;
		for(int i = 0 ; i < backSize ; i++) {
			temp.offerFirst(s1.pollFirst());
			}
		for(int i = 0 ; i < moveSize ; i++) {
			s2.offerFirst(s1.pollFirst());
		} 
		while (!temp.isEmpty()) {
			s1.offerFirst(temp.pollFirst());
		}
	}
	
	
	public void print() {
		System.out.print("[");
		Deque<Integer> temp = new LinkedList<Integer>();
		while (!right.isEmpty()) {
			temp.offerFirst(right.pollFirst());
		}
		while (!left.isEmpty()) {
			right.offerFirst(left.pollFirst());
		}
		while (!right.isEmpty()) {
			temp.offerFirst(right.pollFirst());
		}
		Integer num = null;
		while (!temp.isEmpty()) {
			num = temp.pollFirst();
			if (temp.size() == 0) {
				System.out.print(num);
			} else {
				System.out.print(num + ",");
			}
			right.offerFirst(num);
		}
		System.out.println("]");
	}
	
}
