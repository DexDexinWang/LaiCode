import java.util.Collections;
import java.util.PriorityQueue;

public class Solution5 {

	PriorityQueue<Integer> small;
	PriorityQueue<Integer> large;
	public Solution5(){
		small = new PriorityQueue<Integer>(Collections.reverseOrder());
		large = new PriorityQueue<Integer>();
	}
	//where small PQ size is bigger than large PQ than at most 1;
	public void read(int value) {
		if (small.size() == 0 || value <= small.peek()) {
			small.offer(value);
		} else {
			large.offer(value);
		}
		if (small.size() - large.size() >= 2) {
			large.offer(small.poll());
		} else if (small.size() < large.size()) {
			small.offer(large.poll());
		}
	}
	
	
	public Double median() {
		if (small.size() + large.size() == 0) {
			return null;
		}
		if (small.size() == large.size()) {
			return (0.0 + small.peek() + large.peek()) /2;
		} else {
			return (double)small.peek();
		}
	}
	
}
