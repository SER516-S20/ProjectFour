package model;
import java.awt.Color;
import java.awt.Graphics;
import controller.Drag;
import controller.ShapeMouseListener;
import model.Shape.type;

/**
 * 
 * @Author: Somesh
 * @Since: 01-29-2020
 * @Description: This model class defines the ')' button, which inherits the Shape abstract class, which is used in the left and right panels of the application.
 */
public class CloseParanthesis extends Shape{
	
	public CloseParanthesis(int x, int y, boolean rightPanel){
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
            g.setColor(Color.lightGray);
        } 
        else {
            g.setColor(getBackground());
        }
        // This is the funtion used to paint 
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
