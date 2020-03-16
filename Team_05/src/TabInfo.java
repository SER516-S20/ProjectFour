import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * 
 * @author Yijian Hu
 *
 */
public class TabInfo {
	private String name;
	private WorkingAreaTab workingAreaTab;
	private Hashtable<Integer, ButtonBox> shapes;
	private List<Connection> connections;
	
	TabInfo(WorkingAreaTab workingAreaTab)
	{
		this.workingAreaTab = workingAreaTab;
		this.name = workingAreaTab.getName();
		shapes = new Hashtable<Integer, ButtonBox>();
		connections = new ArrayList<Connection>();
	}
	
	public void setshapes( Hashtable<Integer, ButtonBox> inshapes) {
		this.shapes = inshapes;
	}
	
	public Hashtable<Integer, ButtonBox> getshapes() {
		return shapes;
	}
	
	public void addConnection(Connection conn) {
		connections.add(conn);
	}
	
	public List<Connection> getConnectionCollection(){
		return connections;
	}
	
	public WorkingAreaTab getTab()
	{
		return workingAreaTab;
	}
}
