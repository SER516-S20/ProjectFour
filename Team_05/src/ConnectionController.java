import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class ConnectionController extends RightPanel implements MouseListener{
	private static Connection tempconnection;
	private static List<Connection> connections;
	private ButtonBox buttonBox;
	public ConnectionController(ButtonBox buttonBox) {
		this.buttonBox = buttonBox;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		e.getComponent().setLocation(e.getX() + (int)e.getComponent().getX()-e.getComponent().getPreferredSize().width/2, 
				 e.getY() + (int)e.getComponent().getY()-e.getComponent().getPreferredSize().height/2);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		connections = super.updateConnection();
		Object obj = e.getComponent().getParent();
		int width = e.getComponent().getParent().getWidth()/2;
		int buttonx = e.getComponent().getLocation().x;
		int tempx = e.getComponent().getParent().getLocation().x + e.getComponent().getLocation().x+5;
		int tempy = e.getComponent().getParent().getLocation().y + e.getComponent().getLocation().y+5;
		boolean selected = false;
		if(buttonx > width) {
			for(int i=0; i < connections.size(); i++) {
				Connection c = connections.get(i);
				if(tempx == c.getSourceX() && tempy == c.getSourceY()) {
					selected = true;
					tempconnection = null;
				}
			}
			if(!selected) {
				if(tempconnection == null) {
					tempconnection = new Connection();
					tempconnection.setSourceX(tempx);
					tempconnection.setSourceY(tempy);
					tempconnection.setSourceButton(obj.hashCode());
				}
				else if(tempconnection != null && tempconnection.getSourceButton() == null && tempconnection.getDestButton() != obj.hashCode()){
					tempconnection.setSourceX(tempx);
					tempconnection.setSourceY(tempy);
					tempconnection.setSourceButton(obj.hashCode());
				}
				else {
					tempconnection = null;
				}
			}
		}
		else{
			for(int i=0; i < connections.size(); i++) {
				Connection c = connections.get(i);
				if(tempx == c.getDestX() && tempy == c.getDestY()) {
					selected = true;
					tempconnection = null;
				}
			}
			if(!selected) {
				if(tempconnection == null) {
					tempconnection = new Connection();
					tempconnection.setDestX(tempx);
					tempconnection.setDestY(tempy);
					tempconnection.setDestButton(obj.hashCode());
				}
				else if(tempconnection != null && tempconnection.getDestButton() == null && tempconnection.getSourceButton() != obj.hashCode()){
					tempconnection.setDestX(tempx);
					tempconnection.setDestY(tempy);
					tempconnection.setDestButton(obj.hashCode());
				}
				else {
					tempconnection = null;
				}
			}
		}
		if(tempconnection != null && tempconnection.getSourceButton() != null && tempconnection.getDestButton() != null) {
			connections.add(tempconnection);
			super.setConnection(tempconnection);
			tempconnection = null;
			e.getComponent().getParent().getParent().repaint();
		}
		
//			RectangleButton btn = (RectangleButton)obj;
//			Point []points = btn.getPointsPosition();
//			if(jX == points[0].x || jX == points[2].x) {
//				if(jY >= points[0].y && jY <= points[1].y) {
//					if(tempconnection == null) {
//						tempconnection = new Connection();
//						tempconnection.setSourceX(btn.getBounds().x+jX);
//						tempconnection.setSourceY(btn.getBounds().y+jY);
//					}
//					else if (tempconnection != null) {
//						tempconnection.setDestX(btn.getBounds().x+jX);
//						tempconnection.setDestY(btn.getBounds().y+jY);
//						rightpanel.setConnection(tempconnection);
//						connections.add(tempconnection);
//						tempconnection = null;
//					}
//					else {
//						tempconnection = null;
//					}
//				}
//			}
//		}

	}
}
