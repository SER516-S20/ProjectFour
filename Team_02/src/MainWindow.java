import java.awt.Color;
import javax.swing.*;

/**
 * @author Kunal Sharma
 * @created on 01-27-2020
 * @version 1.0
 * @author Kunal Sharma
 * @created on 02-19-2020
 * @version 2.0
 */
public class MainWindow  {
	static JPanel drawingBoardPanel = new JPanel();
	static JFrame frame;
	static JPanel p1;
	static NewTab obj;
	public static void CloseApplication()
	{
		try{
			//  frame.setVisible(false);
			//	frame.dispose();
			System.exit(0);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	public static void main(String[] args) {
		Menu objMenu = new Menu();
		Shapes shapes = new Shapes();
		frame = new JFrame("Main Window");
		frame.setVisible(true);
		frame.setSize(1000, 1000);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// obj = new CreateJTabbedPaneExample();
		//frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
		JPanel panel = new JPanel();
		panel.add(objMenu.CreateMenu());
		panel.setSize(100, 100);
		panel.setBounds(0, 0, 500, 50);
		JPanel panelToolKit = new JPanel();
		// panelToolKit.setLocation(0, 100);
		// panelToolKit.setSize(100,100);
		panelToolKit.setBounds(0,50,1350,100);
		panelToolKit.setBackground(Color.red);
		panelToolKit.add(shapes.CreateShapes());
		frame.getContentPane().add(panel);
		frame.getContentPane().add(panelToolKit);
		// obj = new JTabbedPane();
		// obj.setBounds(0,150,1000,400); 
		//frame.getContentPane().add(obj);
		//  obj.add(new DrawBoardPanel());
		obj = new NewTab();
		obj.createAndShowGUI();
		//obj.tabbedPane.getComponentAt(0).repaint();
		//JTabbedPane tab = (JTabbedPane) MainWindow.frame.getContentPane().getComponent(2);
		//JPanel p = (JPanel) tab.getComponentAt(0);
		//p.repaint();
		// frame.add(drawingBoardPanel);
		/*
		 * JSplitPane splitPane2 = new JSplitPane(); splitPane2.setSize(900, 900);
		 * splitPane2.setDividerSize(0); splitPane2.setDividerLocation(200);
		 * splitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT); drawingBoardPanel = new
		 * DrawBoardPanel(); splitPane2.setTopComponent(new PanelToolkit());
		 * splitPane2.setBottomComponent(drawingBoardPanel); JSplitPane splitPane1 = new
		 * JSplitPane(JSplitPane.VERTICAL_SPLIT, panel, splitPane2);
		 * frame.add(splitPane1);
		 */
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
