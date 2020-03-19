import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
/**
 *
 * @author Kartik Mathpal
 * @version 1.0
 */

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem load, save, compile;
	private final String SAVE = "Save";
	private final String LOAD = "Load";
	private final String MENU = "Menu";
	private final String COMPILE = "Compile";

	MenuBar() {
		menu = new JMenu(MENU);
		menuBar = new JMenuBar();
		SaveFile saveFile = new SaveFile(SAVE);
		save = saveFile;
		save.addActionListener(saveFile);
		LoadFile loadFile = new LoadFile(LOAD);
		load = loadFile;
		load.addActionListener(loadFile);
		CompileFile compileFile = new CompileFile(COMPILE);
		compile = compileFile;
		compile.addActionListener(compileFile);
		menu.add(save);
		menu.add(load);
		menu.add(compile);
		menuBar.add(menu);

		JButton NewTab = new JButton("  New Tab  ");
		Border border = new LineBorder(Color.BLACK, 1);
		NewTab.setBorder(border);
		NewTab.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//TO DO: write action to create new tab
				if (e.getActionCommand().equals("  New Tab  ")) {
					System.out.println("New Tab has been clicked");
				}
			}
		});
//		menuBar.add(NewTab);
		JButton Compiler = new JButton("  Compile  ");
		Compiler.setBorder(border);
		Compiler.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//TO DO: write action to compile
			}
		});
//		menuBar.add(Compiler);
		this.add(menuBar);
	}

}
