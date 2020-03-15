package model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Line extends JComponent{
	public Connector startDot;
	public Connector endDot;
	
	public Line(Connector startDot, Connector endDot) {
		this.startDot = startDot;
		this.endDot = endDot;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK); 
        g.drawLine(100, 20, 500, 700);
        super.paintComponent(g);
    }

}
