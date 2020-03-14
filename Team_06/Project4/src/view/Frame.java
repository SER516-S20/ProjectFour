package view;
import javax.swing.*;
import java.awt.*;
import controller.NewTab;

/**
 * @author Somesh
 * @since 02-19-2020
 */
public class Frame extends JFrame {
	LeftPanel leftPanel;
	RightPanel rightPanel;

	Frame(){
		
		this.setTitle("Project");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setMinimumSize(screenSize);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    getContentPane().add(addPanels());
	    
	    JMenuBar menu = new Menu(rightPanel);
	    JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        
        this.setJMenuBar(menuBar);
        this.setResizable(false);
		this.pack();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}
    
	//This method splits the frame into two panels.
	public JSplitPane addPanels(){
	    leftPanel = new LeftPanel();
	    rightPanel = new RightPanel();
	    
	    try{
	        JSplitPane splitPane = new JSplitPane();
	        splitPane.setSize(getSize().width, getSize().height);
	        splitPane.setDividerSize(0);
	        splitPane.setDividerLocation(getSize().width/6);
	        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
	        splitPane.setLeftComponent(leftPanel);
	        splitPane.setRightComponent(rightPanel);
		    return splitPane;
		}
	    catch (Exception e){
	    	e.printStackTrace();
	    }
	    return null;
	}
	
	public static void main(String[] args){
		new Frame();
	}
}
