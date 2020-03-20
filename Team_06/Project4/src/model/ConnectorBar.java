package model;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import controller.DrawLine;
import model.Shape.type;

/**
 * 
 * @author somesh
 * @since 02-28-2020
 */

public class ConnectorBar extends Connector{
	
	public ArrayList <Connector> toConnector = new ArrayList<Connector>();
	
	ConnectorBar(int x, int y, type t){
		super(t);
		setBounds(x, y, 10, 40);
	    setBorder(new EmptyBorder(10, 40, 0, 0));
	    
	    new DrawLine(this);
	}
	
	public ArrayList<Connector> getToConnector() {
		return toConnector;
	}

	public void setToConnector(ArrayList<Connector> toConnector) {
		this.toConnector = toConnector;
	}

	@Override
    protected void paintComponent(Graphics g)  {
        if (getModel().isArmed()) {
            g.setColor(Color.LIGHT_GRAY);
        } 
        else{
            g.setColor(Color.BLACK);
        }
        g.fillRect(0, 0, 10, 40);
        super.paintComponent(g);
    }
}
