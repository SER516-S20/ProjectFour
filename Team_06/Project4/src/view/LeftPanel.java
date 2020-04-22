package view;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.SelectShape;
/**
 * 
 * @author Suyog, Rahul, Sheran
 * @since 03-07-2020
 * @Description: Left Panel will have different shapes that are available to draw in right panel tabs.
 */
public class LeftPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private String[] shapeNames = {
		      "OpenParentheses", "CloseParentheses", 
		      "LesserSymbol", "GreaterSymbol",
		      "AtSymbol", "OrSymbol",
		      "MinusSymbol","HashSymbol"
		  };
	 
	 private JButton[] shapes = new JButton[8];
	 SelectShape ss = new SelectShape();
	 
	 LeftPanel(){		
		this.setBackground(Color.decode("#ffffff"));
		this.setLayout(new GridLayout(8, 1, 5, 5));
		
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
