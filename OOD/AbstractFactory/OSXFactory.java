import java.awt.Button;

public class OSXFactory implements GUIFacotry {

	@Override
	public Button createButton() {
		return new Button();
	}

}
