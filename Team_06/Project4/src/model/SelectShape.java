package model;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import view.RightPanel;

/**
 * @author Dananjay
 * @since 02-18-2020
 */
public class SelectShape {
	public void select(JButton shape, int shapeNumber) {
		
		shape.addActionListener(new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent e){
		        if (shape.isEnabled()){
		        	RightPanel.getInstance().shapeNumber = shapeNumber;
		        	System.out.println("def");
		        }				
			}
		});
	}
	
	public void release(RightPanel rightPanel) {
		rightPanel.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				JButton shape = new JButton();
				int shapeNumber = RightPanel.getInstance().shapeNumber;
				
				switch(shapeNumber) {
				case 1: shape = new OpenParanthesis(e.getX(), e.getY(), true);
				break;
				case 2: shape = new CloseParanthesis(e.getX(), e.getY(), true);
				break;
				case 3: shape = new LesserSymbol(e.getX(), e.getY(), true);
				break;
				case 4: shape = new GreaterSymbol(e.getX(), e.getY(), true);
				break;
				case 5: shape = new AtSymbol(e.getX(), e.getY(), true);
				break;
				case 6: shape = new OrSymbol(e.getX(), e.getY(), true);
				break;
				case 7: shape = new MinusSymbol(e.getX(), e.getY(), true);
				break;
				}
				
				rightPanel.add(shape);
				rightPanel.repaint();
			}					
		});
	}
}
