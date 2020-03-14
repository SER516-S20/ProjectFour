package controller;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import view.RightPanel;
import model.AtSymbol;
import model.OpenParanthesis;
import model.CloseParanthesis;
import model.Data;
import model.LesserSymbol;
import model.GreaterSymbol;
import model.OrSymbol;
import model.MinusSymbol;

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
		        	Data.getInstance().setShapeNumber(shapeNumber);
		        }				
			}
		});
	}
	
	public void release(JPanel panel) {
		panel.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				JButton shape = new JButton();
				int shapeNumber = Data.getInstance().getShapeNumber();
				
				switch(shapeNumber) {
				case 1: if (!Data.getInstance().isOpenParaFlag()) {
							shape = new OpenParanthesis(e.getX(), e.getY(), true);
							Data.getInstance().setOpenParaFlag(true);
						}
						break;
				case 2: if ( !Data.getInstance().isCloseParaFlag()) {
							shape = new CloseParanthesis(e.getX(), e.getY(), true);
							Data.getInstance().setCloseParaFlag(true);
						}
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
				
				panel.add(shape);
				panel.repaint();
			}					
		});
	}
}
