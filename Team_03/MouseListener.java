import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;

/**
 * This class is used to drag a particular shape and create a shape on mouse
 * click
 * 
 * @author Ashwin Srinivasan
 * @version 1.0
 * @since 03/18/2020
 */
class MouseListener extends MouseInputAdapter {
	static Shape selectedShape;
	public boolean activateDrag = false;
	static DrawingArea drawingArea;

	public void mousePressed(MouseEvent e) {
		Point startPoint = e.getPoint();
		int coordinateX = Math.min(startPoint.x, e.getX());
		int coordinateY = Math.min(startPoint.y, e.getY());

		if (isShapeClicked(coordinateX, coordinateY)) {
			activateDrag = true;
		} else {
			LessThanBracket square = new LessThanBracket();
			square.setPosition(coordinateX, coordinateY);
			Frame.mapDrawingAreas.get(Frame.currentTab).addSquare(square);
		}
	}

	public boolean checkBoundary(int x1, int y1, int x2, int y2) {
		if (x2 > x1 && y2 > y1 && x2 < (x1 + Constants.BRACKET_WIDTH) && y2 < (y1 + Constants.BRACKET_HEIGHT)) {
			return true;
		}
		return false;
	}

	public boolean isShapeClicked(int coordinateX, int coordinateY) {
		drawingArea = Frame.mapDrawingAreas.get(Frame.currentTab);
		List<Shape> listOfShapes = drawingArea.listOfShapes;
		int size = listOfShapes.size();
		for (int i = 0; i < size; i++) {
			Shape object = listOfShapes.get(i);
			if (checkBoundary(object.getCoordinateX(), object.getCoordinateY(), coordinateX, coordinateY)) {
				selectedShape = object;
				return true;
			}
		}
		return false;
	}

	public void mouseDragged(MouseEvent event) {
		int coordinateX = event.getX();
		int coordinateY = event.getY();

		if (activateDrag) {
			selectedShape.setPosition(coordinateX, coordinateY);
			drawingArea.repaintOnDrag();
		}
	}

}