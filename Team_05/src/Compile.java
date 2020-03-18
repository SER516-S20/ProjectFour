import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @author Kairui Hsu
**/
public class Compile extends Thread {
	private List<Connection> connections;
	private Hashtable<Integer, ButtonBox> shapes;;
	private Model model;

	public void run() { 
        try { 
        	model = new Model();
            System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); 
            connections = model.getConnectionCollection();
            shapes = model.getshapes();
            for(int i = 0; i < this.connections.size(); i++) {
            	Connection finishedconnection = connections.get(i);
            	System.out.print(finishedconnection.getSourceX());
            	System.out.print(finishedconnection.getSourceY());
            }
            System.out.println ("Thread " + Thread.currentThread().getId() + " is finished"); 
        } 
        catch (Exception e) { 
            System.out.println ("Exception is caught"); 
        } 
    } 
}
