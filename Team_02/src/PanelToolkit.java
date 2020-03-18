/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * @author Rohit
 * @created on 02-16-2020
 * @version 1.0
 */
public class PanelToolkit extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelToolkit() {

		String[] classNames = new String[] { "Circle", "Rectangle", "Square", "Triangle" };
		for (int i = 0; i < classNames.length; i++) {
			try {
				Class<?> tabClass = Class.forName("Panel" + classNames[i]);
				setLayout(new GridLayout(1, 4));
				Object newTab = tabClass.getDeclaredConstructor().newInstance();
				JPanel toolkit_panel = (JPanel) newTab;
				toolkit_panel.setBorder(BorderFactory.createLineBorder(Color.black));
				add(toolkit_panel);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
	}
}

