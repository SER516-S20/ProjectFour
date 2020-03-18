import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Ashwin Srinivasan
 * @version 1.0
 * @since 03/18/2020
 */
public class DrawingArea extends JPanel {

	ArrayList<Shape> listOfShapes = new ArrayList<>();
	private static final int DRAWING_AREA_HEIGHT = 600;
	private static final int DRAWING_AREA_WIDTH = 800;

	DrawingArea() {
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(DRAWING_AREA_WIDTH, DRAWING_AREA_HEIGHT));
		MouseListener mouseListener = new MouseListener();
		addMouseListener(mouseListener);
		addMouseMotionListener(mouseListener);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < listOfShapes.size(); i++) {
			Object object = listOfShapes.get(i);
			if (object instanceof LessThanBracket) {

				LessThanBracket square = (LessThanBracket) object;
				square.draw(g);

			}
		}

	}

	void addSquare(LessThanBracket square) {
		listOfShapes.add(square);
		repaint();
	}

	void repaintOnDrag() {
		repaint();
	}

}
