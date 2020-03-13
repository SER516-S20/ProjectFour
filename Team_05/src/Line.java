/**
 * @author ShihYu Chang
 */
import java.awt.*;
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
	}
}
