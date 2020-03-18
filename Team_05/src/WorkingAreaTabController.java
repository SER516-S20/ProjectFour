import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class WorkingAreaTabController implements ActionListener, MouseListener, MouseMotionListener{

	public boolean addButtonToCurrentTab(ButtonBox button)
	{
		WorkingAreaTab tab = (WorkingAreaTab)Model.getRightTabbedPane().getSelectedComponent();
		TabInfo tabinfo = Model.getTabs().get(tab.getName());
		if(tabinfo.getshapes().containsKey(button.getId()))
			return false;
		return false;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		WorkingAreaTab tab = (WorkingAreaTab)Model.getRightTabbedPane().getSelectedComponent();
		TabInfo tabinfo = Model.getTabs().get(tab.getName());
		if(e.getSource().equals(tab)) {
			Box instance = Box.getInstance();
			if(instance.getText() == null) {
				return;
			}
			//addButton(instance.getText(),e.getX(),e.getY());
			ButtonBox btn = ButtonBoxFactory.buildButtonBox(instance.getText());
			btn.addMouseListener(this);
			btn.addMouseMotionListener(this);
			
			System.out.println("====" + this.getComponentCount());
			System.out.println("e.getX() " + e.getX());
			System.out.println("e.getY() " + e.getY());
		}else {
			if (e.getClickCount() == 2) {
				Object source = e.getComponent();
				if(source instanceof JPanel){
					ButtonBox panelPressed = (ButtonBox) source;
					if(vPane == null) {
						vPane = panelPressed.createJOptionPane();
						panelPressed.setTitle(vPane.getvalue());
					}else {
						vPane.setValue(panelPressed.getTitle());
						panelPressed.setTitle(vPane.getvalue());
					}
				}
			}
		}
		if(e.getButton() == MouseEvent.BUTTON3) {
			this.remove(e.getComponent());
			connections.removeIf(n->(n.getSourceButton()==e.getComponent().hashCode()));
			connections.removeIf(n->(n.getDestButton()==e.getComponent().hashCode()));
			this.repaint();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
