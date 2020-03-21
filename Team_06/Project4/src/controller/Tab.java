package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Data;
import view.RightPanel;

/**
 * 
 * @author Dhananjay
 * @since 03-09-2020
 * @Description: This controller class is used add new tab in right panel whenever new space button is clicked.
 */
public class Tab {
	private static Tab TabObj = null;
	static int CountOfTabs = 1;
	public int tabNumber = 0;
	boolean DefaultStartTab = true;
	public static JTabbedPane jTabbedPane = new javax.swing.JTabbedPane();
    SelectShape selectShape = new SelectShape();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private Tab() {
	}
	
	public static Tab getInstance() {
		if (TabObj == null) {
			TabObj = new Tab();
		}
		return TabObj;
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
