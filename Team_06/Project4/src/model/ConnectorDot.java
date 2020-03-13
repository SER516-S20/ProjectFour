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

public class ConnectorDot extends JButton {
	
	type type;
	
	ConnectorDot(int x, int y, type output) {
		this.type = output;
		setBounds(x, y, 10, 10);
	    setBorder(new EmptyBorder(10, 10, 0, 0));
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } 
        else{
            g.setColor(Color.BLACK);
        }
        g.fillRect(0, 0, 10, 10);
        super.paintComponent(g);
    }
}
