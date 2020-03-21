package model;
import java.awt.Color;
import java.awt.Graphics;

import controller.Drag;
import controller.ShapeMouseListener;
/**
 * 
 * @Author: Sheran
 * @Since: 03-07-2020
 * @Description: This model class is used to define the '@' button, which inherits the Shape abstract class, which is
 * used on the left and right panels of the application. 
 */
public class AtSymbol extends Shape{
	
	private static final long serialVersionUID = 1L;

	public AtSymbol(int x, int y, boolean rightPanel){
		super("@",x,y);
		if(rightPanel) {
			new ShapeMouseListener(this);
			ConnectorDot leftTop = new ConnectorDot(20, getSize().height * 1 / 4, type.INPUT);
			ConnectorDot leftBottom = new ConnectorDot(20, getSize().height * 3 / 4, type.INPUT);
			ConnectorDot rightTop = new ConnectorDot(getSize().width - 20, getSize().height * 1 / 4, type.OUTPUT);
			ConnectorDot rightBottom = new ConnectorDot(getSize().width - 20, getSize().height * 3 / 4, type.OUTPUT);
			
			this.connectors.add(leftTop);
			this.connectors.add(leftBottom);
			this.connectors.add(rightTop);
			this.connectors.add(rightBottom);
			
			this.add(leftTop);
			this.add(leftBottom);
			this.add(rightTop);
			this.add(rightBottom);
			
			new Drag(this);
		}
	}
	
	// Used to paint the dots in the button
	@Override
	protected void paintComponent(Graphics g) {
		//This condition is so that the dot changes color when clicked by the user.
        if (getModel().isArmed()) {
            g.setColor(Color.LIGHT_GRAY);
        } 
        else {
            g.setColor(getBackground());
        }
        // This is the function to paint the dots in the button.
        super.paintComponent(g);
    }
	
    // This is used to paint the button
    protected void paintBorder(Graphics g) 
    {
    	
        g.setColor(getForeground());
        g.drawRect(0, 0, getSize().width, getSize().height);
        g.fillRect(getSize().width - 20, getSize().height * 3 / 4, 10, 10);
        g.fillRect(getSize().width - 20, getSize().height * 1 / 4, 10, 10);
        g.fillRect(20, getSize().height * 3 / 4, 10, 10);
        g.fillRect(20, getSize().height * 1 / 4, 10, 10);
    }
    
}
