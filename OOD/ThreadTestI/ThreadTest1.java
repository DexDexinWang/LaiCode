
public class ThreadTest1  {

	public static volatile boolean flag = false;
	public static void main(String[] args) throws InterruptedException {
		Thread newThread = new Thread(new MyRunnable());
		newThread.start();
		Thread.sleep(10000);
		flag = true;
		System.out.println("Main thread is finished...");
		
	}
	
	public static class MyRunnable implements Runnable{
		@Override
		public void run() {
			while (!flag) {
				System.out.println("The thread is running...");
			}
			System.out.println("The thread is finished...");
		}
	}
}
