package view;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import controller.Tab;
import model.Connector;
import model.Data;
import model.Line;
import model.TabData;


/**
 * @author: Rahul
 * @Date: 03-07-2020
 * @Description: Right Panel will have different shapes added which are selected in left panel.
 */
public class RightPanel extends JPanel  {
	
	private static final long serialVersionUID = 1L;
	private static RightPanel single_instance = null;
	public boolean selected = false;
	public Connector tempStartDot;
	
	public static RightPanel getInstance(){
		if (single_instance == null)
			single_instance = new RightPanel();
		return single_instance;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        
        int tabNumber = Tab.selectedTab();
        TabData tabData = Data.getInstance().getTab(tabNumber);
        ArrayList<Line> lines = tabData.getLines();
        
        for(Line l : lines) {	
	        	int x1 = l.x1 + l.startShape.getX(); 
	        	int y1 = l.y1 + l.startShape.getY(); 
	        	int x2 = l.x2 + l.endShape.getX();
	        	int y2 = l.y2 + l.endShape.getY();
	        	g.drawLine(x1, y1, x2, y2);
        }        
    }
	
}
