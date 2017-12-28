import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
	
	class Pair {
		private Integer num;
		private int counter;
		public Pair(Integer num) {
			this.num = num;
			counter = 1;
		}
		public Integer getNum() {
			return num;
		}
		public int getCounter() {
			return counter;
		}
		public void counterAdd() {
			counter++;
		}
		public void counterMin() {
			counter--;
		}
	}
	
	Deque<Integer> stack;
	Deque<Pair> min;
	
	public MinStack() {
		stack = new LinkedList<Integer>();
		min = new LinkedList<Pair>();
	}
	
	public void push(Integer ele){
		stack.offerFirst(ele);
		if (min.isEmpty() || min.peekFirst().getNum() > ele) {
			min.offerFirst(new Pair(ele));
		} else if (min.peekFirst().getNum() == ele) {
			min.peekFirst().counterAdd();
		}
	}
	
	public Integer pop() {
		if (stack.size() == 0) {
			return null;
		}
		Integer res = stack.pollFirst();
		//update min stack;
		Pair cur = min.peekFirst();
		if (res == cur.getNum()) {
			cur.counterMin();
			if (cur.getCounter() == 0) {
				min.pollFirst();
			}
		}
		return res;
	}
	
	public Integer peek() {
		return stack.peekFirst();
	}
	
	public Integer min() {
		if (min.isEmpty()) {
			return null;
		}
		return min.peekFirst().getNum();
	}
	
	public void sort() {
		int size = stack.size();
		if (size == 0) {
			return;
		}
		Deque<Integer> sort = new LinkedList<Integer>();
		int cur = 0;
		while (sort.size() < size) {
			cur = stack.pollFirst();
			while (!sort.isEmpty() && sort.peekFirst() > cur) {
				stack.offerFirst(sort.pollFirst());
			}
			sort.offerFirst(cur);
		}

		while(!sort.isEmpty()) {
			stack.offerFirst(sort.pollFirst());
		}
	}
	
	public void print() {
		System.out.print("[");
		Deque<Integer> temp = new LinkedList<Integer>();
		while (!stack.isEmpty()) {
			Integer num = stack.pop();
			if (stack.size() == 0) {
				System.out.print(num);
			} else {
				System.out.print(num + ", ");
			}
			temp.offerFirst(num);
		}
		System.out.println("]");
		while(!temp.isEmpty()) {
			stack.offerFirst(temp.pollFirst());
		}
	}
}


