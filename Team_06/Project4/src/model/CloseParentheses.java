package model;
import java.awt.Color;
import java.awt.Graphics;
import controller.Drag;
import controller.ShapeMouseListener;

/**
 * 
 * @Author: Somesh
 * @Since: 03-07-2020
 * @Description: This model class defines the ')' button, which inherits the Shape abstract class, 
 * which is used in the left and right panels of the application.
 */
public class CloseParentheses extends Shape {
	
	private static final long serialVersionUID = 1L;
	
	public CloseParentheses(int x, int y, boolean rightPanel){
		super(")",x,y);
		
		if(rightPanel) {
			new ShapeMouseListener(this);
			ConnectorDot leftMiddle = new ConnectorDot(10, getSize().height/2, type.INPUT);
			
			this.connectors.add(leftMiddle);
			this.add(leftMiddle);
			System.out.println("");
			new Drag(this);
		}
	}
	
	// This method is used to paint the dots in the button
	@Override
	protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.LIGHT_GRAY);
        } 
        else {
            g.setColor(getBackground());
        }
        // This is the function used to paint 
        super.paintComponent(g);
    }
	
    // This method is used to paint the button
    protected void paintBorder(Graphics g) 
    {
        g.setColor(getForeground());
        g.drawRect(0, 0, getSize().width, getSize().height);
        g.fillRect(10, getSize().height/2, 10, 10);
    }
    
}
