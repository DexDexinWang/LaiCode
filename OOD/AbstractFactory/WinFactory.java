import java.awt.Button;

public class WinFactory implements GUIFacotry{
	public Button createButton() {
		return new Button();
	}

}
