package controller;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import view.RightPanel;
public class Load {
	public void loadShapes(File fileContent, RightPanel rightPanel) {
//		
//		BufferedReader reader;
//		JButton shape = new JButton();
//		
//		rightPanel.removeAll();
//		
//		rightPanel.circlePoints.clear();
//		rightPanel.trianglePoints.clear();
//		rightPanel.squarePoints.clear();
//		
//		try {
//			reader = new BufferedReader(new FileReader(fileContent));
//            String line = reader.readLine();
//            
//            while(line != null) {
//   	
//            	String[] shapeInfo = line.split(";");
//            	String shapeName = shapeInfo[0];
//            	int x = Integer.parseInt(shapeInfo[1]);
//            	int y = Integer.parseInt(shapeInfo[2]);
//            	
//            	if(shapeName.equals("Circle")){
//            		rightPanel.circlePoints.add(new Point( x, y));
//            		shape = new Circle("", x, y, true);
//            		rightPanel.add(shape);
//            	}
//            	else if(shapeName.equals("Triangle")) {
//            		rightPanel.trianglePoints.add(new Point( x, y));
//            		shape = new Triangle("", x, y, true);
//            		rightPanel.add(shape);
//            	}
//            	else if(shapeName.equals("Square")) {
//            		rightPanel.squarePoints.add(new Point( x, y));
//            		shape = new Square("", x, y, true);	
//            		rightPanel.add(shape);
//            	}
//            	else {
//            		//Do not do anything
//            	}      
//            	line = reader.readLine();
//            }  
//            rightPanel.repaint();
//        } 
//        catch (FileNotFoundException e1) {
//            e1.printStackTrace();
//        }
//        catch (IOException e1) {
//            e1.printStackTrace();
//        }
//		
//	
	}
}
