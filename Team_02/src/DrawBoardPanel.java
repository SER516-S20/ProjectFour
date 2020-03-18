/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author Rohit
 * @created 02-18-2020
 * @version 1.0
 */
public class DrawBoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public DrawBoardPanel() {

		try {
			add(new DrawShapeOnMouseClick());
			setVisible(true);
			Border blackline = BorderFactory.createLineBorder(Color.black);
			setBorder(blackline);
			setSize(400, 400);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
