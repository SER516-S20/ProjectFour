import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Icon extends JPanel{

	private static final long serialVersionUID = 1L;

	Icon() {
	    JFrame f= new JFrame("Panel Example");    
	    JPanel panel=new JPanel();  
	    panel.setBounds(40,80,200,200);    
	    panel.setBackground(Color.gray); 
	    f.add(panel); 
	    f.setSize(400,400);    
	    f.setLayout(null);    
	    f.setVisible(true);    
    } 
	
}
