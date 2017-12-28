import java.util.Set;
import java.util.Stack;

public class Solution2 {
	Stack<Integer> set;
	Stack<Integer> minSet;
	public Solution2() {
		set = new Stack<Integer>();
		minSet = new Stack<Integer>();
	}
	
	public int pop() {
		if (set.isEmpty()) {
			return -1;
		}
		int res = set.pop();
		if (minSet.peek().equals(res)) {
			minSet.pop();
		}
		return res;
	}
	
	public void push(int element) {
		set.push(element);
		if (minSet.isEmpty() || minSet.peek() >= element) {
			minSet.push(element);
		}
	}

	public int min() {
		if (minSet.isEmpty()) {
			return -1;
		}
		return minSet.peek();
	}
	
	public int top() {
		if (set.isEmpty()) {
			return -1;
		}
		return set.peek();
	}
	
	public void sort() {
		int size = set.size();
		if (size == 0) {
			return;
		}
		Stack<Integer> temp = new Stack<Integer>();
		int max = Integer.MIN_VALUE;
		while (temp.size() != size) {
			max = set.pop();
			while (!temp.isEmpty() && temp.peek() > max) {
				set.push(temp.pop());
			}
			temp.push(max);
		}
		while (!temp.isEmpty()) {
			set.push(temp.pop());
		}
	}
	
	public void print() {
		System.out.print("[");
		Stack<Integer> temp = new Stack<Integer>();
		while (!set.isEmpty()) {
			int num = set.pop();
			if (set.size() !=0) {
				System.out.print(num + ", ");
			} else {
				System.out.print(num);
			}
			temp.push(num);
		}
		System.out.println("]");
		while (!temp.isEmpty()) {
			set.push(temp.pop());
		}
	}
}
