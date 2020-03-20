import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Icon extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public int centerX;
	public int centerY;
	public int height=60;
	public int width=200;
	public int dotSize = 6;
	public int dotMargin = 10;

	Icon() {
//	    JFrame f= new JFrame("Panel Example");    
//	    JPanel panel=new JPanel();  
//	    panel.setBounds(40,80,200,200);    
//	    panel.setBackground(Color.gray); 
//	    f.add(panel); 
//	    f.setSize(400,400);    
//	    f.setLayout(null);    
//	    f.setVisible(true);    
    } 
	
	
	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}
	
	
	public void setUpPoints() {
		
	}
	
}
