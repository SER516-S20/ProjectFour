import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

public class ShapeAtTheRate extends Icon{

	private static final long serialVersionUID = 1L;
	private int centerX;
	private int centerY;
	private static String text = "@";
	private Dot leftUpperDot,leftLowerDot;
	private Dot rightUpperDot, rightLowerDot;
	
	public ShapeAtTheRate(int x, int y) {
		this.centerX = x;
		this.centerY = y;
		setUpPoints();
		repaint();
	}
	
	
	
	// On top of parent class Icon,
	// Implement repaint using centerX, centerY, text, rightDot values.
	

	public Dot getRightUpperDot() {
		return rightUpperDot;
	}

	public void setRightUpperDot(Dot rightUpperDot) {
		this.rightUpperDot = rightUpperDot;
	}

	public Dot getRightLowerDot() {
		return rightLowerDot;
	}

	public void setRightLowerDot(Dot rightLowerDot) {
		this.rightLowerDot = rightLowerDot;
	}
	
	public Dot getLeftUpperDot() {
		return leftUpperDot;
	}

	public void setLeftUpperDot(Dot leftUpperDot) {
		this.leftUpperDot = leftUpperDot;
	}

	public Dot getLeftLowerDot() {
		return leftLowerDot;
	}

	public void setLeftLowerDot(Dot leftLowerDot) {
		this.leftLowerDot = leftLowerDot;
	}
	
	
}
