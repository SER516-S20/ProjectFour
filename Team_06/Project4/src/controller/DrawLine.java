package controller;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Connector;
import model.ConnectorBar;
import model.ConnectorDot;
import model.Data;
import model.Line;
import model.Shape;
import view.RightPanel;


/** 
 * @author somesh
 * @since 02-28-2020
 */

public class DrawLine{
	int mouseX = 0;
	int mouseY = 0;
	
	
	static boolean selected = false;
	
	public DrawLine(Connector dot){
		dot.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e){

				System.out.println("Dot Clicked");
				//JPanel tabbedPanel = (JPanel) e.getComponent().getParent().getParent();
				RightPanel tabbedPanel = (RightPanel) e.getComponent().getParent().getParent();
				
				
				if (!tabbedPanel.selected) {
					
					if ((dot instanceof ConnectorDot && !dot.line) || dot instanceof ConnectorBar) {
						System.out.println("First Click");
						tabbedPanel.selected = !tabbedPanel.selected;
						tabbedPanel.tempStartDot = dot;
					}
					
				}else if(tabbedPanel.selected && (dot instanceof ConnectorDot && !dot.line) || dot instanceof ConnectorBar) {
					System.out.println("Second Click");
					if(tabbedPanel.tempStartDot.type != dot.type) {
						Data.getInstance().getTab(NewTab.selectedTab()).addLines(new Line((Shape)tabbedPanel.tempStartDot.getParent(), (Shape)dot.getParent(), tabbedPanel.tempStartDot.getX(),tabbedPanel.tempStartDot.getY(), dot.getX(), dot.getY()));
						
						tabbedPanel.tempStartDot.line = true;
						dot.line = true;
						
					}
					tabbedPanel.selected = !tabbedPanel.selected;
					tabbedPanel.tempStartDot = null;
					tabbedPanel.repaint();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {	
			}

			@Override
			public void mouseReleased(MouseEvent e){
			}

			@Override
			public void mouseEntered(MouseEvent e){
			}

			@Override
			public void mouseExited(MouseEvent e){
			}

		});
	}
	
	
}
