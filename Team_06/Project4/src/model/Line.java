package model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Line extends JComponent{
	public Shape startShape;
	public Shape endShape;
	public int startConnectorIndex;
	public int endConnectorIndex;
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	
	public Line(Shape startShape, Shape endShape, int startConnectorIndex, int endConnectorIndex, int x1, int y1, int x2, int y2) {
		this.startShape = startShape;
		this.endShape = endShape;
		this.startConnectorIndex = startConnectorIndex;
		this.endConnectorIndex = endConnectorIndex;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
//	@Override
//    protected void paintComponent(Graphics g) {
//        g.setColor(Color.BLACK); 
//        g.drawLine(100, 20, 500, 700);
//        super.paintComponent(g);
//    }

}
