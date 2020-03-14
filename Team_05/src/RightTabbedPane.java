import java.util.Hashtable;

import javax.swing.JTabbedPane;

public class RightTabbedPane extends JTabbedPane{
	Hashtable<String,WorkingAreaTab> tabs;
	
	RightTabbedPane()
	{
		tabs = new Hashtable<String,WorkingAreaTab>();
	}
	
}
