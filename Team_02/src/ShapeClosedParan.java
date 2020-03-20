import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * @author Rohit
 * @created 02-18-2020
 * @version 1.0
 */
public class ShapeClosedParan extends Icon{
	
	
	private static final long serialVersionUID = 1L;
	private int centerX;
	private int centerY;
	private static String text = ")";
	private Dot leftDot;
	
	public ShapeClosedParan(int x, int y) {
		this.centerX = x;
		this.centerY = y;
		
		setUpPoints();
		repaint();
		
		// call paint component from here, repaint ?!
	}
	
	
	
	
	// On top of parent class Icon,
	// Implement repaint using centerX, centerY, text, rightDot values.
	

	public Dot getLeftDot() {
		return leftDot;
	}

	public void setLeftDot(Dot leftDot) {
		this.leftDot = leftDot;
	}

}
