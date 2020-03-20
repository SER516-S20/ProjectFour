package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenu;

import com.sun.java.swing.plaf.windows.resources.windows;
import static javax.swing.JOptionPane.showMessageDialog;

import model.Connector;
import model.ConnectorBar;
import model.ConnectorDot;
import model.Data;
import model.Shape;
import model.Shape.type;
import model.TabData;

public class Compile {
	public Compile(JMenu compile){
		compile.addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent e) {
	        	 String msg = compileTab();
	        	 showMessageDialog(null, msg);
	          	}
			});
	}
	
	public String compileTab() {
		System.out.println("Inside Compile Method");
		int tabNumber = NewTab.selectedTab();
	    TabData tabData = Data.getInstance().getTab(tabNumber);
	    System.out.println("Compiling "+tabNumber+" th tab");
	    
	    if(!tabData.isOpenParaFlag()) {
	    	return "Compile Failed : \nOpen Paranthesis Shape Missing";
	    }
	    
	    if(!tabData.isCloseParaFlag()) {
	    	return "Compile Failed : \nClose Paranthesis Shape Missing";
	    }
	    
	    ArrayList<Shape> shapes = tabData.getShapes();
	    
	    boolean allConnected = true;	    
	    int numberOfNodes =  shapes.size();
	    
	    Graph graph = new Graph(numberOfNodes);
	   
	    
	    
	    for (Shape shape : shapes) {	
	    	int fromIndex = shapes.indexOf(shape);
	    	Set<Integer> toShapes = new HashSet<Integer>(); 
	    	for (Connector connector : shape.getConnectors()) {
	    		if (!connector.lineFlag) {	    			
	    			allConnected = false;
	    			break;
	    		}
	    		if ( connector.type == type.OUTPUT) {
	    			if (connector instanceof ConnectorDot) {
		    			toShapes.add(((Shape) ((ConnectorDot)connector).getToConnector().getParent()).getShapeIndex());
		    		}else if (connector instanceof ConnectorBar){
		    			for (Connector con: ((ConnectorBar) connector).getToConnector()) {
		    				toShapes.add(((Shape) con.getParent()).getShapeIndex());
		    			}
		    			
		    		}
	    		}
	    		
	    	}	    	
	    	if (!allConnected) {
	    		break;
	    	}
	    	
	    	for(int to : toShapes) {
	    		graph.addEdge(fromIndex, to);
	    	}
	    }
	    
	    if(!allConnected) {
	    	return "Compile Failed : \nEvery Dot/Bar should be connected to atleast one other Dot/Bar";
	    }
	    System.out.println(tabData.getOpenVertex());
	    if (!graph.checkConnection(tabData.getOpenVertex())) {
	    	return "Compile Failed : \nDisconnected circuit present";
	    }
	    return "Compiled Successfully";
	}
}
