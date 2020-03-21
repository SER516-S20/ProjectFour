package view;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Compile;
import controller.FileManager;
import controller.Tab;
/**
 * 
 * @author Sheran
 * @since 03-08-2020
 * @Description: Menu will show different options available to users.
 */
public class Menu extends JMenuBar {
	
	private static final long serialVersionUID = 1L;

	Menu(RightPanel rightPanel){
		JMenu menu = new JMenu("Menu");
		JMenu newTab = new JMenu("New Space");
		JMenu compile = new JMenu("Compile");

		JMenuItem save = new JMenuItem("Save");
		JMenuItem open = new JMenuItem("Load");
		
		new Compile(compile);
		new FileManager(save, open);
		Tab.getInstance().initialize(newTab, rightPanel);
		
		this.add(menu);
		menu.add(save); 
		menu.add(open); 
		
		this.add(newTab);
		this.add(compile);
 
	}
	
}
