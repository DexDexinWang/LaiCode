import java.awt.Button;

public class AbstractFactoryTest {
	private static GUIFacotry factory;
	AbstractFactoryTest(GUIFacotry f) {
		AbstractFactoryTest.factory = f;
	}
	public static void main(String[] args) {
		Button button = factory.createButton();
		System.out.println(button.toString());
	}

}
