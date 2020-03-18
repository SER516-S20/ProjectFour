
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashwin Srinivasan
 * @since 03/18/2020
 * @version 1.0
 */
public class Frame extends JFrame implements ChangeListener{

	static Map<Integer, DrawingArea> mapDrawingAreas = new HashMap<>();
	static int currentTab = 0;
	static int count =0;

	Frame() {
		int frameHeight = 700;
		int frameWidth = 900;
		this.setTitle("Project Two - Team 3");
		this.setBackground(Color.LIGHT_GRAY);
		this.setSize(new Dimension(frameWidth, frameHeight));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		JButton okButton = new JButton("OK");
        JTabbedPane tabbedPane = new JTabbedPane();
        okButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	   DrawingArea obj = new DrawingArea();
        	   count = count + 1;
        	   String temp = "Tab"+count;
               tabbedPane.addTab(temp, obj);
               mapDrawingAreas.put(count, obj);
           }
        });
        tabbedPane.addChangeListener(this);
		DrawingArea drawingArea = new DrawingArea();
		this.getContentPane().add(drawingArea);
		
		this.getContentPane().add(new ShapePanel(), BorderLayout.WEST);
		this.add(okButton,BorderLayout.NORTH);
		this.getContentPane().add(new ShapePanel(), BorderLayout.WEST);
        this.add(tabbedPane, BorderLayout.CENTER);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
		currentTab = tabbedPane.getSelectedIndex();
        System.out.println("Tab "+currentTab+" is Clicked");
	}

}