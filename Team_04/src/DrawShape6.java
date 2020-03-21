import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * 
 * @author Tarun Snehith Kishore Reddy Karna
 * @since 03-11-2020
 * @version 1.0
 *
 */


public class DrawShape6 extends DrawShape implements MouseListener, MouseMotionListener {
	private int currentX;
	private int currentY;
	private int relativeX;
	private int relativeY;
	private int HEIGHT = 60;
	private int WIDTH = 200;

	public DrawShape6(int posX, int posY, DrawingCanvas c) {
		super(c, 6, posX, posY);
		currentX = posX;
		currentY = posY;
		Dimension size = new Dimension(HEIGHT, WIDTH);
		this.setPreferredSize(size);
		this.setBounds(currentX, currentY, 200, 60);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paint(Graphics g) {
		g.setColor(Color.ORANGE);
		g.drawRect(1, 1, WIDTH - 5, HEIGHT - 5);
		g.setColor(Color.BLACK);
		g.fillRect(WIDTH/2-90, HEIGHT/2-20, 10, 40);
		g.fillRect(WIDTH-20, HEIGHT/2-20, 10, 40);
		g.drawString("||", WIDTH/2, HEIGHT/2);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		relativeX = currentX - e.getX();
		relativeY = currentY - e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x1 = e.getX();
		int y1 = e.getY();
		setLocation(x1 + relativeX, y1 + relativeY);
		currentX = x1 + relativeX;
		currentY = y1 + relativeY;
		for (int i = 0; i < super.connections.size(); i++) {
			Point[] shapePoints = super.connections.get(i);
			for (int j = 0; j < super.canvas.lineArray.size(); j++) {
				Point[] linePoints = super.canvas.lineArray.get(j);
				if (linePoints[0].equals(shapePoints[0])) {
					linePoints[0].x = currentX + shapePoints[1].x;
					linePoints[0].y = currentY + shapePoints[1].y;
					shapePoints[0].x = currentX + shapePoints[1].x;
					shapePoints[0].y = currentY + shapePoints[1].y;
				} else if (linePoints[1].equals(shapePoints[0])) {
					linePoints[1].x = currentX + shapePoints[1].x;
					linePoints[1].y = currentY + shapePoints[1].y;
					shapePoints[0].x = currentX + shapePoints[1].x;
					shapePoints[0].y = currentY + shapePoints[1].y;
				}
			}
			super.canvas.repaint();
		}
	}

	private int contain(int x, int y) {
		if (x > WIDTH/2-90 && x < WIDTH/2-80 && y > HEIGHT/2-20 && y < HEIGHT/2+20)
			return 0;
		else if(x > WIDTH-20 && x < WIDTH-10 && y > HEIGHT/2-20 && y < HEIGHT/2+20)
			return 2;
		else
			return -1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int index = this.contain(e.getX(), e.getY());
		if (this.contain(e.getX(), e.getY())>-1) {
			System.out.print("Square clicked");
			StoreClickPoints c1 = new StoreClickPoints(e.getX() + currentX, 
												e.getY() + currentY, this,index);

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}