package controller;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Connector;
import model.ConnectorBar;
import model.ConnectorDot;
import model.Data;
import model.Line;
import model.Shape;
import view.RightPanel;

import model.Shape.type;


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
					
					if ((dot instanceof ConnectorDot && !dot.lineFlag) || dot instanceof ConnectorBar) {
						System.out.println("First Click");
						tabbedPanel.selected = !tabbedPanel.selected;
						tabbedPanel.tempStartDot = dot;
					}
					
				}else if(tabbedPanel.selected && (dot instanceof ConnectorDot && !dot.lineFlag) || dot instanceof ConnectorBar) {
					System.out.println("Second Click");
					if(tabbedPanel.tempStartDot.type != dot.type) {
						
						Shape startShape = (Shape)tabbedPanel.tempStartDot.getParent();
						Shape endShape = (Shape)dot.getParent();
						int startConnectorIndex = startShape.getConnectors().indexOf(tabbedPanel.tempStartDot);
						int endConnectorIndex = endShape.getConnectors().indexOf(dot);
						
						Data.getInstance().getTab(NewTab.selectedTab()).addLines(new Line(startShape, endShape, startConnectorIndex, endConnectorIndex, 
								tabbedPanel.tempStartDot.getX(),tabbedPanel.tempStartDot.getY(), dot.getX(), dot.getY()));
						
						
						if (dot.type == type.INPUT) {
							if (tabbedPanel.tempStartDot instanceof ConnectorDot) {
								((ConnectorDot) tabbedPanel.tempStartDot).setToConnector(dot);
							}else {
								ArrayList <Connector> toConnector =  ((ConnectorBar) tabbedPanel.tempStartDot).getToConnector();
								toConnector.add(dot);
								((ConnectorBar) tabbedPanel.tempStartDot).setToConnector(toConnector);
							}
							
						}else {
							
							if (dot instanceof ConnectorDot) {
								((ConnectorDot) dot).setToConnector(tabbedPanel.tempStartDot);
							}else {
								ArrayList <Connector> toConnector =  ((ConnectorBar) dot).getToConnector();
								toConnector.add(tabbedPanel.tempStartDot);
								((ConnectorBar) dot).setToConnector(toConnector);
							}
						}
						
						
						tabbedPanel.tempStartDot.lineFlag = true;
						dot.lineFlag = true;
						
					}
					tabbedPanel.selected = !tabbedPanel.selected;
					tabbedPanel.tempStartDot = null;
					tabbedPanel.repaint();
				}else {
					tabbedPanel.selected = false;
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
