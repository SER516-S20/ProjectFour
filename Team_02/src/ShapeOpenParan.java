
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ShapeOpenParan extends Icon{
	
	
	private static final long serialVersionUID = 1L;
	private int centerX;
	private int centerY;
	private static String text = "(";
	private Dot rightDot;
	
	public ShapeOpenParan(int x, int y) {
		this.setCenterX(x);
		this.setCenterY(y);
		this.setRightDot(new Dot(x, y, false, true));
		
		
		// call paint component from here, repaint ?!
	}
	
	// On top of parent class Icon,
	// Implement repaint using centerX, centerY, text, rightDot values.
	

	public Dot getRightDot() {
		return rightDot;
	}

	public void setRightDot(Dot rightDot) {
		this.rightDot = rightDot;
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

}
