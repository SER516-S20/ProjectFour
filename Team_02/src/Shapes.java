import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JButton openParanthesis = new JButton();
	JButton closedParanthesis = new JButton();
	JButton lessThanOperator = new JButton();
	JButton greaterThanOperator = new JButton();
	JButton atTheRateOperator = new JButton();
	JButton barOperator = new JButton();	
	JButton dashOperator = new JButton();
	
	public Panel CreateShapes() {
		Panel pan = new Panel();
		
		openParanthesis.addActionListener(this);
		openParanthesis.setPreferredSize(new Dimension(180,70));
		openParanthesis.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("images/shape1.png")).
				getImage().getScaledInstance
				(190, 70, Image.SCALE_SMOOTH)));
		pan.add(openParanthesis);
		
		
		closedParanthesis.addActionListener(this);
		closedParanthesis.setPreferredSize(new Dimension(180,70));
		closedParanthesis.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("images/shape2.png")).
				getImage().getScaledInstance
				(190, 70, Image.SCALE_SMOOTH)));
		pan.add(closedParanthesis);
		
		lessThanOperator.addActionListener(this);
		lessThanOperator.setPreferredSize(new Dimension(180,70));
		lessThanOperator.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("images/shape3.png")).
				getImage().getScaledInstance
				(190, 70, Image.SCALE_SMOOTH)));
		pan.add(lessThanOperator);
		
		greaterThanOperator.addActionListener(this);
		greaterThanOperator.setPreferredSize(new Dimension(180,70));
		greaterThanOperator.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("images/shape4.png")).
				getImage().getScaledInstance
				(190, 70, Image.SCALE_SMOOTH)));
		pan.add(greaterThanOperator);
		
		atTheRateOperator.addActionListener(this);
		atTheRateOperator.setPreferredSize(new Dimension(180,70));
		atTheRateOperator.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("images/shape5.png")).
				getImage().getScaledInstance
				(190, 70, Image.SCALE_SMOOTH)));
		pan.add(atTheRateOperator);
		
		barOperator.addActionListener(this);
		barOperator.setPreferredSize(new Dimension(180,70));
		barOperator.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("images/shape6.png")).
				getImage().getScaledInstance
				(190, 70, Image.SCALE_SMOOTH)));
		pan.add(barOperator);
		
		dashOperator.addActionListener(this);
		dashOperator.setPreferredSize(new Dimension(180,70));
		dashOperator.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("images/shape7.png")).
				getImage().getScaledInstance
				(190, 70, Image.SCALE_SMOOTH)));
		pan.add(dashOperator);
		
		pan.setSize(400, 100);
		return pan;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == openParanthesis) {
	
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
