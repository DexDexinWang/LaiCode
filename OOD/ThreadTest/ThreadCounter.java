
public class ThreadCounter {
	public static void main(String[] args) throws InterruptedException {
		staticIncrement();
	}
	private int value;
	static int value1;
	public ThreadCounter(int value ) {
		this.value = value;
	}
	
	public void increase() {
		synchronized(this) {
			value++;
		}
	}
	
	public synchronized void decrease() {
		value--;
	}
	
	public synchronized int getCount() {
		return value;
	}
	
	public static void staticIncrement() {
		synchronized(ThreadCounter.class) {
			value1++;
		}
	}
	
	public static synchronized void staticDecrease() {
		value1--;
	}
}
