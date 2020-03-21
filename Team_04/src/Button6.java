import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 * 
 * @author Rohith Varma Gaddam
 * @since 03-10-2020
 * @version 1.0
 *
 */
public class Button6 extends JButton {
	private SelectionEvent event;
	private static Icon label;

	public Button6() {
		super("||");
		Dimension size = getPreferredSize();
		setPreferredSize(size);
		setContentAreaFilled(false);
		event = new SelectionEvent(this, 6);
	}

	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Color.lightGray);
		} else {
			g.setColor(getBackground());
		}
		g.fillRect(20, 10, getWidth()-40, getHeight()-25);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRect(20, 10, getWidth()-40, getHeight()-25);
		g.drawRect(30, 25, 10, 30);
		
		g.drawRect(250, 25, 10, 30);
	}
}