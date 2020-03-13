package model;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Shape extends JButton{
	protected String userInput;
	protected enum type {INPUT, OUTPUT};
	Shape(String label, int x, int y){
		super(label);
		this.userInput = "";
	    Dimension size = getPreferredSize();
	    size.width = size.height = Math.max(size.width,size.height);
	    setPreferredSize(size);
	    //setBounds(x, y, size.width, size.height);
	    setBounds(x, y, (int)(size.width * 2.5), size.height);
	    setBorder(new EmptyBorder(x, y, 5, 5));
	}
	
	public String getUserInput() {
		return userInput;
	}
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}
	
}
