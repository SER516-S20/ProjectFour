import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JFrame;

public class Model {
	private static List<Connection> connections = new ArrayList<Connection>();
	private static RightTabbedPane rightTabbedPane;
	private static Hashtable<String, TabInfo> tabs;
	//private static Hashtable<String, Hashtable<Integer, ButtonBox>> shapes
	private static Hashtable<Integer, ButtonBox> shapes;
	private static Frame frame;
	private static String dialogMessage;
	
	
	public Model() {
		//shapes = new Hashtable<Integer, ButtonBox>();
	}
	
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	public Frame getFrame() {
		return frame;
	}
	
	public void setshapes( Hashtable<Integer, ButtonBox> inshapes) {
		this.shapes = inshapes;
	}
	
	public Hashtable<Integer, ButtonBox> getshapes() {
		return shapes;
	}
	
	public static void setMessage(String message) {
		dialogMessage = message;
	}
	
	public static String getMessage() {
		return dialogMessage;
	}
	
	/*
	 * this method is used to remove the existed button by
	 * clicking the mouse right button
	 */
	public Component removeComponent(Component btnBox) {
		
		return btnBox;
	}

	public boolean isDotUsed(Point aDot) {
		return true;
	}
	
	public static void setRightTabbedPane(RightTabbedPane tabbedPane)
	{
		rightTabbedPane = tabbedPane;
	}
	
	public static Hashtable<String, TabInfo> getTabs()
	{
		if(tabs == null)
			tabs = new Hashtable<String, TabInfo>();
		return tabs;
	}
	
	public static void setTabs(Hashtable<String, TabInfo> tabTable)
	{
		tabs = tabTable;
	}
	
	public static RightTabbedPane getRightTabbedPane()
	{
		return rightTabbedPane;
	}
}
