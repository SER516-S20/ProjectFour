import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 * 
 * @author Sree Pradeep Kumar Relangi
 * @since 03-14-2020
 *
 */
public class Compile implements ActionListener {
	private Frame frame;

	public Compile(Frame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!isBracesPresent())
			JOptionPane.showMessageDialog(null, "Compilation Failed", "Error", 1);
		else if (!isAllShapesConnected())
			JOptionPane.showMessageDialog(null, "Compilation Failed", "Error", 1);
		else
			JOptionPane.showMessageDialog(null, "Alright", "Alright", 1);
	}

	public Boolean isAllShapesConnected() {
		JTabbedPane pane = frame.getTabbedPane();
		int index = pane.getSelectedIndex();
		ArrayList<DrawingCanvas> array = frame.getCanvasArray();
		DrawingCanvas canvas = array.get(index);
		ArrayList<Object> shapes = canvas.shapeObject;
		for (int i = 0; i < shapes.size(); i++) {
			DrawShape currentShape = (DrawShape) shapes.get(i);
			if (currentShape.input[0] != null) {
				if ((int) currentShape.input[0].get(1) < 2) {
					return false;
				}
			}
			if (currentShape.input[1] != null) {
				if ((int) currentShape.input[1].get(1) < 2) {
					return false;
				}
			}
			if (currentShape.output[0] != null) {
				if ((int) currentShape.output[0].get(1) >= 2) {
					return false;
				}
			}
			if (currentShape.output[1] != null) {
				if ((int) currentShape.output[1].get(1) >= 2) {
					return false;
				}
			}
		}
		return true;
	}

	public Boolean isBracesPresent() {
		JTabbedPane pane = frame.getTabbedPane();
		int index = pane.getSelectedIndex();
		ArrayList<DrawingCanvas> array = frame.getCanvasArray();
		DrawingCanvas canvas = array.get(index);
		int open = 0, closed = 0;
		ArrayList<Object> shapes = canvas.shapeObject;
		for (int i = 0; i < shapes.size(); i++) {
			DrawShape currentShape = (DrawShape) shapes.get(i);
			if (open == 0 && currentShape.shapeNo == 1) {
				open = 1;
			}

			if (closed == 0 && currentShape.shapeNo == 2) {
				closed = 1;
			}
		}
		if (open == 1 && closed == 1)
			return true;

		return false;
	}

	public static void addActionListener(Compile compile) {
		// TODO Auto-generated method stub

	}
}