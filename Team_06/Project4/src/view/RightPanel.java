package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import controller.SelectShape;
import model.Connector;
import model.Line;

/**
 * @author: Suyog
 * @Date: 01/28/2020
 * @Description: Right Panel will have different shapes added which are selected in left panel.
 */
public class RightPanel extends JPanel{
	public int shapeNumber = 0;
	private static RightPanel single_instance = null;
	public boolean selected = false;
	public Connector tempStartDot;

	public ArrayList<Point> circlePoints = new ArrayList<Point>();
	public ArrayList<Point> squarePoints = new ArrayList<Point>();
	public ArrayList<Point> trianglePoints = new ArrayList<Point>();
	public ArrayList<Line> lines = new ArrayList<Line>();
	
	public static RightPanel getInstance(){
		if (single_instance == null)
			single_instance = new RightPanel();
		return single_instance;
	}
	
	public RightPanel(){
		SelectShape selectShape = new SelectShape();
		//selectShape.release(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        System.out.println("Number of lines " + lines.size());
        final int ARR_SIZE = 4;
        for(Line l : lines) {
        	
        	System.out.println(l.startDot.getX());
        	System.out.println(l.startDot.getParent().getX());
        	System.out.println(l.startDot.getY());
        	System.out.println(l.startDot.getParent().getY());
        	
        	g.drawLine(l.startDot.getX()+l.startDot.getParent().getX(), l.startDot.getY()+l.startDot.getParent().getY(), 
        			l.endDot.getX()+l.endDot.getParent().getX(), l.endDot.getY()+l.endDot.getParent().getY());
        }
        
        //g.fillOval(0, 0, getSize().width, getSize().height);
        
    }
}