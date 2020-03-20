package model;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import controller.DrawLine;
import model.Shape.type;

/**
 * 
 * @Author: Suyog, Rahul
 * @Since: 02-28-2020
 * @Description: This class inherits the Connector abstract class and is used to define the dots used in buttons.
 */

public class ConnectorDot extends Connector {
	public Connector toConnector = null;
	// x and y are the coordinates of the dots.
	ConnectorDot(int x, int y, type t) {
	    super(t);
	    setBounds(x, y, 15, 15);
	    setBorder(new EmptyBorder(10, 10, 0, 0));
	    new DrawLine(this);
	}
	
	public Connector getToConnector() {
		return toConnector;
	}

	public void setToConnector(Connector toConnector) {
		this.toConnector = toConnector;
	}
	// This is the method used to paint the dots.
	@Override
    	protected void paintComponent(Graphics g) {
            if (getModel().isArmed()) {
                g.setColor(Color.LIGHT_GRAY);
            } 
            else{
                g.setColor(Color.BLACK);
            }
        g.fillRect(0, 0, 10, 10);
        super.paintComponent(g);
    }
}
