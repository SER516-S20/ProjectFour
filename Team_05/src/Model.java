import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Model {
	private static List<Connection> connections = new ArrayList<Connection>();
	
	public Model() {
		
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
		
	}
	public boolean updateConnectionList() {
		return true;
	}
	
	/*
	 * get all the connections 
	 */
	public List<Connection> getConnectionCollection(){
		return null;
	}
	
	public boolean isDotUsed(Point aDot) {
		return true;
	}
}
