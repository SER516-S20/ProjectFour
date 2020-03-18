import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * @author Kairui Hsu
**/
public class Compile extends Thread {
	private List<Connection> connections;
	private Hashtable<Integer, ButtonBox> shapes;;
	private Model model = new Model();
	private boolean checkValid = false;
	private int dotNumber;

	public void run() { 
        try { 
            System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); 
            if(model.getConnectionCollection() != null && model.getshapes() != null) {
            	connections = model.getConnectionCollection();
            	shapes = model.getshapes();
            	//rule1:
            	for(ButtonBox shapeValue : shapes.values()) {
            		//System.out.print(shapeValue.());
            	}
            	//rule2: All dots in one shape need to be connected with a line.
            	Set<Integer> keys = shapes.keySet();
            	for(Integer shapeKey : keys) {
            		dotNumber = shapes.get(shapeKey).getBtnDots().length;
            		for(int j = 0 ; j < this.connections.size(); j++) {
            			Connection finishedconnection = connections.get(j);
            			//System.out.println("source button: " + finishedconnection.getSourceButton());
            			//System.out.println("des button: " + finishedconnection.getDestButton());
            			//System.out.println("shape hashcode: " + shapeKey);
            			if(finishedconnection.getSourceButton().equals(shapeKey) || finishedconnection.getDestButton().equals(shapeKey)) {
            				dotNumber--;
            				if(dotNumber == 0) {
            					checkValid = true;
            					break;
            				}
            			}else {
            				checkValid = false;
            			}
            		}
            		if(checkValid == false || dotNumber > 0) {
            			JOptionPane.showMessageDialog(null,"Compile Error!");
            			break;
            		}
            	}
            	if(checkValid == true) JOptionPane.showMessageDialog(null,"Compile Successfully!");
            }
            System.out.println ("Thread " + Thread.currentThread().getId() + " is finished"); 
        } 
        catch (Exception e) { 
            System.out.println ("Exception is caught"); 
        } 
    } 
}
