package model;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import model.Shape.type;

/**
 * 
 * @author somesh
 * @since 02-28-2020
 */

public class ConnectorBar extends JButton{
	
	type type;
	
	ConnectorBar(int x, int y, type t){
		this.type = t;
		setBounds(x, y, 10, 40);
	    setBorder(new EmptyBorder(10, 40, 0, 0));
	}
	
	@Override
    protected void paintComponent(Graphics g)  {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } 
        else{
            g.setColor(Color.BLACK);
        }
        g.fillRect(0, 0, 10, 40);
        super.paintComponent(g);
    }
}
