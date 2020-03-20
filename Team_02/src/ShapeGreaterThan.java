import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

public class ShapeGreaterThan extends Icon{

	private static final long serialVersionUID = 1L;
	private int centerX;
	private int centerY;
	private static String text = ">";
	private Dot rightDot;
	private Dot leftUpperDot, leftLowerDot;
	
	public ShapeGreaterThan(int x, int y) {
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
			
			
			obj2D.fillOval(rightDot.getX(), rightDot.getY(), dotSize, dotSize);
			obj2D.fillOval(leftUpperDot.getX(), leftUpperDot.getY(), dotSize, dotSize);
			obj2D.fillOval(leftLowerDot.getX(), leftLowerDot.getY(), dotSize, dotSize);
			
			
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
		int x = centerX+width-dotMargin-(dotSize/2);
		int y = centerY+(height/2)-(dotSize/2);
		Dot right = new Dot(x, y, false, true);
		setRightDot(right);
		
		int x1 = centerX+dotMargin-(dotSize/2);
		int y1 = centerY+(dotMargin)-(dotSize/2);
		int y2 = centerY+(height)-dotMargin-(dotSize/2);
		
		Dot lefttUpDot = new Dot(x1, y1, true, false);
		setLeftUpperDot(lefttUpDot);
		
		Dot lefttLoUDot = new Dot(x1, y2, true, false);
		setLeftLowerDot(lefttLoUDot);
		
	}
	
	// On top of parent class Icon,
	// Implement repaint using centerX, centerY, text, rightDot values.
	
	public Dot getRightDot() {
		return rightDot;
	}

	public void setRightDot(Dot rightDot) {
		this.rightDot = rightDot;
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
