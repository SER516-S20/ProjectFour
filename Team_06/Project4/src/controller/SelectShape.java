package controller;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.AtSymbol;
import model.OpenParanthesis;
import model.CloseParanthesis;
import model.Data;
import model.LesserSymbol;
import model.GreaterSymbol;
import model.OrSymbol;
import model.Shape;
import model.TabData;
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
		        	int tabNumber = NewTab.selectedTab();
		        	TabData tabData = Data.getInstance().getTab(tabNumber);
		        	tabData.setShapeNumber(shapeNumber);
		        	Data.getInstance().setTab(tabNumber, tabData);
		        }				
			}
		});
	}
	
	public void release(JPanel panel, int tabNumber) {
		panel.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				Shape shape = new Shape("",0,0);
				int shapeNumber = Data.getInstance().getTab(tabNumber).getShapeNumber();
				
				switch(shapeNumber) {
					case 1: if (!Data.getInstance().getTab(tabNumber).isOpenParaFlag()) {
								shape = new OpenParanthesis(e.getX(), e.getY(), true);
								TabData tabData = Data.getInstance().getTab(tabNumber);
								tabData.setOpenParaFlag(true);
								tabData.setOpenVertex(tabData.getShapeCount() + 1);
								Data.getInstance().setTab(tabNumber, tabData);
							}
							break;
					case 2: if ( !Data.getInstance().getTab(tabNumber).isCloseParaFlag()) {
								shape = new CloseParanthesis(e.getX(), e.getY(), true);
								TabData tabData = Data.getInstance().getTab(tabNumber);
								tabData.setCloseParaFlag(true);
								tabData.setCloseVertex(tabData.getShapeCount() + 1);
								Data.getInstance().setTab(tabNumber, tabData);
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
				TabData tabData = Data.getInstance().getTab(tabNumber);
				tabData.setShapeCount();
				int shapeCount = Data.getInstance().getTab(tabNumber).getShapeCount();
				Data.getInstance().getTab(tabNumber).addShapeData(shapeNumber, shapeCount, e.getX(), e.getY());
				shape.setShapeIndex(shapeCount);
				
				tabData.addShape(shape);
				Data.getInstance().setTab(tabNumber, tabData);
				panel.add(shape);
				
				panel.repaint();
			}					
		});
	}
}