import java.util.LinkedList;
import java.util.Queue;

public class Q {
	private Queue<Integer> q;
	private final int limit;
	
	public Q(int limit) {
		this.q = new LinkedList<>();
		this.limit = limit;
	}
	
	public synchronized void put (Integer ele) {
		while (q.size() == limit) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (q.size() == 0) {
			notifyAll();
		}
		q.offer(ele);
	}
	
	public synchronized Integer take() {
		while (q.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (q.size() == limit) {
			notifyAll();
		}
		return q.poll();
	}
}
