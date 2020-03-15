package view;
import java.awt.Color;
import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.SelectShape;
/**
 * 
 * @author Somesh
 *@since 01-29-2020
 */
public class LeftPanel extends JPanel{
	
	 private String[] shapeNames = {
		      "OpenParanthesis", "CloseParanthesis", 
		      "LesserSymbol", "GreaterSymbol",
		      "AtSymbol", "OrSymbol",
		      "MinusSymbol"
		  };
	 
	 private JButton[] shapes = new JButton[7];
	 SelectShape ss = new SelectShape();
	 
	 LeftPanel(){
		
		this.setBackground(Color.decode("#ffffff"));
		this.setLayout(new GridLayout(7, 1, 5, 5));
		
		for(int i = 0; i < shapeNames.length; i++) {
			try {
				Class<?> shapeClass = Class.forName("model." + shapeNames[i]);
				JButton shape = (JButton) shapeClass.getDeclaredConstructor(int.class, int.class, boolean.class).
						newInstance(0, 0, false);
		        shapes[i] = shape;
		        add(shape);
				ss.select(shape, i + 1);
			} catch (Exception e) {
				System.out.println(e.toString());
				addError(shapeNames[i]);
			}
		}
		
	}
	
	private void addError(String shapeName) {
	    JButton shape = new JButton();
	    JLabel label = new JLabel(shapeName + " : Error");
	    shape.add(label);
	    add(shape);
	}
}
