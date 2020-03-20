import java.util.Hashtable;

import javax.swing.JTabbedPane;

public class RightTabbedPane extends JTabbedPane{
	
	RightTabbedPane()
	{
		if(Model.getTabs().size()==0)
			addWorkingAreaTab();
		Model.setRightTabbedPane(this);
	}
	
	public void load()
	{
		
	}
	
	public boolean addWorkingAreaTab(RightPanel tab)
	{
		boolean added = false;
		if(tab.getName() == null)
		{
			added = false;
		}
		else if(!Model.getTabs().containsKey(tab.getName()))
		{
			Model.getTabs().put(tab.getName(), new TabInfo(tab));
			added = true;
			add(tab.getName(),tab);
			tab.init();
		}
		System.out.println(added?"Tab added":"Tab not added");
		return added;
	}
	
	public void addWorkingAreaTab()
	{
		String init_name = "unnamedTab";
		String name = init_name;
		int count = 1;
		while(Model.getTabs().containsKey(name))
		{
			name = init_name + Integer.toString(count);
			count++;
		}
		//WorkingAreaTab tab = new WorkingAreaTab(name);
		RightPanel tab = new RightPanel(name);
		addWorkingAreaTab(tab);
	}
	
	public String getCurrentTabName()
	{
		return ((RightPanel)getSelectedComponent()).getName();
	}
	
	public RightPanel getCurrentTab()
	{
		return (RightPanel)getSelectedComponent();
	}
	
}