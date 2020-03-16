package model;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import controller.DrawLine;
import model.Shape.type;


/**
 * 
 * @author somesh
 * @since 02-28-2020
 */

public class ConnectorDot extends Connector {
	
//	public boolean line = false;
	public Connector toConnector = null;
	
	ConnectorDot(int x, int y, type t) {
		super(t);
		setBounds(x, y, 10, 10);
	    setBorder(new EmptyBorder(10, 10, 0, 0));
	    
	    new DrawLine(this);
	}
	
	public Connector getToConnector() {
		return toConnector;
	}

	public void setToConnector(Connector toConnector) {
		this.toConnector = toConnector;
	}

	
	
	@Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.BLACK);
        } 
        else{
            g.setColor(Color.BLACK);
        }
        g.fillRect(0, 0, 10, 10);
        super.paintComponent(g);
    }
}
