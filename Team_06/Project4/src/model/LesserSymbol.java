package model;
import java.awt.Color;
import java.awt.Graphics;
import controller.Drag;
import controller.ShapeMouseListener;

/**
 * 
 * @Author: Dhananjay
 * @Since: 03-07-2020
 * @Description: This class is used to model '<' button, which inherits the Shape abstract class, 
 * and is used in both left and right panels.
 */
public class LesserSymbol extends Shape {
	
	private static final long serialVersionUID = 1L;
	
	public LesserSymbol(int x, int y, boolean rightPanel){
		super("<",x,y);
		
		if(rightPanel) {
			new ShapeMouseListener(this);			
			ConnectorDot rightTop = new ConnectorDot(getSize().width - 20, getSize().height * 1 / 4, type.OUTPUT);
			ConnectorDot rightBottom = new ConnectorDot(getSize().width - 20, getSize().height * 3 / 4, type.OUTPUT);
			ConnectorDot leftMiddle = new ConnectorDot(20, getSize().height/2, type.INPUT);
			
			this.connectors.add(leftMiddle);
			this.connectors.add(rightTop);
			this.connectors.add(rightBottom);
			
			this.add(leftMiddle);
			this.add(rightTop);
			this.add(rightBottom);
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
        //This is the funtion used to paint the dots.
        super.paintComponent(g);
    }
	
    // This is the method used to paint the button
    protected void paintBorder(Graphics g) 
    {
        g.setColor(getForeground());
        g.drawRect(0, 0, getSize().width, getSize().height);
        g.fillRect(getSize().width - 20, getSize().height * 3 / 4, 10, 10);
        g.fillRect(getSize().width - 20, getSize().height * 1 / 4, 10, 10);
        g.fillRect(20, getSize().height/2, 10, 10);
    }
    
}
