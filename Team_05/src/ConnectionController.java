import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class ConnectionController implements MouseListener {
	private static Connection tempconnection;
	private static List<Connection> connections = new ArrayList<Connection>();
	private RightPanel rightpanel = new RightPanel();
	private ButtonBox buttonBox;
	public ConnectionController(ButtonBox buttonBox) {
		this.buttonBox = buttonBox;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getComponent().getParent();
		System.out.print("======"+connections.size()+"\n");
		int width = e.getComponent().getParent().getWidth()/2;
		int buttonx = e.getComponent().getLocation().x;
		int tempx = e.getComponent().getParent().getLocation().x + e.getComponent().getLocation().x+5;
		int tempy = e.getComponent().getParent().getLocation().y + e.getComponent().getLocation().y+5;
		boolean selected = false;
		if(buttonx > width) {
			if(!obj.getClass().toString().equalsIgnoreCase("class BarButtonBox")) {
				for(int i=0; i < connections.size(); i++) {
					Connection c = connections.get(i);
					if(tempx == c.getSourceX() && tempy == c.getSourceY()) {
						selected = true;
						tempconnection = null;
					}
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
			if(!obj.getClass().toString().equalsIgnoreCase("class BarButtonBox")) {
				for(int i=0; i < connections.size(); i++) {
					Connection c = connections.get(i);
					if(tempx == c.getDestX() && tempy == c.getDestY()) {
						selected = true;
						tempconnection = null;
					}
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
			System.out.print("=============\n"+tempconnection.getSourceX()+"\n");
			System.out.print("=============\n"+tempconnection.getSourceY()+"\n");
			
			connections.add(tempconnection);
			this.rightpanel.setConnection(tempconnection);
			System.out.print("==============="+connections.get(0).getSourceX()+"\n");
			tempconnection = null;
			e.getComponent().getParent().getParent().repaint();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
