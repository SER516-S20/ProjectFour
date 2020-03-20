import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

public class ShapeDash extends Icon{

	
	private static final long serialVersionUID = 1L;
	private int centerX;
	private int centerY;
	private static String text = "-";
	private Dot leftDot;
	private Dot rightDot;
	
	
	public ShapeDash(int x, int y) {
		this.centerX = x;
		this.centerY = y;
		setUpPoints();
		repaint();
	}
	
	
	
	// On top of parent class Icon,
	// Implement repaint using centerX, centerY, text, rightDot values.
	
	public Dot getLeftDot() {
		return leftDot;
	}

	public void setLeftDot(Dot leftDot) {
		this.leftDot = leftDot;
	}

	public Dot getRightDot() {
		return rightDot;
	}

	public void setRightDot(Dot rightDot) {
		this.rightDot = rightDot;
	}
	

}
