import java.awt.Component;
import java.awt.Point;
import java.util.Hashtable;

public class Model {
	private static RightTabbedPane rightTabbedPane;
	private static Hashtable<String, TabInfo> tabs;
	private static Frame frame;
	private static String dialogMessage;
	
	public void setFrame(Frame theFrame) {
		frame = theFrame;
	}
	
	public Frame getFrame() {
		return frame;
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
