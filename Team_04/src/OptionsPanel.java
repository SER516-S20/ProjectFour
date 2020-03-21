import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * @author Nikitha
 * @Since 1-26-2020
 * @version 1.0
 */
public class OptionsPanel extends JPanel {
	public OptionsPanel() {
		Dimension size = new Dimension(-200, 600);
		setPreferredSize(size);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBorder(blackline);
		setLayout(new GridLayout(7, 1));
		for(int i=0; i<7; i++) {
	        try {
	          Class<?> ButtonClass = Class.forName("Button"+(i+1));
	          add((JButton) ButtonClass.getDeclaredConstructor().newInstance());
	        } catch (Exception e) {
	        	System.out.println(i+1);
	        }
		}
	}
}
