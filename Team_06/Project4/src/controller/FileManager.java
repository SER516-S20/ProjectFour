package controller;

import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.AtSymbol;
import model.CloseParanthesis;
import model.Connector;
import model.ConnectorBar;
import model.ConnectorDot;
import model.Data;
import model.GreaterSymbol;
import model.LesserSymbol;
import model.Line;
import model.MinusSymbol;
import model.OpenParanthesis;
import model.OrSymbol;
import model.Shape;
import model.TabData;
import model.Shape.type;
import view.RightPanel;
import model.ShapeData;

/**
 * 
 * @author Suyog
 * @Since 02-16-2020
 */
public class FileManager {
	
	StringBuilder sb = new StringBuilder();
	
	public FileManager(JMenuItem save,JMenuItem open){
		
		JLabel file = new JLabel("no file selected");
		
		save.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				JFileChooser fileChooser = new JFileChooser(); 
				
				// invoke the showsSaveDialog function to show the save dialog 
	            int r = fileChooser.showSaveDialog(null);
	            
	            // if the user selects a file 
	            if (r == JFileChooser.APPROVE_OPTION){ 
	                // set the label to the path of the selected file  
	                try(FileWriter fw = new FileWriter(fileChooser.getSelectedFile()+".txt")) {
	                	for(TabData tab : Data.getInstance().getTabList()){
	                		if(tab.getShapeData().size() == 0) fw.write(Data.getInstance().getTabList().indexOf(tab)+ System.lineSeparator());
	                		for(ShapeData shape : tab.getShapeData()) {
	                			fw.write(Data.getInstance().getTabList().indexOf(tab) +";"+ shape.getIndex() +";"+shape.getShapeNumber()+";"
	                					        + shape.getX() + ";" + shape.getY() + ";"+ shape.getUserIp() +";" + System.lineSeparator());
	                		}
	                    }
	                	fw.write("-----" + 	System.lineSeparator());
	                	for(TabData tab : Data.getInstance().getTabList()){
	                		for(Line l : tab.getLines()) {
	                			fw.write(Data.getInstance().getTabList().indexOf(tab) + ";" + l.startShape.getShapeIndex() + ";" +  l.startConnectorIndex + ";"+
                					l.x1 + ";" + l.y1 + ";" + l.endShape.getShapeIndex() + ";" + l.endConnectorIndex + ";"+ + l.x2 + ";" + l.y2 + ";"
                					+ System.lineSeparator());
	                		}
	                	}
	                	fw.close();
	                }
	                catch (IOException e1) {
	                	e1.printStackTrace();
					}
	            } 
	            // if the user cancelled the operation 
	            else
	                file.setText("the user cancelled the operation"); 
			}
		});
    
		open.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){ 
				
				JFileChooser fileChooser = new JFileChooser();  
				int r = fileChooser.showOpenDialog(null); 
				
				if (r == JFileChooser.APPROVE_OPTION) {  
                file.setText(fileChooser.getSelectedFile().getAbsolutePath()); 
				}  
				else
					file.setText("the user cancelled the operation"); 
				
				File fileContent = fileChooser.getSelectedFile();
		        
				
				BufferedReader reader;
				BufferedReader[] readerList;
				
				
				try {
					reader = new BufferedReader(new FileReader(fileContent));
		            String line = reader.readLine();
		            int temp = -1;
		            TabData tabData = new TabData();
		            JPanel panel = new JPanel();
		            
		            Data.getInstance().clearTabList();
					Tab.getInstance().jTabbedPane.removeAll();
					Tab.getInstance().CountOfTabs = 1;
					Tab.getInstance().tabNumber = 0;
					boolean isLine = false;
					
		            while(line != null) {
		            	
		            	System.out.println(line);
		            	if(line.equals("-----")) {
		            		isLine = true;
		            		line = reader.readLine();
		            		System.out.println(line);
		            	}
		            	
		            	if(!isLine) {
		            		String[] shapeInfo = line.split(";");
		            		Data data = Data.getInstance();
		            		
		            		if(shapeInfo.length == 1) {
		            			System.out.println(line);
		            			int tabNumber = Integer.parseInt(line);
		            			data.addTabData();
			            		tabData = data.getTab(tabNumber);
			            		panel = Tab.getInstance().createTab();
			            		temp = tabNumber;
			            		line = reader.readLine();
			            		continue;
		            		}

		            		int tabNumber = Integer.parseInt(shapeInfo[0]);
			            	int shapeIndex = Integer.parseInt(shapeInfo[1]);
			            	int shapeNumber = Integer.parseInt(shapeInfo[2]);
			            	int x = Integer.parseInt(shapeInfo[3]);
			            	int y = Integer.parseInt(shapeInfo[4]);
			            	String userIp = shapeInfo[5];
			            	
			            	Shape shape = new Shape("",0,0);
			            	
			            	if(temp < tabNumber) {
			            		data.addTabData();
			            		tabData = data.getTab(tabNumber);
			            		panel = Tab.getInstance().createTab();
			            		temp = tabNumber;
			            	}
			
		            		tabData.addShapeData(shapeNumber, shapeIndex, x, y);
		            		
		            		switch(shapeNumber) {
		            			case 1: shape = new OpenParanthesis(x, y, true);
		            					tabData.setOpenParaFlag(true);
		            					tabData.setOpenVertex(shapeIndex);
		            					break;
		            			case 2: shape = new CloseParanthesis(x, y, true);
		            					tabData.setCloseParaFlag(true);
		            					tabData.setCloseVertex(shapeIndex);
		            					break;
		            			case 3: shape = new LesserSymbol(x, y, true);
		            					break;
		            			case 4: shape = new GreaterSymbol(x, y, true);
		            					break;
		            			case 5: shape = new AtSymbol(x, y, true);
		            					break;
		            			case 6: shape = new OrSymbol(x, y, true);
		            					break;
		            			case 7: shape = new MinusSymbol(x, y, true);
		            					break;
		            		}
		            		shape.setShapeIndex(shapeIndex);
		            		if(userIp.equals("null")) {
		            			shape.setUserInput("");
		            		}
		            		else {
		            			shape.setUserInput(userIp);
		            		}
		            		tabData.setShapeCount();
		            		tabData.addShape(shape);
		            		tabData.addShapeInstance(shapeIndex, shape);
		            		panel.add(shape);
		            		panel.repaint();
		            		
		            	}
		            	else {
		            		if(line == null) continue;
		            		String[] lineInfo = line.split(";");
		            		int tabNumber = Integer.parseInt(lineInfo[0]);
		            		tabData = Data.getInstance().getTab(tabNumber);
		            		
		            		Shape startShape = tabData.getShapeInstance(Integer.parseInt(lineInfo[1]));
		            		int startConnectorIndex = Integer.parseInt(lineInfo[2]);
		            		Connector tempStartDot = startShape.getConnectors().get(startConnectorIndex);
		            		int x1 = Integer.parseInt(lineInfo[3]);
		            		int y1 = Integer.parseInt(lineInfo[4]);
		            		
		            		Shape endShape = Data.getInstance().getTab(tabNumber).getShapeInstance(Integer.parseInt(lineInfo[5]));
		            		int endConnectorIndex = Integer.parseInt(lineInfo[6]);
		            		Connector dot = endShape.getConnectors().get(endConnectorIndex);
		            		int x2 = Integer.parseInt(lineInfo[7]);
		            		int y2 = Integer.parseInt(lineInfo[8]);
		            		
		            		Data.getInstance().getTab(tabNumber).addLines(new Line(startShape,endShape,startConnectorIndex, endConnectorIndex, x1,y1,x2,y2));
		            		
		            		
		            		if (dot.type == type.INPUT) {
								if (tempStartDot instanceof ConnectorDot) {
									((ConnectorDot) tempStartDot).setToConnector(dot);
								}else {
									ArrayList <Connector> toConnector =  ((ConnectorBar) tempStartDot).getToConnector();
									toConnector.add(dot);
									((ConnectorBar) tempStartDot).setToConnector(toConnector);
								}
								
							}else {
								
								if (dot instanceof ConnectorDot) {
									((ConnectorDot) dot).setToConnector(tempStartDot);
								}else {
									ArrayList <Connector> toConnector =  ((ConnectorBar) dot).getToConnector();
									toConnector.add(tempStartDot);
									((ConnectorBar) dot).setToConnector(toConnector);
								}
							}
							
							
							tempStartDot.lineFlag = true;
							dot.lineFlag = true;
		            		
		            		
		            	}
		            	panel.repaint();
		            	line = reader.readLine();
		            	
		            }
		        } 
		        catch (IOException e1 ) {
		            e1.printStackTrace();
		        }
		    }
		});
		
		
		 
	}
}
