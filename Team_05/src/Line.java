/**
 * @author ShihYu Chang
 */
import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class Line extends JPanel{
	private static final long serialVersionUID = 1L;
	private static int sourceX, sourceY, destX, destY;
	public void setSource(int tsourceX, int tsourceY) {
		sourceX = tsourceX;
		sourceY = tsourceY;
	}
	public void setDest(int tdestX, int tdestY) {
		destX = tdestX;
		destY = tdestY;
	}
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		/* make the line or text smooth */
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.drawLine(sourceX,sourceY,destX,destY);
		drawArrowHead(g2,new Point(destX, destY), new Point(sourceX, sourceY));
	}
	/*
	 * this method is used to draw arrow head in the tip of a line
	 */
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
