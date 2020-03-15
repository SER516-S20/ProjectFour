package model;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import model.Shape.type;

public class Connector extends JButton{
	public type type;
	public boolean line;
	
	Connector(type t){
		this.type = t;
		this.line = false;
	}

}
