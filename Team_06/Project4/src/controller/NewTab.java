package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeListener;

import model.Data;
import view.RightPanel;

public class NewTab {
	private static NewTab newTabObj = null;
	static int CountOfTabs = 1;
	public int tabNumber = 0;
	boolean DefaultStartTab = true;
	public static JTabbedPane jTabbedPane = new javax.swing.JTabbedPane();
    SelectShape selectShape = new SelectShape();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


	private NewTab() {
		
	}
	public static NewTab getInstance() {
		if (newTabObj == null) {
			newTabObj = new NewTab();
		}
		return newTabObj;
	}
	public void initialize(JMenu NewTab, RightPanel rightPanel) {
		rightPanel.setLayout(null);
	    jTabbedPane.setBounds(0,0,screenSize.width*5/6,screenSize.height); 


	    if(DefaultStartTab) {
	    	createTab();
		    DefaultStartTab = false;
	    }
	    
	    
			NewTab.addMouseListener(new MouseAdapter() { 
		          public void mousePressed(MouseEvent e) {
		        	 createTab();
		          	}
				});

		    rightPanel.add(jTabbedPane);
	
	}
	
	public JPanel createTab() {
		Data.getInstance().addTabData();
    	RightPanel panel = new RightPanel();
	    jTabbedPane.addTab("tab " + CountOfTabs , panel);
    	panel.setLayout(null);
		selectShape.release(panel, tabNumber);
		tabNumber = CountOfTabs;
	    CountOfTabs++;
        jTabbedPane.setSelectedIndex(jTabbedPane.getTabCount()-1);
        return panel;
	}
	
	public static int selectedTab() {
		return jTabbedPane.getSelectedIndex();
	}  

}
