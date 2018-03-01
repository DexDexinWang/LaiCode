
public class SingletonTest {

	public static void main(String[] args) {
		//SingletonExample c = new SingletonExample();
		SingletonExample c1 = SingletonExample.getInstance();
		SingletonExample c2 = SingletonExample.getInstance();
		System.out.println(c1==c2);
	}
}
