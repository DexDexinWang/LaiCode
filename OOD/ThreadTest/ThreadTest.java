
public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		test2();
	}

	public static void test1() throws InterruptedException {
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("Hello1");
			}
		};
		t.start();
		Thread.sleep(1000);
		System.out.println("hello2");
		t.join();
	}
	
	//Method 1 to define thread.
	class HelloThread extends Thread{
		int result = 0;
		@Override
		public void run() {
			System.out.println("Hello.");
			result = 1;
		}
		public int getResult() {
			return result;
		}

	}
	
	public static void test2 () throws InterruptedException {
		ThreadTest out = new ThreadTest();
		Thread newThread = out.new HelloThread();
		newThread.start();
		newThread.join();
		System.out.println(((HelloThread) newThread).getResult());
	}
	
	//Method 2 to define thread.
	class HellorRunnable implements Runnable{
		@Override
		public void run() {	
			for (int i = 0 ; i < 10000; i++) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					return;
				}
				System.out.println("Hello");
			}
		}
	}
	
	public static void test3 () throws InterruptedException {
		ThreadTest out = new ThreadTest();
		Thread newThread =new Thread(out.new HellorRunnable());
		newThread.start();
		newThread.join();
		System.out.println(((HelloThread) newThread).getResult());
	}
}
