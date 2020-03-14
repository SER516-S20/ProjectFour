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
import view.RightPanel;
/**
 * 
 * @author Suyog
 * @Since 02-16-2020
 */
public class FileManager {
	
	StringBuilder sb = new StringBuilder();
	
	public FileManager(JMenuItem save,JMenuItem open, RightPanel rightPanel){
		
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
	                	for(Point point: rightPanel.circlePoints){
		      			    fw.write("Circle;" + point.x + ";" + point.y + ";" +System.lineSeparator());
	                    }
	                	for(Point point: rightPanel.trianglePoints){
		      			    fw.write("Triangle;" + point.x + ";" + point.y + ";" + System.lineSeparator());
	                    }
	                	for(Point point: rightPanel.squarePoints){
		      			    fw.write("Square;" + point.x +";" + point.y + ";" + System.lineSeparator());
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
		        
		        Load load = new Load();
		        load.loadShapes(fileContent, rightPanel);   
		    }
		});
		
		
		 
	}
}
