import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author Sarvansh
 * @created on 03-18-2020
 * @version 1.0
 * @author Rohit
 * @modified on 03-18-2020
 * @version 2.0
 */
public class Shapes implements ActionListener{
	
	private JButton openParanthesis = new JButton();
	private JButton closedParanthesis = new JButton();
	private JButton lessThanOperator = new JButton();
	private JButton greaterThanOperator = new JButton();
	private JButton atTheRateOperator = new JButton();
	private JButton barOperator = new JButton();	
	private JButton dashOperator = new JButton();
	
	private java.util.List<JButton> buttons = new ArrayList<JButton>();
	
	String[] images = new String[] {"images/shape1.png","images/shape2.png",
									"images/shape3.png","images/shape4.png",
									"images/shape5.png","images/shape6.png",
									"images/shape7.png"};
	private Panel panel;
	
	public Panel CreateShapes() {
		
		panel = new Panel();
		setUpButtons();
		addButtons();
		panel.setSize(400, 100);
		return panel;

	}
	
	
	private void setUpButtons() {
		buttons.add(openParanthesis);
		buttons.add(closedParanthesis);
		buttons.add(lessThanOperator);
		buttons.add(greaterThanOperator);
		buttons.add(atTheRateOperator);
		buttons.add(barOperator);
		buttons.add(dashOperator);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == openParanthesis) {
			System.out.println("This is button 1");
		} else if (e.getSource() == closedParanthesis) {
			
 
		} else if (e.getSource() == lessThanOperator) {

		} else if (e.getSource() == greaterThanOperator) {
	
		}
		else if (e.getSource() == atTheRateOperator) {

		}
		else if (e.getSource() == barOperator) {

		}
		else if (e.getSource() == dashOperator) {

		}
		
	}
	
	
}
