/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * @author Kunal Sharma
 * @created on 01-27-2020
 * @version 1.0
 * @author Kunal Sharma
 * @created on 02-19-2020
 * @version 2.0
 */
public class MainWindow  {
	static JPanel drawingBoardPanel = new JPanel();
	static JFrame frame;
	static JPanel p1;
        public static void CloseApplication()
        {
            try{
              //  frame.setVisible(false);
			//frame.dispose();
			System.exit(0);
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
	public static void main(String[] args) {

		Menu objMenu = new Menu();
		Shapes shapes = new Shapes();
		 frame = new JFrame("Main Window");
		frame.setVisible(true);
		frame.setSize(1000, 1000);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CreateJTabbedPaneExample obj = new CreateJTabbedPaneExample();
		drawingBoardPanel.setSize(500, 500);
		//frame.add(drawingBoardPanel);
		
		  JPanel panel = new JPanel();
		  panel.add(objMenu.CreateMenu());
		 // panel.setSize(100, 100);
		  panel.setBounds(0, 0, 500, 50);
		  JPanel panelToolKit = new JPanel();
		 // panelToolKit.setLocation(0, 100);
		 // panelToolKit.setSize(100,100);
		  panelToolKit.setBounds(0,50,1350,100);
		  panelToolKit.setBackground(Color.red);
		  panelToolKit.add(shapes.CreateShapes());
		  frame.add(panel);
		  frame.add(panelToolKit);
		  obj.createAndShowGUI();
	// frame.add(drawingBoardPanel);
	 
		  
		  
		/*
		 * JSplitPane splitPane2 = new JSplitPane(); splitPane2.setSize(900, 900);
		 * splitPane2.setDividerSize(0); splitPane2.setDividerLocation(200);
		 * splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT); drawingBoardPanel = new
		 * DrawBoardPanel(); splitPane2.setTopComponent(new PanelToolkit());
		 * splitPane2.setBottomComponent(drawingBoardPanel); JSplitPane splitPane1 = new
		 * JSplitPane(JSplitPane.VERTICAL_SPLIT, panel, splitPane2);
		 * frame.add(splitPane1);
		 */
	
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		  

	}
}
