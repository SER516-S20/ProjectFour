
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ShapeOpenParan extends JButton{
	
	private static final long serialVersionUID = 1L;

	public ShapeOpenParan() {
		
		JPanel objCirclePane = new JPanel();
		repaint();
		objCirclePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		objCirclePane.setSize(100,100);
		objCirclePane.setLayout(null);
	}

	@Override
	public void paintComponent(Graphics objGraphics) {

		try {
			Graphics2D obj2D = (Graphics2D) objGraphics;
			Shape objCircle = new Ellipse2D.Double(105, 60, 80, 80);
			obj2D.draw(objCircle);
			obj2D.fillOval(105 + 40 - 3, 60 + 40 - 3, 6, 6);
			// Connections c = new Connections();
			// c.DotToBarConnection(obj2D, 100, 120, 180, 200);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
