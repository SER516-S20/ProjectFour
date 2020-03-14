package controller;
import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

import view.RightPanel;

/**
 * 
 * @author Dananjay
 * @since 02-28-2020
 */

public class Drag{
	
	int screenX = 0; 
	int screenY = 0;
	
	int mouseX = 0;
	int mouseY = 0;
	
	public Drag(JButton shape){
		shape.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e){
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				screenX = e.getXOnScreen();
				screenY = e.getYOnScreen();
				mouseX = shape.getX();
				mouseY = shape.getY();
				System.out.println(mouseX + " YTU " + mouseY);
			}

			@Override
			public void mouseReleased(MouseEvent e){
//				System.out.println("Released");
//				RightPanel rightPanel = (RightPanel) e.getComponent().getParent();
//				for (Line l : rightPanel.lines) {
//		        	System.out.println(l.startDot.getX()+" RL "+ l.startDot.getY());
//		        	System.out.println(l.endDot.getX() +" "+ l.endDot.getY());
//					
//					
//				}
			}

			@Override
			public void mouseEntered(MouseEvent e){
			}

			@Override
			public void mouseExited(MouseEvent e){
			}

		});
		
		shape.addMouseMotionListener(new MouseMotionListener(){
			@Override
			public void mouseDragged(MouseEvent e) {
				int deltaX = e.getXOnScreen() - screenX;
				int deltaY = e.getYOnScreen() - screenY;
				
				shape.setLocation(mouseX + deltaX, mouseY + deltaY);
				
				
				
			}
			

			@Override
			public void mouseMoved(MouseEvent e){
				
			}
		});
	}
}
