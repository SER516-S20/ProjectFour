import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 * @author Nikitha,Ashwath,Tarun Snehith Kishore Reddy Karna,
 * @Since 03-10-2020
 * @version 1.0
 */


public class Frame extends JFrame {
	private static final String FRAME_TITLE = "Team4";
	JFrame frame = new JFrame("Swing Tester");
	private JTabbedPane tabbedPane;
	private OptionsPanel options;
	private ArrayList<DrawingCanvas> canvasArray = new ArrayList<DrawingCanvas>();

	public Frame() {
		this.setTitle(FRAME_TITLE);
		this.setMinimumSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = this.getContentPane();
		content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
		options = new OptionsPanel();
		content.add(options);
		tabbedPane = new JTabbedPane();
		content.add(tabbedPane);
		DrawingCanvas c = new DrawingCanvas(); 
		tabbedPane.add("Tab1",c);
		canvasArray.add(c);
		addMenu(tabbedPane);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void addMenu(JTabbedPane tabbedPane) {
		JMenuBar menubar = new JMenuBar();
		menubar.setMinimumSize(new Dimension(60, 40));
		final JLabel label = new JLabel();
		this.setJMenuBar(menubar);
		JMenu menu = new JMenu("Menu");
		menubar.add(menu);
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem compile = new JMenuItem("Compile");
		JMenuItem newspace = new JMenuItem("NewSpace");
		load.addActionListener(new LoadManager(this));
		save.addActionListener(new SaveManager(this));
		compile.addActionListener(new Compile(this));
		newspace.addActionListener(new NewSpace(this));
		menu.add(save);
		menu.add(load);
		menu.add(compile);
		menu.add(newspace);
	}
	
	public JTabbedPane getTabbedPane()
	{
		return tabbedPane;
	}
	
	public void setTabbedPane(JTabbedPane pane)
	{
		tabbedPane = pane;
	}
	
	public ArrayList<DrawingCanvas> getCanvasArray()
	{
		return canvasArray;
	}
	
	public void setCanvasArray(ArrayList<DrawingCanvas> array)
	{
		canvasArray = array;
	}
	
	public static void main(String[] args) {
		new Frame();
	}
}
