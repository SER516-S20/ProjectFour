package model;
import java.awt.Color;
import java.awt.Graphics;
import controller.Drag;
import controller.ShapeMouseListener;
import model.Shape.type;

/**
 * 
 * @Author: Suyog
 * @Since: 01-29-2020
 * @Description: This class is used to model '(' button, which inherits the Shape abstract class, and is used in both left and right panels.
 */
public class OpenParentheses extends Shape{
	public OpenParentheses(int x, int y, boolean rightPanel){
		super("(",x,y);
		
		if(rightPanel) {
			new ShapeMouseListener(this);
			
			ConnectorDot rightMiddle = new ConnectorDot(getSize().width - 20, getSize().height/2, type.OUTPUT);
			
			this.connectors.add(rightMiddle);
			this.add(rightMiddle);
			new Drag(this);

		}
	}
	// This method is used to paint the dots.
	@Override
	protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } 
        else {
            g.setColor(getBackground());
        }
        // This is the function used to paint the dots.
        super.paintComponent(g);
    }
    // This is the function used to paint the button.
    protected void paintBorder(Graphics g) 
    {
        g.setColor(getForeground());
        g.drawRect(0, 0, getSize().width, getSize().height);
        g.fillRect(getSize().width - 20, getSize().height/2, 10, 10);
    }
}
