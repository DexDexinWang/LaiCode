
public class SingletonExample {
	private static final SingletonExample INSTANCE = new SingletonExample();
	private String name = "Bob";
	private SingletonExample() {
		this.name ="John";
	};
	public static SingletonExample getInstance() {
		return INSTANCE;
	}

}
