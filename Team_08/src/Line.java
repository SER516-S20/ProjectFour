import java.awt.*;
import java.awt.geom.Line2D;

/**
 * @author Sandya Manoharan
 * @version 1.1
 */
public class Line {
	private int shapeX, shapeY, lineX, lineY;
	private Connections line;
	private boolean isSourceShape = false, isDestShape = false;

	public int getShapeX() {
		return shapeX;
	}

	public void setShapeX(int shapeX) {
		this.shapeX = shapeX;
	}

	public int getShapeY() {
		return shapeY;
	}

	public void setShapeY(int shapeY) {
		this.shapeY = shapeY;
	}

	public int getLineX() {
		return lineX;
	}

	public void setLineX(int lineX) {
		this.lineX = lineX;
	}

	public int getLineY() {
		return lineY;
	}

	public void setLineY(int lineY) {
		this.lineY = lineY;
	}

	public Connections getLine() {
		return line;
	}

	public void setLine(Connections line) {
		this.line = line;
	}

	public boolean isSourceShape() {
		return isSourceShape;
	}

	public void setSourceShape(boolean isSourceShape) {
		this.isSourceShape = isSourceShape;
	}

	public boolean isDestShape() {
		return isDestShape;
	}

	public void setDestShape(boolean isDestShape) {
		this.isDestShape = isDestShape;
	}

	private void drawArrowHead(Graphics2D g2, Point tip, Point tail) {
		int length = 10;
		double phi = Math.toRadians(30);
		double dy = tip.y - tail.y;
		double dx = tip.x - tail.x;
		double theta = Math.atan2(dy, dx);
		double x, y, rho = theta + phi;
		for(int i = 0; i < 2; i++) {
			x = tip.x - length * Math.cos(rho);
			y = tip.y - length * Math.sin(rho);
			g2.draw(new Line2D.Double(tip.x, tip.y, x, y));
			rho = theta - phi;
		}
	}

}
