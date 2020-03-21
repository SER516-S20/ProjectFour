package model;
import javax.swing.JButton;
import model.Shape.type;

/**
 * 
 * @Author: Somesh
 * @Since: 03-07-2020
 * @Description: This abstract class is used to define connections(lines).
 */
public class Connector extends JButton{
	
	private static final long serialVersionUID = 1L;
	public type type;
	public boolean lineFlag;
	
	Connector(type t){
		this.type = t;
		this.lineFlag = false;
	}

}
