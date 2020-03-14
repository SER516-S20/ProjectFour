package controller;

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

import view.RightPanel;

public class NewTab {
	static int CountOfTabs = 1;


public NewTab(JMenu NewTab, RightPanel rightPanel){
	JTabbedPane jTabbedPane = new javax.swing.JTabbedPane();
    rightPanel.setLayout(null);
    jTabbedPane.setBounds(0,0,1300,1000); 
		NewTab.addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent e) {   
	        	JPanel panel = new JPanel();
	        	panel.setLayout(null);
			    jTabbedPane.addTab("tab " + CountOfTabs , panel);
			    SelectShape selectShape = new SelectShape();
				selectShape.release(panel);
			    CountOfTabs++;
		        jTabbedPane.setSelectedIndex(jTabbedPane.getTabCount()-1);
			}
			});
        System.out.println("mom " + jTabbedPane.getTabCount());

	    rightPanel.add(jTabbedPane);
        int selectedIndex = jTabbedPane.getSelectedIndex();
        
        System.out.println("dad " + selectedIndex);
        
        
}
}