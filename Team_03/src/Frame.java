import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chandan Yadav
 * @since 01/26/2020
 * @version 1.0
 */
public class Frame extends JFrame implements ChangeListener {

	static Map<Integer, DrawingArea> mapDrawingAreas = new HashMap<>();
	JTabbedPane tabbedPane = new JTabbedPane();
	static int currentTab = 0;
	static int count = 0;
	static JLabel jlabel = new JLabel();
	Compile compile = new Compile();

	Frame() {
		int frameHeight = 700;
		int frameWidth = 900;
		this.setTitle("Project Two - Team 3");
		this.setBackground(Color.LIGHT_GRAY);
		this.setSize(new Dimension(frameWidth, frameHeight));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		jlabel.setText("Welcome");
		this.getContentPane().add(jlabel, BorderLayout.SOUTH);
		JButton okButton = new JButton(Constants.NEW_SPACE);
		okButton.addActionListener(e -> {
			DrawingArea obj = new DrawingArea();
			String temp = Constants.TAB + count;
			tabbedPane.addTab(temp, obj);
			mapDrawingAreas.put(count, obj);
			count = count + 1;
		});
		tabbedPane.addChangeListener(this);
		DrawingArea drawingArea = new DrawingArea();
		this.getContentPane().add(drawingArea);
		this.getContentPane().add(new ShapePanel(), BorderLayout.WEST);
		JButton openButton = new JButton(Constants.LOAD);
		DrawingArea obj1 = new DrawingArea();
		// Open saved state
		openButton.addActionListener(event -> {
			obj1.load(tabbedPane);
			obj1.repaintOnDrag();
		});
		this.add(tabbedPane, BorderLayout.CENTER);
		JButton saveButton = new JButton(Constants.SAVE);
		DrawingArea obj2 = new DrawingArea();
		saveButton.addActionListener(event -> {
			// Save current state
			obj2.save();
		});
		JPanel menuPanel = new JPanel();
		JButton compileButton = new JButton(Constants.COMPILE);
		compileButton.addActionListener(event -> {
			// Save current state
			compile.validate();
		});
		menuPanel.add(openButton);
		menuPanel.add(saveButton);
		menuPanel.add(okButton);
		menuPanel.add(compileButton);
		this.getContentPane().add(menuPanel, BorderLayout.NORTH);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
		currentTab = tabbedPane.getSelectedIndex();
	}

}
