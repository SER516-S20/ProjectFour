import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * @author Kairui Hsu
**/
public class Compilation extends Thread {
	private List<Connection> connections;
	private Hashtable<Integer, ButtonBox> shapes;
	private static Hashtable<String, TabInfo> tabs;
	private Model model = new Model();
	private boolean checkValid = false;
	private int dotNumber,leftParenthesisCnt, rightParenthesisCnt;
	String tabName;

	public Compilation(String tabName) {
	    this.tabName = tabName;
	}
	 
	public void run() { 
        try { 
            System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); 
            if(Model.getTabs().get(tabName).getConnectionCollection() != null && Model.getTabs().get(tabName).getshapes() == null) {
            	return;
            }
            connections = Model.getTabs().get(tabName).getConnectionCollection();
            shapes = Model.getTabs().get(tabName).getshapes();
           	//rule1: Only allow one left Parenthesis and one right Parenthesis
           	leftParenthesisCnt = 0;
           	rightParenthesisCnt = 0;
           	for(ButtonBox shapeValue : shapes.values()) {
           		String str = shapeValue.getSymbol();
           		switch(str) {
           			case "(":
           				leftParenthesisCnt++;
           				break;
           			case ")":
           				rightParenthesisCnt++;
           				break;
           			default:
           				break;
           		}
           	}
           	if(leftParenthesisCnt > 1 || rightParenthesisCnt > 1) {
       			JOptionPane.showMessageDialog(null,tabName + ": Compile Error! More than one left parenthesis or right parenthesis");
       			return;
           	}else if(leftParenthesisCnt == 0) {
           		JOptionPane.showMessageDialog(null,tabName + ": Compile Error! Open Paranthesis Shape Missing");
           		return;
           	}else if(rightParenthesisCnt == 0) {
           		JOptionPane.showMessageDialog(null,tabName + ": Compile Error! Close Paranthesis Shape Missing");
           		return;
           	}
            //rule2: All dots in one shape need to be connected with a line.
            Set<Integer> keys = shapes.keySet();
            for(Integer shapeKey : keys) {
            	dotNumber = shapes.get(shapeKey).getBtnDots().length;
            	for(int j = 0 ; j < this.connections.size(); j++) {
            		Connection finishedconnection = connections.get(j);
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
           			JOptionPane.showMessageDialog(null,tabName + ": Compile Error! Each Bar/Dot needs be connected to at least one another Bar/Dot");
           			break;
           		}
           	}
            //rule3: check loop
            //do something
           	if(checkValid == true) JOptionPane.showMessageDialog(null,tabName + ": Compile Successfully!");
            System.out.println ("Thread " + Thread.currentThread().getId() + " is finished"); 
        } 
        catch (Exception e) { 
            System.out.println ("Exception is caught"); 
        } 
    } 
}
