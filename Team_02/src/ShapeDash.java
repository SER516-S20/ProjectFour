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
	
	
	@Override
	public void paintComponent(Graphics objGraphics) {

		try {
			Graphics2D obj2D = (Graphics2D) objGraphics;
			Shape objRectangle = new Rectangle(this.centerX, this.centerY, width, height);
			obj2D.draw(objRectangle);
			obj2D.drawString(text, getMiddlePointX(), getMiddlePointY());
			
			obj2D.fillOval(leftDot.getX(), leftDot.getY(), dotSize, dotSize);
			obj2D.fillOval(rightDot.getX(), rightDot.getY(), dotSize, dotSize);
				
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
		int y1 = centerY+(height/2)-(dotSize/2);
		Dot right = new Dot(x1, y1, false, true);
		setRightDot(right);
		
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
