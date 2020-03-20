
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ShapeOpenParan extends Icon{
	
	
	private static final long serialVersionUID = 1L;
	
	private static String text = "(";
	private Dot rightDot;
	
	
	public ShapeOpenParan(int x, int y) {
		
		this.centerX = x;
		this.centerY = y;
		
		setUpPoints();
		repaint();
		
		// call paint component from here, repaint ?!
	}
	
	// On top of parent class Icon,
	// Implement repaint using centerX, centerY, text, rightDot values.
	
	
	@Override
	public void paintComponent(Graphics objGraphics) {

		try {
			Graphics2D obj2D = (Graphics2D) objGraphics;
			Shape objRectangle = new Rectangle(this.centerX, this.centerY, width, height);
			obj2D.draw(objRectangle);
			obj2D.drawString(text, getMiddlePointX(), getMiddlePointY());
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
		int x = centerX+width-dotMargin-(dotSize/2);
		int y = centerY+(height/2)-(dotSize/2);
		Dot rightDot = new Dot(x, y, false, true);
		setRightDot(rightDot);
	}
	

	public Dot getRightDot() {
		return rightDot;
	}

	public void setRightDot(Dot rightDot) {
		this.rightDot = rightDot;
	}

	

}
