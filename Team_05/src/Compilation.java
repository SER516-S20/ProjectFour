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
	private boolean checkValid = true;
	private int dotNumber,leftParenthesisCnt, rightParenthesisCnt;
	String tabName, dialogMessage;

	public Compilation(String tabName) {
	    this.tabName = tabName;
	}
	 
	public void run() { 
        try { 
            System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); 
            if(Model.getTabs().get(tabName).getConnectionCollection() != null && Model.getTabs().get(tabName).getshapes() == null) return;
            dialogMessage = Model.getMessage();
            shapes = Model.getTabs().get(tabName).getshapes();
            connections = Model.getTabs().get(tabName).getConnectionCollection();
            if(rule1() && rule2()) {
            	dialogMessage = dialogMessage + tabName + ": Compiled Successfully!" + "\n";
            	Model.setMessage(dialogMessage);
            }
            rule3();
           	System.out.println ("Thread " + Thread.currentThread().getId() + " is finished");
        } 
        catch (Exception e) { 
            System.out.println ("Exception is caught"); 
        } 
    }
	//rule1: Only allow one left Parenthesis and one right Parenthesis
	public boolean rule1() {
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
			dialogMessage = dialogMessage + tabName + ": Error! More than one left parenthesis or right parenthesis" + "\n";
			Model.setMessage(dialogMessage);
			return false;
		}else if(leftParenthesisCnt == 0) {
			dialogMessage = dialogMessage + tabName + ": Error! Open Paranthesis Shape Missing" + "\n";
			Model.setMessage(dialogMessage);
   			return false;
		}else if(rightParenthesisCnt == 0) {
			dialogMessage = dialogMessage + tabName + ": Error! Close Paranthesis Shape Missing" + "\n";
			Model.setMessage(dialogMessage);
   			return false;
		}else {
			return true;
		}
	}
    //rule2: Each Bar/Dot needs be connected to at least one another Bar/Dot.
	public boolean rule2() {
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
				dialogMessage = dialogMessage + tabName + ": Error! Each Bar/Dot needs be connected to at least one another Bar/Dot" + "\n";
				Model.setMessage(dialogMessage);
				checkValid = false;
				break;
			}
		}
		return checkValid;
	}
    //rule3: check loop
	public boolean rule3() {
        int V = shapes.size(), E = connections.size(); 
        //int V = 3, E = 2; 
        Graph graph = new Graph(V, E); 
        // add edge 0-1 
        for(int i = 0 ; i < E ; i++) {
        	Connection finishedconnection = connections.get(i);
        	graph.edge[i].src = finishedconnection.getSourceButton().intValue(); 
        	graph.edge[i].dest = finishedconnection.getDestButton().intValue(); 
        }
        // add edge 1-2 
        //graph.edge[1].src = 1; 
        //graph.edge[1].dest = 2; 
  
        // add edge 0-2 
        //graph.edge[2].src = 0; 
        //graph.edge[2].dest = 2;
		//new Graph();
        if (graph.isCycle(graph)==1) 
            System.out.println( "graph contains cycle" ); 
        else
            System.out.println( "graph doesn't contain cycle" ); 
		return false;
	}
}