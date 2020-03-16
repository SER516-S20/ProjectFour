package view;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Compile;
import controller.FileManager;
import controller.NewTab;
/**
 * 
 * @author Suyog
 * @since 02-18-2020
 */
public class Menu extends JMenuBar{
	Menu(RightPanel rightPanel){
		JMenu menu = new JMenu("Menu");
		JMenu newTab = new JMenu("New Space");
		JMenu compile = new JMenu("Compile");

		JMenuItem save = new JMenuItem("Save");
		JMenuItem open = new JMenuItem("Load");
		
		new Compile(compile);
		new FileManager(save, open);
		NewTab.getInstance().initialize(newTab, rightPanel);
		
		this.add(menu);
		menu.add(save); 
		menu.add(open); 
		
		this.add(newTab);
		this.add(compile);
 
	}
}
