import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import java.util.HashMap;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Snehith karna, Rohith Varma Gaddam
 * @since 1-28-2020
 * @updated 02-17-2020
 * @version 1.0
 */
public class DrawingCanvas extends JPanel implements MouseListener {
	private transient SelectedShape shape;
	public ArrayList<Point[]> lineArray = new ArrayList<Point[]>();
	public ArrayList<Object> shapeObject = new ArrayList<Object>();

	public DrawingCanvas() {
		shape = new SelectedShape();
		this.setLayout(null);
		addMouseListener(this);
	}

	public void load() {
		for (int i = 0; i < shapeObject.size(); i++) {
			DrawShape label = (DrawShape) shapeObject.get(i);
			label.canvas = this;
			this.add(label);
			this.repaint();
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		System.out.print("line drwan");
		System.out.print(lineArray.size());
		for (int i = 0; i < lineArray.size(); i++) {
			Point[] points = lineArray.get(i);
			System.out.println(points[0].x);
			System.out.println(points[0].y);
			System.out.println(points[1].x);
			System.out.println(points[1].y);
			g.drawLine(points[0].x, points[0].y, points[1].x, points[1].y);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(shape.No){
			case 1: DrawShape1 figure = new DrawShape1(e.getX() - 50, e.getY(), this);
			this.add((JLabel) figure);
			shapeObject.add(figure);
			this.repaint();
			break;
			
			case 2: DrawShape2 figure2 = new DrawShape2(e.getX() - 50, e.getY(), this);
			this.add((JLabel) figure2);
			shapeObject.add(figure2);
			this.repaint();
			break;
			
			case 3: DrawShape3 figure3 = new DrawShape3(e.getX() - 50, e.getY(), this);
			this.add((JLabel) figure3);
			shapeObject.add(figure3);
			this.repaint();
			break;

			case 4: DrawShape4 figure4 = new DrawShape4(e.getX() - 50, e.getY(), this);
			this.add((JLabel) figure4);
			shapeObject.add(figure4);
			this.repaint();
			break;

			case 5: DrawShape5 figure5 = new DrawShape5(e.getX() - 50, e.getY(), this);
			this.add((JLabel) figure5);
			shapeObject.add(figure5);
			this.repaint();
			break;
			
			case 6: DrawShape6 figure6 = new DrawShape6(e.getX() - 50, e.getY(), this);
			this.add((JLabel) figure6);
			shapeObject.add(figure6);
			this.repaint();
			break;

			case 7: DrawShape7 figure7 = new DrawShape7(e.getX() - 50, e.getY(), this);
			this.add((JLabel) figure7);
			shapeObject.add(figure7);
			this.repaint();
			break;
		}

	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}
}
