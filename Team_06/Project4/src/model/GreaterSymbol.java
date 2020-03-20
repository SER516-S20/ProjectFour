package model;
import java.awt.Color;
import java.awt.Graphics;
import controller.Drag;
import controller.ShapeMouseListener;
import model.Shape.type;

/**
 * 
 * @Author: Rahul
 * @Since: 01-29-2020
 * @Description: This class is used to model '>' button, which inherits the Shape abstract class, and is used in both left and right panels.
 */
public class GreaterSymbol extends Shape{
	public GreaterSymbol(int x, int y, boolean rightPanel){
		super(">",x,y);
		
		if(rightPanel) {
			new ShapeMouseListener(this);
			ConnectorDot leftTop = new ConnectorDot(20, getSize().height * 1 / 4, type.INPUT);
			ConnectorDot leftBottom = new ConnectorDot(20, getSize().height * 3 / 4, type.INPUT);
			ConnectorDot rightMiddle = new ConnectorDot(getSize().width - 20, getSize().height/2, type.OUTPUT);
			
			this.connectors.add(leftTop);
			this.connectors.add(leftBottom);
			this.connectors.add(rightMiddle);
			
			this.add(leftTop);
			this.add(leftBottom);
			this.add(rightMiddle);
			new Drag(this);

		}
	}
	//This is the method used to paint the dots.
	@Override
	protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } 
        else {
            g.setColor(getBackground());
        }
        //This is the function used to paint
        super.paintComponent(g);
    }
    // This method is used to paint the button.
    protected void paintBorder(Graphics g) 
    {
        g.setColor(getForeground());
        g.drawRect(0, 0, getSize().width, getSize().height);
        g.fillRect(20, getSize().height * 3 / 4, 10, 10);
        g.fillRect(20, getSize().height * 1 / 4, 10, 10);
        g.fillRect(getSize().width - 20, getSize().height/2, 10, 10);
    }
}
