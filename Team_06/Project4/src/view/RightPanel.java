package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
//import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.NewTab;
import controller.SelectShape;
import model.Connector;
import model.Data;
import model.Line;
import model.Shape;
import model.ShapeData;
import model.TabData;


/**
 * @author: Suyog
 * @Date: 01/28/2020
 * @Description: Right Panel will have different shapes added which are selected in left panel.
 */
public class RightPanel extends JPanel{
	//public int shapeNumber = 0;
	private static RightPanel single_instance = null;
	public boolean selected = false;
	public Connector tempStartDot;

	//public ArrayList<Line> lines = new ArrayList<Line>();
	
	public static RightPanel getInstance(){
		if (single_instance == null)
			single_instance = new RightPanel();
		return single_instance;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        
        int tabNumber = NewTab.selectedTab();
        TabData tabData = Data.getInstance().getTab(tabNumber);
        ArrayList<Shape> shapes = tabData.getShapes();
        ArrayList<Line> lines = tabData.getLines();
        
        for(Line l : lines) {
        	
//        	System.out.println("x1 - " + l.x1);
//        	System.out.println("x2 - " + l.startDot.getParent().getX());
//        	System.out.println("y1 - " + l.y1);
//        	System.out.println("y2 - " + l.startDot.getParent().getY());
        	
	        	int x1 = l.x1 + l.startDot.getX(); 
	        	int y1 = l.y1 + l.startDot.getY(); 
	        	int x2 = l.x2 + l.endDot.getX();
	        	int y2 = l.y2 + l.endDot.getY();
	        	g.drawLine(x1, y1, x2, y2);
        }
        
        //g.fillOval(0, 0, getSize().width, getSize().height);
        
    }
}