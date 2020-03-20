package model;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @Author: Somesh, Dhananjay
 * @Since: 01-29-2020
 * @Description: This is the abstract class which all the buttons use to model.
 */
public class Shape extends JButton{
	protected String userInput;
	public enum type {INPUT, OUTPUT};
	protected int shapeIndex;
	protected ArrayList <Connector> connectors = new ArrayList<Connector>();

	public Shape(String label, int x, int y){
	    super(label);
	    this.userInput = "";
	    Dimension size = getPreferredSize();
	    size.width = size.height = Math.max(size.width,size.height);
	    setPreferredSize(size);
	    setBounds(x, y, (int)(size.width * 2.5), size.height);
	    setBorder(new EmptyBorder(x, y, 5, 5));
	    setLayout(null);
	}
	
	public String getUserInput() {
		return userInput;
	}
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	public int getShapeIndex() {
		return shapeIndex;
	}

	public void setShapeIndex(int shapeIndex) {
		this.shapeIndex = shapeIndex;
	}
	
	public ArrayList<Connector> getConnectors() {
		return connectors;
	}

	public void setConnectors(ArrayList<Connector> connectors) {
		this.connectors = connectors;
	}
}
