package model;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import model.Shape.type;

/**
 * 
 * @Author: Somesh
 * @Since: 01-29-2020
 * @Description: This abstract class is used to define connections(lines).
 */
public class Connector extends JButton{
	public type type;
	public boolean lineFlag;
	
	Connector(type t){
		this.type = t;
		this.lineFlag = false;
	}

}
