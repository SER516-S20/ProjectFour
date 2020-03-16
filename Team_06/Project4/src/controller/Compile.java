package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenu;

import com.sun.java.swing.plaf.windows.resources.windows;
import static javax.swing.JOptionPane.showMessageDialog;

import model.Connector;
import model.Data;
import model.Shape;
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
	    	return "OpenParaShape Missing";
	    }
	    if(!tabData.isCloseParaFlag()) {
	    	return "CloseParaShape Missing";
	    }
	    
	    ArrayList<Shape> shapes = tabData.getShapes();
	    boolean allConnected = true; 
	    System.out.println("# of Shapes" + shapes.size());
	    for (Shape shape : shapes) {	    	
	    	for (Connector connector : shape.getConnectors()) {
	    		if (!connector.lineFlag) {
	    			allConnected = false;
	    			break;
	    		}
	    	}
	    	if (!allConnected) {
	    		break;
	    	}
	    }
	    if(!allConnected) {
	    	return "Every Dot/Bar should be connected to atleast one other Dot/Bar";
	    }
	    return "Compiled Successfully";
	}
}
