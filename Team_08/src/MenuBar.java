import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
/**
 *
 * @author Kartik Mathpal
 * @version 1.0
 */

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	MenuBar() {
		String MENU = "Menu";
		JMenu menu = new JMenu(MENU);
		JMenuBar menuBar = new JMenuBar();
		String SAVE = "Save";
		SaveFile saveFile = new SaveFile(SAVE);
		saveFile.addActionListener(saveFile);
		String LOAD = "Load";
		LoadFile loadFile = new LoadFile(LOAD);
		loadFile.addActionListener(loadFile);
		String COMPILE = "Compile";
		CompileFile compileFile = new CompileFile(COMPILE);
		compileFile.addActionListener(compileFile);
		menu.add(saveFile);
		menu.add(loadFile);
		menu.add(compileFile);
		menuBar.add(menu);

		JButton NewTab = new JButton("  New Tab  ");
		Border border = new LineBorder(Color.BLACK, 1);
		NewTab.setBorder(border);
		NewTab.addActionListener(e -> {
			//TO DO: write action to create new tab
			if (e.getActionCommand().equals("  New Tab  ")) {
				System.out.println("New Tab has been clicked");
			}
		});
		JButton Compiler = new JButton("  Compile  ");
		Compiler.setBorder(border);
		Compiler.addActionListener(e -> {
		});
		this.add(menuBar);
	}

}
