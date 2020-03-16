package model;
import java.awt.Color;
import java.awt.Graphics;

import controller.Drag;
import controller.ShapeMouseListener;
import model.Shape.type;

public class OpenParanthesis extends Shape{
	public OpenParanthesis(int x, int y, boolean rightPanel){
		super("(",x,y);
		
		if(rightPanel) {
			new ShapeMouseListener(this);
			
			ConnectorDot rightMiddle = new ConnectorDot(getSize().width - 20, getSize().height/2, type.OUTPUT);
			
			this.connectors.add(rightMiddle);
			this.add(rightMiddle);
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
        g.fillRect(getSize().width - 20, getSize().height/2, 10, 10);
    }
}
