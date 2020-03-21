import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 * IfBlockBeginIcon.java - a class for loading < shape Icon inside IfBlockBegin
 * Button on the left panel
 * 
 * @author Ashwin Srinivasan
 * @version 1.0
 * 
 */
public class IfBlockBeginIcon implements Icon {
	JButton closeAngleBracketButton;
	Helper helper = new Helper();

	IfBlockBeginIcon(JButton closeAngleBracketButton) {
		this.closeAngleBracketButton = closeAngleBracketButton;
	}

	public int getIconWidth() {
		return 0;
	}

	public int getIconHeight() {
		return 0;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		IfBlockBegin lessThanBracket = new IfBlockBegin();
		lessThanBracket.setPosition(x - Constants.X_DEVIATION, y - Constants.Y_DEVIATION);
		lessThanBracket.draw(g);
	}
}
