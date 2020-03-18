package model;
import java.awt.Color;
import java.awt.Graphics;

import controller.Drag;
import controller.ShapeMouseListener;
import model.Shape.type;

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
	
	@Override
	protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } 
        else {
            g.setColor(getBackground());
        }
        //g.fillRect(0, 0, getSize().width, getSize().height);
        super.paintComponent(g);
    }
	
    protected void paintBorder(Graphics g) 
    {
        g.setColor(getForeground());
        g.drawRect(0, 0, getSize().width, getSize().height);
        g.fillRect(10, getSize().height/2, 10, 10);
    }
}