import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Hashtable;

import javax.swing.JPanel;

public class RightTabbedPaneController implements ActionListener, MouseListener, MouseMotionListener{
	private RightTabbedPane rightTabbedPane;
	private Hashtable<String, TabInfo> tabs;
	
	RightTabbedPaneController()
	{
		if(Model.getRightTabbedPane()==null)
		{
			Model.setRightTabbedPane(new RightTabbedPane());
		}
		rightTabbedPane = Model.getRightTabbedPane();
		tabs = Model.getTabs();
	}
	
	public boolean addWorkingAreaTab(RightPanel tab)
	{
		boolean added = false;
		if(tabs == null)
		{
			tabs = new Hashtable<String, TabInfo>();
		}
		if(tab.getName() == null)
		{
			added = false;
		}
		else if(!tabs.containsKey(tab.getName()))
		{
			tabs.put(tab.getName(), new TabInfo(tab));
			added = true;
			rightTabbedPane.add(tab.getName(),tab);
			tab.addMouseListener(this);
		}
		return added;
	}
	
	public void addWorkingAreaTab()
	{
		String init_name = "unnamedTab";
		String name = init_name;
		int count = 1;
		if(tabs == null)
		{
			tabs = new Hashtable<String, TabInfo>();
		}
		while(tabs.containsKey(name))
		{
			name = init_name + Integer.toString(count);
			count++;
		}
		RightPanel tab = new RightPanel(name);
		addWorkingAreaTab(tab);
	}
	
	public String getCurrentTabName()
	{
		return ((WorkingAreaTab)rightTabbedPane.getSelectedComponent()).getName();
	}
	
	public WorkingAreaTab getCurrentTab()
	{
		return (WorkingAreaTab)rightTabbedPane.getSelectedComponent();
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
