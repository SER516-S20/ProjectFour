package view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import controller.SelectShape;

/**
 * @author: Suyog
 * @Date: 01/28/2020
 * @Description: Right Panel will have different shapes added which are selected in left panel.
 */
public class RightPanel extends JPanel{
	public int shapeNumber = 0;
	private static RightPanel single_instance = null;
	boolean selected = false;

	ArrayList<Point> circlePoints = new ArrayList<Point>();
	ArrayList<Point> squarePoints = new ArrayList<Point>();
	ArrayList<Point> trianglePoints = new ArrayList<Point>();
	
	public static RightPanel getInstance(){
		if (single_instance == null)
			single_instance = new RightPanel();
		return single_instance;
	}
	
	RightPanel(){
		SelectShape selectShape = new SelectShape();
		selectShape.release(this);
	}
}