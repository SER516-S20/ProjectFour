import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Model {
	private static List<Connection> connections = new ArrayList<Connection>();
	private static RightTabbedPane rightTabbedPane;
	private static Hashtable<String, WorkingAreaTab> tabs;
	private static Hashtable<Integer, ButtonBox> shapes;
	
	
	public Model() {
		//shapes = new Hashtable<Integer, ButtonBox>();
	}
	
	public void setshapes( Hashtable<Integer, ButtonBox> inshapes) {
		this.shapes = inshapes;
	}
	
	public Hashtable<Integer, ButtonBox> getshapes() {
		return shapes;
	}
	
	/*
	 * this method is used to remove the existed button by
	 * clicking the mouse right button
	 */
	public Component removeComponent(Component btnBox) {
		
		return btnBox;
	}
	
	/*
	 * this method is used to add a new connection to the collection
	 */
	public void addConnection(Connection conn) {
		connections.add(conn);
	}
	
	public boolean updateConnectionList() {
		return true;
	}
	
	/*
	 * get all the connections 
	 */
	public List<Connection> getConnectionCollection(){
		return connections;
	}
	
	public boolean isDotUsed(Point aDot) {
		return true;
	}
	
	public void setRightTabbedPane(RightTabbedPane rightTabbedPane)
	{
		this.rightTabbedPane = rightTabbedPane;
	}
	
	public RightTabbedPane getRightTabbedPane()
	{
		return rightTabbedPane;
	}
	
	public boolean addWorkingAreaTab(WorkingAreaTab tab)
	{
		boolean added = false;
		if(tabs == null)
		{
			tabs = new Hashtable<String, WorkingAreaTab>();
		}
		if(tab.getName() == null)
		{
			added = false;
		}
		else if(!tabs.containsKey(tab.getName()))
		{
			tabs.put(tab.getName(), tab);
			added = true;
			rightTabbedPane.add(tab.getName(),tab);
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
			tabs = new Hashtable<String, WorkingAreaTab>();
		}
		while(tabs.containsKey(name))
		{
			name = init_name + Integer.toString(count);
			count++;
		}
		WorkingAreaTab tab = new WorkingAreaTab(name);
		addWorkingAreaTab(tab);
	}
}
