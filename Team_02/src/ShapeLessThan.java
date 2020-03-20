import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 * @author Rohit
 * @created 02-18-2020
 * @version 1.0
 */
public class ShapeLessThan extends Icon{
	
	private static final long serialVersionUID = 1L;
	private int centerX;
	private int centerY;
	private static String text = "<";
	private Dot leftDot;
	private Dot rightUpperDot, rightLowerDot;
	
	public ShapeLessThan(int x, int y) {
		this.centerX = x;
		this.centerY = y;
		setUpPoints();
		repaint();
		// call paint component from here, repaint ?!
	}
	
	
	@Override
	public void paintComponent(Graphics objGraphics) {

		try {
			Graphics2D obj2D = (Graphics2D) objGraphics;
			Shape objRectangle = new Rectangle(this.centerX, this.centerY, width, height);
			obj2D.draw(objRectangle);
			obj2D.drawString(text, getMiddlePointX(), getMiddlePointY());
			
			
			obj2D.fillOval(leftDot.getX(), leftDot.getY(), dotSize, dotSize);
			obj2D.fillOval(rightUpperDot.getX(), rightUpperDot.getY(), dotSize, dotSize);
			obj2D.fillOval(rightLowerDot.getX(), rightLowerDot.getY(), dotSize, dotSize);
			
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	public int getMiddlePointX() {
		return centerX+(width/2);
	}
	
	public int getMiddlePointY() {
		return centerY+(height/2)+3;
	}
	
	
	@Override
	public void setUpPoints() {
		int x = centerX+dotMargin-(dotSize/2);
		int y = centerY+(height/2)-(dotSize/2);
		Dot left = new Dot(x, y, true, false);
		setLeftDot(left);
		
		int x1 = centerX+width-dotMargin-(dotSize/2);
		
		int y1 = centerY+(dotMargin)-(dotSize/2);
		int y2 = centerY+(height)-dotMargin-(dotSize/2);
		
		Dot rightUpDot = new Dot(x1, y1, false, true);
		setRightUpperDot(rightUpDot);
		
		Dot rightLoUDot = new Dot(x1, y2, false, true);
		setRightLowerDot(rightLoUDot);
		
	}
	
	// On top of parent class Icon,
	// Implement repaint using centerX, centerY, text, rightDot values.
	

	public Dot getLeftDot() {
		return leftDot;
	}
	
	public void setLeftDot(Dot leftDot) {
		this.leftDot = leftDot;
	}

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
	

}
