import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
/**
 * 
 * @author Rohith Varma Gaddam
 * @since  03-14-2020
 *
 */
public class NewSpace implements ActionListener {
	private Frame frame;
	public NewSpace(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTabbedPane tabbedPane = frame.getTabbedPane();
		int count = tabbedPane.getTabCount();
		count = count+1;
		DrawingCanvas c = new DrawingCanvas();
		tabbedPane.add("Tab"+count,c);
		ArrayList<DrawingCanvas> canvasArray = frame.getCanvasArray();
		canvasArray.add(c);
		System.out.println("size of canvas array"+canvasArray.size());
		frame.setCanvasArray(canvasArray);
		frame.setTabbedPane(tabbedPane);
	}

	public static void addActionListener(NewSpace newspace) {
		// TODO Auto-generated method stub
	}
}