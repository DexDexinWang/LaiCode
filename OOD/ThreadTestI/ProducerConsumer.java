import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
	public static int counter =0;
	public static void main(String[] args) {
		Q q = new Q(20);
		List<Thread> threads = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			threads.add(new Thread(new Producer(q)));
		}
		for (int i = 0; i < 100; i++) {
			threads.add(new Thread(new Consumer(q)));
		}
		for (Thread t: threads) {
			t.start();
		}
	}
	
	static class Producer implements Runnable {
		Q q;
		public Producer(Q q) {
			super();
			this.q = q;
		}
		@Override
		public void run() {
			q.put(0);
			System.out.println("PUT:" + counter++);
		}
	}
	
	static class Consumer implements Runnable {
		Q q;
		public Consumer(Q q) {
			super();
			this.q = q;
		}
		@Override
		public void run() {
			q.take();
			System.out.println("GET:" + counter--);
		}
	}
}
